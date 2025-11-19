

public class EjemploTestRendimiento {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a;


StringBuilder sb = new StringBuilder(a);

        Long inicio = System.currentTimeMillis();
        //aplicamos un for para repetir la concatenación muchas veces y medir el tiempo
        for (int i =0; i< 100000 ; i++){
        //concatenación con StringBuilder usando append para optimizar
        sb.append(a).append(b).append("\n");

        }

        Long fin = System.currentTimeMillis();
        //System.out.println("c = " + c);
        System.out.println("sb = " + sb.toString());
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
    }
}