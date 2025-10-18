import java.util.Scanner;

public class sistemaNumerico {

public static void main(String[] args)
{ Scanner scanner = new Scanner(System.in);
        System.out.print("Digite un número: ");
        int numero = scanner.nextInt();  // Leer un número entero desde la entrada estándar
        // Convertir el número a diferentes sistemas numéricos
        String numeroBinario = Integer.toBinaryString(numero);
        String numeroOctal = Integer.toOctalString(numero);
        String numeroHexadecimal = Integer.toHexString(numero);
        // Mostrar los resultados

        System.out.println("Número Decimal de "+ numero + " = " + numero);
        System.out.println("Número Binario de "+ numero + " = " + numeroBinario);
        System.out.println("Número Octal de "+ numero + " = " + numeroOctal);
        System.out.println("Número Hexadecimal de "+ numero + " = " + numeroHexadecimal);
scanner.close();
}
}