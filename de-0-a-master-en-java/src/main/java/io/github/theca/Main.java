package io.github.theca;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ASISTENTE DE TIPOS PRIMITIVOS EN JAVA ===");
        System.out.print("👉 Ingresa un valor: ");
        String input = scanner.nextLine();

        try {
            long number = Long.parseLong(input);
            System.out.println("\n✅ \"" + input + "\" es un número entero.");
            if (number >= -128L && number <= 127L) {
                System.out.println("  → Se puede almacenar en: byte (1 byte)");
                System.out.println("💡 Recomendación: usa 'byte' si es un contador pequeño o dato binario.");
            } else if (number >= -32768L && number <= 32767L) {
                System.out.println("  → Se puede almacenar en: short (2 bytes)");
                System.out.println("💡 Recomendación: usa 'short' para listas grandes de valores pequeños (como píxeles o IDs).");
            } else if (number >= -2147483648L && number <= 2147483647L) {
                System.out.println("  → Se puede almacenar en: int (4 bytes)");
                System.out.println("💡 Recomendación: usa 'int' para operaciones matemáticas, contadores o índices.");
            } else {
                System.out.println("  → Se puede almacenar en: long (8 bytes)");
                System.out.println("💡 Recomendación: usa 'long' para números muy grandes (ej. dinero, IDs únicos, tiempo UNIX).");
            }
        } catch (NumberFormatException e1) {
            try {
                double decimal = Double.parseDouble(input);
                System.out.println("\n✅ \"" + input + "\" es un número decimal.");
                System.out.println("  → Se puede almacenar en: float o double");
                if (Math.abs(decimal) < Float.MAX_VALUE) {
                    System.out.println("💡 Recomendación: usa 'float' si necesitas ahorrar memoria (gráficos, juegos).");
                } else {
                    System.out.println("💡 Recomendación: usa 'double' si necesitas precisión alta (cálculos científicos, finanzas).");
                }
            } catch (NumberFormatException e2) {
                if (input.length() == 1) {
                    char character = input.charAt(0);
                    System.out.println("\n✅ \"" + input + "\" es un carácter (char).");
                    System.out.println("  → Código Unicode: " + (int) character);
                    System.out.println("💡 Recomendación: usa 'char' para representar letras, símbolos o caracteres ASCII.");
                } else if (!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")) {
                    System.out.println("\n⚠ No se pudo identificar el tipo primitivo de \"" + input + "\".");
                    System.out.println("💡 Recomendación: podrías usar 'String' si es texto o palabra completa.");
                } else {
                    System.out.println("\n✅ \"" + input + "\" es un valor booleano (true/false).");
                    System.out.println("💡 Recomendación: usa 'boolean' para condiciones, banderas lógicas o decisiones.");
                }
            }
        }

        scanner.close();
    }
}
