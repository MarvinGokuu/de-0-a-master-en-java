package io.github.theca.utils;

public class HolaMundo {
    public static void main(String[] args) throws InterruptedException {
        String saludar = "Hola Mundo desde Java!";

        System.out.println("Saludo animado y evolutivo (compatible con cualquier terminal de Windows):\n");

        // 1️⃣ Animación letra por letra
        escribirConAnimacion(saludar, 100);

        // 2️⃣ Texto desplazándose horizontalmente (marquee)
        for (int i = 0; i < 20; i++) {
            System.out.print("\r" + " ".repeat(i) + saludar);
            Thread.sleep(150);
        }
        System.out.println();

        // 3️⃣ Texto con asteriscos delante de cada letra
        for (char c : saludar.toCharArray()) {
            System.out.print("*" + c);
            Thread.sleep(80);
        }
        System.out.println();
    }

    // Método para animación letra por letra
    private static void escribirConAnimacion(String texto, int delayMillis) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delayMillis);
        }
        System.out.println(); // salto de línea al final
    }
}

