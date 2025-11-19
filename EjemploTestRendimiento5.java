import javax.swing.JOptionPane;

public class EjemploTestRendimiento5 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        // String c = a; // Variable 'c' no utilizada
        long iteraciones = 0;
        boolean entradaValida = false;
        String nEntrada = null;
        int tiempoEnSegundos = 0; // Usaremos esta variable como tiempo límite
        
        // Factor de trabajo por cada chequeo de tiempo para una medición robusta
        final int CARGA_TRABAJO = 100000; 

        // 1. Bucle para solicitar un número válido
        do {
            nEntrada = JOptionPane.showInputDialog("Ingrese el tiempo de ejecución en segundos (entero positivo):");

            // Si presiona Cancelar o cierra el diálogo
            if (nEntrada == null) {
                System.exit(0);
            }

            try {
                tiempoEnSegundos = Integer.parseInt(nEntrada);
                
                // Validación adicional: asegurar que sea positivo
                if (tiempoEnSegundos <= 0) {
                    throw new NumberFormatException();
                }
                
                entradaValida = true; // Salir del bucle
            } catch (NumberFormatException e) {
                // La entrada no es un número válido o no es positivo
                JOptionPane.showMessageDialog(null,
                        "\"" + nEntrada + "\" no es un tiempo de ejecución válido.",
                        "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!entradaValida);

        // Convertir el tiempo de ejecución a milisegundos para el control del bucle
        long tiempoLimiteMillis = (long) tiempoEnSegundos * 1000; 

        // Preparación para el test de rendimiento
        StringBuilder sb = new StringBuilder(a);

        // Usamos nanoTime para la medición final precisa
        long inicioNano = System.nanoTime(); 
        // Usamos currentTimeMillis para el control del bucle de tiempo
        long inicioMillis = System.currentTimeMillis(); 
        long finMillis;

        // Bucle de rendimiento: Repetir mientras el tiempo transcurrido sea menor al límite.
        do {
            // Aplicamos un bucle interno para aumentar la carga de trabajo
            for (int i = 0; i < CARGA_TRABAJO; i++) {
                // Concatenación con StringBuilder
                sb.append(a).append(b).append("\n");
            }
            
            // 🔥 CORRECCIÓN CRÍTICA: Limpiar el StringBuilder para evitar OutOfMemoryError
            sb.setLength(0); 
            
            iteraciones++; // Cuenta una "macro-iteración"
            finMillis = System.currentTimeMillis();
        } while ((finMillis - inicioMillis) < tiempoLimiteMillis);

        // Medición final y cálculos
        long finNano = System.nanoTime();
        long tiempoEjecucionNano = finNano - inicioNano;
        long tiempoEjecucionMillis = tiempoEjecucionNano / 1_000_000; 
        long totalOperaciones = iteraciones * CARGA_TRABAJO;

        // 3. Crear el mensaje con formato
        String mensaje = String.format(
            "╔════════════════════════════════════╗\n" +
            "  RESULTADO DEL TEST DE RENDIMIENTO \n" +
            "╚════════════════════════════════════╝\n\n" +
            "Tiempo límite solicitado: **%d segundos**\n" +
            "Tiempo de ejecución real: **%,d ms**\n" +
            "Operación probada: **StringBuilder.append()**\n" +
            "Iteraciones (x%d appends): **%,d**\n" +
            "Total de appends realizados: **%,d**",
            tiempoEnSegundos,
            tiempoEjecucionMillis,
            CARGA_TRABAJO,
            iteraciones,
            totalOperaciones
        );
        
        // 4. Mostrar el mensaje en pantalla usando JOptionPane
        JOptionPane.showMessageDialog(null, mensaje, "Test Finalizado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "El programa ha finalizado", "Info", JOptionPane.INFORMATION_MESSAGE);

        // Salida por consola (mantenida para referencia y log)
        // System.out.println("sb = " + sb.toString()); // Ya no es útil pues 'sb' está vacío
        System.out.println("Tiempo de ejecución: " + tiempoEjecucionMillis + " ms");
        System.out.println("Total de appends: " + totalOperaciones);
    }
}