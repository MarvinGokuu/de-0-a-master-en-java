import javax.swing.JOptionPane;

public class EjemploTestRendimiento6_Modificado {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        long iteraciones = 0;
        boolean entradaValida = false;
        String nEntrada = null;
        int numeroInt = 0;
        
        // Factor para limpiar el StringBuilder y evitar OutOfMemoryError
        // Se limpiará cada 100,000 iteraciones
        final long FACTOR_LIMPIEZA = 100000; 

        // 1. Pedir tiempo de ejecución (Manteniendo la estructura original)
        do {
            nEntrada = JOptionPane.showInputDialog("Ingrese el tiempo de ejecución en segundos:");
            if (nEntrada == null) System.exit(0);

            try {
                numeroInt = Integer.parseInt(nEntrada);
                if (numeroInt <= 0) throw new NumberFormatException();
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "\"" + nEntrada + "\" no es un número válido.",
                        "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!entradaValida);

        // 2. Definir número de iteraciones en base al tiempo (Lógica Original Mantenida)
        // Nota: El test medirá el tiempo que toma ejecutar este número fijo de iteraciones.
        iteraciones = (long) numeroInt * 10000; 

        StringBuilder sb = new StringBuilder(a);
        long inicio = System.currentTimeMillis();

        // INICIO DEL TEST (Bucle 'for' original, pero con corrección de memoria)
        for (long i = 0; i < iteraciones; i++) { 
            sb.append(a).append(b).append("\n");
            
            // CORRECCIÓN CRÍTICA: Limpiar el StringBuilder cada X iteraciones
            if (i % FACTOR_LIMPIEZA == 0 && i != 0) {
                sb.setLength(0);
            }
        }

        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - inicio;

        // 3. Crear el mensaje con formato
        String mensaje = String.format(
            "╔════════════════════════════════════╗\n" +
            " RESULTADO DEL TEST DE RENDIMIENTO \n" +
            "╚════════════════════════════════════╝\n\n" +
            "Número solicitado (Base): **%d**\n" +
            "Total de appends realizados: **%,d**\n" +
            "Tiempo de ejecución real: **%,d ms**\n" +
            "Operación probada: **StringBuilder.append()**",
            numeroInt, 
            iteraciones, 
            tiempoEjecucion
        );

        // 4. Mostrar resultado
        JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "El programa ha finalizado", "Info", JOptionPane.INFORMATION_MESSAGE);

        // Se elimina la línea System.out.println("sb = " + sb.toString()); para evitar impacto en el rendimiento.
    }
}