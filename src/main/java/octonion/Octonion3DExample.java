package octonion;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/* -------------------------
   JavaFX Application
   ------------------------- */
public class Octonion3DExample extends Application {

    // Ruta del archivo (imagen que subiste). Devuelve EXACTAMENTE la ruta local:
    // /mnt/data/A_2D_digital_vector_illustration_depicts_the_Fano_.png
    // El código la carga como: new Image("file:" + TEXTURE_PATH)
    private static final String TEXTURE_PATH = "/mnt/data/A_2D_digital_vector_illustration_depicts_the_Fano_.png";

    /**
     * integrar root3D
     */
    private Group root3D;

    // Objetos inicial positions (vectores en R^3)
    private double[][] initialPositions = {
            { -200, 0, 0 }, // left
            { 200, 0, 0 }, // right
            { 0, 150, 0 } // top
    };

    private Node[] nodes = new Node[3];

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Sub-scene 3D
        root3D = new Group();

        // Cámara
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);

        // Luz
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(-400);
        light.setTranslateY(-200);
        light.setTranslateZ(-800);
        root3D.getChildren().add(light);

        // Crear objetos
        Box box = new Box(80, 80, 80);
        Sphere sphere = new Sphere(45);
        Box box2 = new Box(50, 50, 120);

        // Material con textura (si existe el archivo)
        PhongMaterial matBox = new PhongMaterial(Color.GRAY);
        try {
            Image tex = new Image("file:" + TEXTURE_PATH);
            matBox.setDiffuseMap(tex);
        } catch (Exception ex) {
            // si no se encuentra, dejamos material liso
            System.out.println("No se pudo cargar textura desde: " + TEXTURE_PATH);
        }
        box.setMaterial(matBox);
        sphere.setMaterial(new PhongMaterial(Color.CORNFLOWERBLUE));
        box2.setMaterial(new PhongMaterial(Color.DARKORANGE));

        nodes[0] = box;
        nodes[1] = sphere;
        nodes[2] = box2;

        // Colocar en posiciones iniciales
        for (int i = 0; i < nodes.length; i++) {
            Node n = nodes[i];
            double[] p = initialPositions[i];
            n.setTranslateX(p[0]);
            n.setTranslateY(p[1]);
            n.setTranslateZ(p[2]);
            root3D.getChildren().add(n);
        }

        // Crear subscene 3D
        SubScene subScene = new SubScene(root3D, 900, 700, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.BLACK);
        subScene.setCamera(camera);

        Group root = new Group();
        root.getChildren().add(subScene);

        Scene scene = new Scene(root, 900, 700, true);
        primaryStage.setTitle("Octonion D4 — Rotaciones octoniónicas (experimental)");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Animación: crear un octonión O(t) cambiante y aplicar conjugación a cada
        // vector
        AnimationTimer timer = new AnimationTimer() {
            long last = 0;

            @Override
            public void handle(long now) {
                if (last == 0) {
                    last = now;
                    return;
                }
                double t = (now / 1e9); // segundos
                updateWithOctonion(t);
                last = now;
            }
        };
        timer.start();

        // Controles: acercar/alejar con teclas (+ / -)
        scene.setOnKeyPressed(ev -> {
            if (ev.getCode() == KeyCode.PLUS || ev.getCode() == KeyCode.EQUALS) {
                camera.setTranslateZ(camera.getTranslateZ() + 50);
            } else if (ev.getCode() == KeyCode.MINUS) {
                camera.setTranslateZ(camera.getTranslateZ() - 50);
            }
        });
    }

    // Aplica la conjugación por un octonión a cada posición inicial y actualiza los
    // nodos.
    private void updateWithOctonion(double t) {
        // Construimos un octonión unitario O(t).
        // Aquí hacemos una mezcla: la parte (a0,a1,a2,a3) actúa como un "cuaternion"
        // que rota alrededor de (1,1,0). Añadimos componentes en e4..e7 para introducir
        // efectos octoniónicos.
        double ang = t * 0.6; // velocidad
        double qa0 = Math.cos(ang / 2.0);
        double qv = Math.sin(ang / 2.0);
        // quaternion-axis (x,y,z)
        double nx = Math.cos(t * 0.3);
        double ny = Math.sin(t * 0.3);
        double nz = 0.2 * Math.cos(t * 0.1);
        // normalizar axis
        double mag = Math.sqrt(nx * nx + ny * ny + nz * nz);
        nx /= mag;
        ny /= mag;
        nz /= mag;

        // components e4..e7 (pequeños oscilantes) para introducir "octonionic twist"
        double e4 = 0.08 * Math.sin(t * 0.9);
        double e5 = 0.06 * Math.cos(t * 0.7);
        double e6 = 0.04 * Math.sin(t * 1.3);
        double e7 = 0.03 * Math.cos(t * 0.5);

        Octonion O = new Octonion(qa0, qv * nx, qv * ny, qv * nz, e4, e5, e6, e7).normalize();

        Octonion Oinv = O.inverse();

        // Para cada nodo, toma su posición inicial, incrústala en un octonion puro V,
        // calcula V' = (O*V)*Oinv
        for (int i = 0; i < nodes.length; i++) {
            double[] p0 = initialPositions[i];
            Octonion V = new Octonion(0, p0[0], p0[1], p0[2], 0, 0, 0, 0);
            Octonion tmp = O.mul(V).mul(Oinv); // (O * V) * O^{-1}
            // proyectamos a e1,e2,e3
            double rx = tmp.a1;
            double ry = tmp.a2;
            double rz = tmp.a3;
            // aplicamos a la posición del nodo
            Node n = nodes[i];
            // suavizado opcional: interpolación (aquí directo)
            n.setTranslateX(rx);
            n.setTranslateY(ry);
            n.setTranslateZ(rz);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
