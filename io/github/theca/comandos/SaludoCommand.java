package io.github.theca.comandos;

import java.util.Scanner;

public class SaludoCommand {
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("¡Hola, " + nombre + "! Bienvenido al sistema.");
    }
}
