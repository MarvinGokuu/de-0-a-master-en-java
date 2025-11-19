//el Usuario va a escribir el tiempo de ejecución
import java.util.Scanner;
public class EjemploTestRendimiento2 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a;
        Double tiempoEjecucion = 0.0;
Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tiempo de ejecución en milisegundos: ");
        if (scanner.hasNextDouble()) {
            tiempoEjecucion = scanner.nextDouble();
        } else {
            System.out.println("Entrada inválida. Usando valor predeterminado de 100000 ms.");
            tiempoEjecucion = 100000.0;
        }
        scanner.close();

StringBuilder sb = new StringBuilder(a);

        Long inicio = System.currentTimeMillis();
        //aplicamos un for para repetir la concatenación muchas veces y medir el tiempo
        for (int i =0; i< tiempoEjecucion ; i++){
        //concatenación con StringBuilder usando append para optimizar
        sb.append(a).append(b).append("\n");

        }

        Long fin = System.currentTimeMillis();
        //System.out.println("c = " + c);
        System.out.println("sb = " + sb.toString());
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
    }
}