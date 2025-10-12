/* package io.github.jiangdequan;

public class Primitivos {
public static void main(String[] args) {
        // tipos primitivos en Java
        byte numeroByte = 7;
        int numeroEntero = 10;          // entero
        double numeroDecimal = 10.5;    // decimal
        char caracter = 'A';            // carácter
        boolean esVerdadero = true;     // booleano

        // imprimimos en consola
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("Número Entero: " + numeroEntero);
        System.out.println("Número Decimal: " + numeroDecimal);
        System.out.println("Carácter: " + caracter);
        System.out.println("Es Verdadero: " + esVerdadero);
    }
}*/
package io.github.theca.utils;


import java.util.Scanner;

public class PrimitivosAsistente {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ASISTENTE DE TIPOS PRIMITIVOS EN JAVA ===");
        System.out.print("👉 Ingresa un valor: ");
        String entrada = scanner.nextLine();

        try {
            // Intentar número entero
            long valorLong = Long.parseLong(entrada);
            System.out.println("\n✅ \"" + entrada + "\" es un número entero.");

            if (valorLong >= Byte.MIN_VALUE && valorLong <= Byte.MAX_VALUE) {
                System.out.println("  → Se puede almacenar en: byte (1 byte)");
                System.out.println("💡 Recomendación: usa 'byte' si es un contador pequeño o dato binario.");
            } else if (valorLong >= Short.MIN_VALUE && valorLong <= Short.MAX_VALUE) {
                System.out.println("  → Se puede almacenar en: short (2 bytes)");
                System.out.println("💡 Recomendación: usa 'short' para listas grandes de valores pequeños (como píxeles o IDs).");
            } else if (valorLong >= Integer.MIN_VALUE && valorLong <= Integer.MAX_VALUE) {
                System.out.println("  → Se puede almacenar en: int (4 bytes)");
                System.out.println("💡 Recomendación: usa 'int' para operaciones matemáticas, contadores o índices.");
            } else {
                System.out.println("  → Se puede almacenar en: long (8 bytes)");
                System.out.println("💡 Recomendación: usa 'long' para números muy grandes (ej. dinero, IDs únicos, tiempo UNIX).");
            }

        } catch (NumberFormatException e1) {
            try {
                // Intentar número decimal
                double valorDouble = Double.parseDouble(entrada);
                System.out.println("\n✅ \"" + entrada + "\" es un número decimal.");

                System.out.println("  → Se puede almacenar en: float o double");
                if (Math.abs(valorDouble) < Float.MAX_VALUE) {
                    System.out.println("💡 Recomendación: usa 'float' si necesitas ahorrar memoria (gráficos, juegos).");
                } else {
                    System.out.println("💡 Recomendación: usa 'double' si necesitas precisión alta (cálculos científicos, finanzas).");
                }

            } catch (NumberFormatException e2) {
                if (entrada.length() == 1) {
                    char caracter = entrada.charAt(0);
                    System.out.println("\n✅ \"" + entrada + "\" es un carácter (char).");
                    System.out.println("  → Código Unicode: " + (int) caracter);
                    System.out.println("💡 Recomendación: usa 'char' para representar letras, símbolos o caracteres ASCII.");
                } else if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
                    System.out.println("\n✅ \"" + entrada + "\" es un valor booleano (true/false).");
                    System.out.println("💡 Recomendación: usa 'boolean' para condiciones, banderas lógicas o decisiones.");
                } else {
                    System.out.println("\n⚠ No se pudo identificar el tipo primitivo de \"" + entrada + "\".");
                    System.out.println("💡 Recomendación: podrías usar 'String' si es texto o palabra completa.");
                }
            }
        }

        scanner.close();
    }
}
