public class HolaMundo {

    public static void mostrarSaludo() throws InterruptedException {
        String saludar = "Hola Mundo desde Java!";
        System.out.println("\nSaludo animado y evolutivo:\n");
        escribirConAnimacion(saludar, 100);
        for (int i = 0; i < 20; i++) {
            System.out.print("\r" + " ".repeat(i) + saludar);
            Thread.sleep(150);
        }
        System.out.println();

        for (char c : saludar.toCharArray()) {
            System.out.print("*" + c);
            Thread.sleep(80);
        }
        System.out.println("\n");
    }

    private static void escribirConAnimacion(String texto, int delayMillis) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delayMillis);
        }
        System.out.println();
    }
}
