import javax.swing.JOptionPane;

public class convertidorSimple3 {

    public static void main(String[] args) {

        String nEntrada = JOptionPane.showInputDialog("Ingrese un número entero:");

        try {
            // Convertir a int primitivo
            int numeroInt = Integer.parseInt(nEntrada);

            // Conversiones a otros primitivos
            byte numeroByte = (byte) numeroInt;
            short numeroShort = (short) numeroInt;
            long numeroLong = numeroInt;
            float numeroFloat = numeroInt;
            double numeroDouble = numeroInt;

            // Conversiones a objetos envolventes
            Integer objInteger = numeroInt;
            Byte objByte = numeroByte;
            Short objShort = numeroShort;
            Long objLong = numeroLong;
            Float objFloat = numeroFloat;
            Double objDouble = numeroDouble;

            // Construir mensaje para mostrar
            String mensaje = "Resultados de las conversiones:\n\n" +
                    "Primitivos:\n" +
                    "int: " + numeroInt + "\n" +
                    "byte: " + numeroByte + "\n" +
                    "short: " + numeroShort + "\n" +
                    "long: " + numeroLong + "\n" +
                    "float: " + numeroFloat + "\n" +
                    "double: " + numeroDouble + "\n\n" +
                    "Objetos:\n" +
                    "Integer: " + objInteger + "\n" +
                    "Byte: " + objByte + "\n" +
                    "Short: " + objShort + "\n" +
                    "Long: " + objLong + "\n" +
                    "Float: " + objFloat + "\n" +
                    "Double: " + objDouble;

            // Mostrar todas las conversiones en un solo cuadro
            JOptionPane.showMessageDialog(null, mensaje, "Convertidor de Tipos de Datos Numéricos", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Debes escribir un número entero.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
        // 1. Bucle para solicitar un número válido
         // Si presiona Cancelar
         // Si la entrada es correcta
        // 2. Convertir el número a diferentes tipos de datos numéricos
/*                      "Primitivos:\n" +
                    "int: " + numeroInt + "\n" +
                    "byte: " + numeroByte + "\n" +
                    "short: " + numeroShort + "\n" +
                    "long: " + numeroLong + "\n" +
                    "float: " + numeroFloat + "\n" +
                    "double: " + numeroDouble + "\n\n" +
                    "Objetos:\n" +
                    "Integer: " + objInteger + "\n" +
                    "Byte: " + objByte + "\n" +
                    "Short: " + objShort + "\n" +
                    "Long: " + objLong + "\n" +
                    "Float: " + objFloat + "\n" +
                    "Double: " + objDouble; */
        // 3. Crear el mensaje con formato
/*
String mensaje = String.format(
                    String.format(
                            "Resultados de las conversiones:\n\n" +
                                    "Primitivos:\n" +
                                    "int: %d\n" +
                                    "byte: %d\n" +
                                    "short: %d\n" +
                                    "long: %d\n" +
                                    "float: %f\n" +
                                    "double: %f\n\n" +
                                    "Objetos:\n" +
                                    "Integer: %s\n" +
                                    "Byte: %s\n" +
                                    "Short: %s\n" +
                                    "Long: %s\n" +
                                    "Float: %s\n" +
                                    "Double: %s",
                            numeroInt, numeroByte, numeroShort, numeroLong,
                            numeroFloat, numeroDouble,
                            objInteger, objByte, objShort, objLong,
                            objFloat, objDouble
                    );
        // 4. Mostrar resultados en un cuadro informativo */
