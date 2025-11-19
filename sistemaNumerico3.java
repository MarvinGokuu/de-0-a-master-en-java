import javax.swing.JOptionPane;

public class sistemaNumerico3 {
    public static void main(String[] args) {
        int numero = 0;
        String numeroBinario = "";
        String numeroOctal = "";
        String numeroHexadecimal = "";
        boolean valido = false;

        // 1. Bucle para solicitar un número válido
        while (!valido) {
            try {
                String entrada = JOptionPane.showInputDialog("Digite un número:");
                if (entrada == null) { // Si presiona Cancelar
                    JOptionPane.showMessageDialog(null, "No se ingresó ningún número. El programa finalizará.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                numero = Integer.parseInt(entrada);
                valido = true; // Entrada correcta
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Entrada inválida: Debes escribir un número entero.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
        // 2. Convertir el número a diferentes sistemas numéricos
            numeroBinario = Integer.toBinaryString(numero);
            numeroOctal = Integer.toOctalString(numero);
            numeroHexadecimal = Integer.toHexString(numero).toUpperCase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrió un error al convertir el número: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Crear el mensaje con formato
        String resultado = """
                ╔════════════════════════════════════╗
                    CONVERSIÓN DE SISTEMAS NUMÉRICOS
                ╚════════════════════════════════════╝

                Número ingresado: %d

                ➤ Binario       = %s
                ➤ Octal         = %s
                ➤ Hexadecimal   = %s
                """.formatted(numero, numeroBinario, numeroOctal, numeroHexadecimal);

        // 4. Mostrar resultados en un cuadro informativo
        JOptionPane.showMessageDialog(
                null,
                resultado,
                "Resultado de Conversión",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
