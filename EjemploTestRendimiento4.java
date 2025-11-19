//aplicamos paso 3 y 4
// mostrar el mensaje en pantalla usando JOptionPane
//
//import java.util.Scanner;
import javax.swing.JOptionPane;
public class EjemploTestRendimiento4 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a;
        long iteraciones = 0;
                boolean entradaValida = false;
        String nEntrada = null;
        int numeroInt = 0; // Inicializar para que el try-catch se maneje mejor

        // 1. Bucle para solicitar un número válido
        do {
            nEntrada = JOptionPane.showInputDialog("Ingrese el tiempo de ejecución en segundos:");

            // Si presiona Cancelar o cierra el diálogo
            if (nEntrada == null) {
                // Finaliza la aplicación limpiamente
                System.exit(0);
            }

            try {
                // Si la entrada es correcta (2a parte del punto 1)
                numeroInt = Integer.parseInt(nEntrada);
                entradaValida = true; // Salir del bucle
            } catch (NumberFormatException e) {
                // La entrada no es un número válido
                JOptionPane.showMessageDialog(null,
                        "\"" + nEntrada + "\" no es un tiempo de ejecución válido.",
                        "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!entradaValida);
//Scanner scanner = new Scanner(System.in);
//        System.out.print("Ingrese el tiempo de ejecución en milisegundos: ");
//        if (scanner.hasNextDouble()) {
//            tiempoEjecucion = scanner.nextDouble();
//        } else {
//            System.out.println("Entrada inválida. Usando valor predeterminado de 100000 ms.");
//scanner.close();
//}
StringBuilder sb = new StringBuilder(a);

        long inicio = System.currentTimeMillis();
        //aplicamos un for para repetir la concatenación muchas veces y medir el tiempo
        for (int i = 0; i < iteraciones; i++) {
        //concatenación con StringBuilder usando append para optimizar
        sb.append(a).append(b).append("\n");
    }

        long fin = System.currentTimeMillis();

// 3. Crear el mensaje con formato
String mensaje = String.format(
    "╔════════════════════════════════════╗\n" +
    "   RESULTADO DEL TEST DE RENDIMIENTO \n" +
    "╚════════════════════════════════════╝\n\n" +
    "Número de iteraciones: %d\n",
    iteraciones
);
// 4. Mostrar el mensaje en pantalla usando JOptionPane
JOptionPane.showMessageDialog(null, mensaje);
JOptionPane.showMessageDialog(null, "El programa ha finalizado", "Info", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("sb = " + sb.toString());
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");

    }
}
// paso 1: importar la librería
//import javax.swing.JOptionPane;

//paso 2: usar la librería
//tipo dato + variable = + metodo Integer.parseInt(JOptionPane.showInputDialog("mensaje "));
//String nEntrada = Integer.parseInt(JOptionPane.showInputDialog("mensaje "));

// 3. Crear el mensaje con formato
//JOptionPane.showMessageDialog(null, "mensaje");
/*JOptionPane.showMessageDialog(null, "Esto es información", "Info", JOptionPane.INFORMATION_MESSAGE);

// paso 4: otros tipos de mensajes
// mensaje 1 = información
// mensaje 2 = advertencia
// mensaje 3 = error
// mensaje 4 = pregunta
// mensaje 5 = mensaje simple
// mensaje 6 = mensaje plano
// mensaje 7 = mensaje personalizado
//m1 = JOptionPane.showMessageDialog(null, "Esto es información", "Info", JOptionPane.INFORMATION_MESSAGE);
//m2 = JOptionPane.showMessageDialog(null, "Esto es una advertencia", "Cuidado", JOptionPane.WARNING_MESSAGE);
//m3 = JOptionPane.showMessageDialog(null, "Esto es un error", "Error", JOptionPane.ERROR_MESSAGE);
//m4 = JOptionPane.showMessageDialog(null, "Esto es una pregunta", "Pregunta", JOptionPane.QUESTION_MESSAGE);
//m5 = JOptionPane.showMessageDialog(null, "Esto es un mensaje simple", "Simple", JOptionPane.PLAIN_MESSAGE);
//m6 = JOptionPane.showMessageDialog(null, "Esto es un mensaje plano", "Plano", JOptionPane.PLAIN_MESSAGE);
//m7 = JOptionPane.showMessageDialog(null, "Esto es un mensaje personalizado", "
//" + "Custom", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("ruta/a/imagen.png"));
 */



 