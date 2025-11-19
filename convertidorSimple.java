import java.util.Scanner;

public class convertidorSimple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        String nEntrada = scanner.nextLine();

        try {
            int numeroPrimitivo = Integer.parseInt(nEntrada); // String -> int
            System.out.println("El número primitivo es: " + numeroPrimitivo);

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida: Debes escribir un número entero.");
        }

        scanner.close();
    }
}
