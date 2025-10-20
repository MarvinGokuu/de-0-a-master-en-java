import javax.swing.JOptionPane;
public class sistemaNumerico2 {
public static void main (String[]args) {
int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un número: "));
        // Convertir el número a diferentes sistemas numéricos
        String numeroBinario = Integer.toBinaryString(numero);
        String numeroOctal = Integer.toOctalString(numero);
        String numeroHexadecimal = Integer.toHexString(numero);
        // Mostrar los resultados
        String resultado = "\nNúmero Binario " + "             = " + numeroBinario +
                        "\nNúmero Octal " + "                = " + numeroOctal +
                        "\nNúmero Hexadecimal " + "          = " + numeroHexadecimal;
        // Mostrar resultados en un cuadro de diálogo informativo
        JOptionPane.showMessageDialog(null,"El número " + numero + " en otros sistemas numéricos es: " + resultado);
}
}
//import javax.swing.JOptionPane;
//tipo dato variable = Integer.parseInt(JOptionPane.showInputDialog("mensaje "));
// JOptionPane.showMessageDialog(null, "mensaje");
/*  JOptionPane.showMessageDialog(null, "Esto es información", "Info", JOptionPane.INFORMATION_MESSAGE);
JOptionPane.showMessageDialog(null, "Esto es una advertencia", "Cuidado", JOptionPane.WARNING_MESSAGE);
JOptionPane.showMessageDialog(null, "Esto es un error", "Error", JOptionPane.ERROR_MESSAGE);
JOptionPane.showMessageDialog(null, "Esto es una pregunta", "Pregunta", JOptionPane.QUESTION_MESSAGE);
JOptionPane.showMessageDialog(null, "Esto es un mensaje simple", "Simple", JOptionPane.PLAIN_MESSAGE);
 */