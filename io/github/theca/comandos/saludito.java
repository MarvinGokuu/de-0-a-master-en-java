package io.github.theca.comandos;

import java.util.Scanner;

public class saludito {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== CONSOLA INTERACTIVA ===");
        System.out.println("Comandos disponibles: saludo, salir\n");

        while (true) {
            System.out.print("> ");
            String comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "saludo":
                    SaludoCommand.ejecutar();
                    break;
                case "salir":
                    System.out.println(" Saliendo...");
                    return;
                default:
                    System.out.println("Comando no reconocido.");
            }
        }
    }
}
