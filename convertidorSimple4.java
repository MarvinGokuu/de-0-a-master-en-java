import javax.swing.JOptionPane;

public class convertidorSimple4 {

    public static void main(String[] args) {

        boolean entradaValida = false;
        String nEntrada = null;
        int numeroInt = 0; // Inicializar para que el try-catch se maneje mejor

        // 1. Bucle para solicitar un número válido
        do {
            nEntrada = JOptionPane.showInputDialog("Ingrese un número entero:");

            // Si presiona Cancelar o cierra el diálogo
            if (nEntrada == null) {
                // Finaliza la aplicación limpiamente
                System.exit(0);
            }

            try {
                // Si la entrada es correcta (2a parte del punto 1)
                numeroInt = Integer.parseInt(nEntrada);
                entradaValida = true; // Salir del bucle
            } catch (NumberFormatException e) {
                // La entrada no es un número válido
                JOptionPane.showMessageDialog(null,
                        "\"" + nEntrada + "\" no es un número entero válido. Intente de nuevo.",
                        "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!entradaValida);


        // 2. Convertir el número a diferentes tipos de datos numéricos
        // Conversiones a primitivos (con casting explícito necesario para byte/short)
        byte numeroByte = (byte) numeroInt;
        short numeroShort = (short) numeroInt;
        long numeroLong = numeroInt;      // Conversión de ampliación implícita
        float numeroFloat = numeroInt;    // Conversión de ampliación implícita
        double numeroDouble = numeroInt;  // Conversión de ampliación implícita

        // Conversiones a objetos envolventes (Autoboxing)
        Integer objInteger = numeroInt;
        Byte objByte = numeroByte;
        Short objShort = numeroShort;
        Long objLong = numeroLong;
        Float objFloat = numeroFloat;
        Double objDouble = numeroDouble;


        // 3. Crear el mensaje con formato (usando String.format y emojis para mejor presentación)
        String mensaje = String.format(
            "╔═════════════════════════════════════════════╗\n" +
            "║  CONVERSIÓN DE TIPOS DE DATOS NUMÉRICOS ║\n" +
            "╚═════════════════════════════════════════════╝\n\n" +

            "   Número Ingresado: %d\n\n" +

            "======================\n" +
            "    PRIMITIVOS   \n" +
            "======================\n" +
            "➤ int:       = %d\n" +
            "➤ byte:      = %d\n" +
            "➤ short:     = %d\n" +
            "➤ long:      = %d\n" +
            "➤ float:     = %.1f\n" +
            "➤ double:    = %.1f\n\n" +

            "======================\n" +
            "    OBJETOS    \n" +
            "======================\n" +
            "➤ Integer:     = %s\n" +
            "➤ Byte:        = %s\n" +
            "➤ Short:       = %s\n" +
            "➤ Long:        = %s\n" +
            "➤ Float:       = %s\n" +
            "➤ Double:      = %s",
            
            // Argumentos para String.format
            numeroInt, // Para "Número ingresado"

            // Primitivos
            numeroInt, numeroByte, numeroShort, numeroLong,
            numeroFloat, numeroDouble,

            // Objetos (se usa %s ya que son objetos que se convierten a String)
            objInteger, objByte, objShort, objLong,
            objFloat, objDouble
        );

        // 4. Mostrar resultados en un cuadro informativo
        JOptionPane.showMessageDialog(null, mensaje, "Tipos de Datos", JOptionPane.PLAIN_MESSAGE);
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

