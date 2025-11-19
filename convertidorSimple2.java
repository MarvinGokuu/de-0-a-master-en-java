import javax.swing.JOptionPane;

public class convertidorSimple2 {

    public static void main(String[] args) {

        System.out.print("Ingrese un número entero: ");
        String nEntrada = JOptionPane.showInputDialog("Ingrese un número entero: ");

        try {
            int numeroPrimitivo = Integer.parseInt(nEntrada); // String -> int
            JOptionPane.showMessageDialog(null, "El número primitivo es: " + numeroPrimitivo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: Debes escribir un número entero.");
        }
    }
}
// paso 1: importar la librería
//import javax.swing.JOptionPane;
//paso 2: usar la librería
//tipo dato + variable = + metodo Integer.parseInt(JOptionPane.showInputDialog("mensaje "));
//String nEntrada = Integer.parseInt(JOptionPane.showInputDialog("mensaje "));
//paso 3: mostrar mensaje
//JOptionPane.showMessageDialog(null, "mensaje");
/*JOptionPane.showMessageDialog(null, "Esto es información", "Info", JOptionPane.INFORMATION_MESSAGE);
// paso 4: otros tipos de mensajes
// mensaje 1 = información
// mensaje 2 = advertencia
// mensaje 3 = error
// mensaje 4 = pregunta
// mensaje 5 = mensaje simple
// mensaje 6 = mensaje plano
// mensaje 7 = mensaje personalizado
//m1 = JOptionPane.showMessageDialog(null, "Esto es información", "Info", JOptionPane.INFORMATION_MESSAGE);
//m2 = JOptionPane.showMessageDialog(null, "Esto es una advertencia", "Cuidado", JOptionPane.WARNING_MESSAGE);
//m3 = JOptionPane.showMessageDialog(null, "Esto es un error", "Error", JOptionPane.ERROR_MESSAGE);
//m4 = JOptionPane.showMessageDialog(null, "Esto es una pregunta", "Pregunta", JOptionPane.QUESTION_MESSAGE);
//m5 = JOptionPane.showMessageDialog(null, "Esto es un mensaje simple", "Simple", JOptionPane.PLAIN_MESSAGE);
//m6 = JOptionPane.showMessageDialog(null, "Esto es un mensaje plano", "Plano", JOptionPane.PLAIN_MESSAGE);
//m7 = JOptionPane.showMessageDialog(null, "Esto es un mensaje personalizado", "
//" + "Custom", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("ruta/a/imagen.png"));
 */