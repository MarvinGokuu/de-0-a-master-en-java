import javax.swing.JOptionPane;

public class TestRendimiento1 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        long iteraciones = 0; // Se usará como contador
        boolean entradaValida = false;
        String nEntrada = null;
        int tiempoEnSegundos = 0; 
        
        final int CARGA_TRABAJO = 100000; 
        // Verifica el tiempo solo cada 1000 macro-iteraciones
        final int FACTOR_VERIFICACION = 1000; 
        
        // 1. Pedir tiempo de ejecución con advertencia y límite de 60 segundos
        do {
            nEntrada = JOptionPane.showInputDialog(
                "Ingrese el tiempo límite de ejecución (segundos).\n" + 
                "El valor no debe exceder: 60 segundos."+
                "Si es mayor no se ejecutará correctamente."
            );
            
            if (nEntrada == null) System.exit(0);

            try {
                tiempoEnSegundos = Integer.parseInt(nEntrada);
                
                // VALIDACIÓN: Verifica que el número esté entre 1 y 60
                if (tiempoEnSegundos <= 0 || tiempoEnSegundos > 60) {
                    throw new NumberFormatException(); 
                }
                
                entradaValida = true;
            } catch (NumberFormatException e) {
                // Mensaje de error si está fuera de rango o no es un número
                JOptionPane.showMessageDialog(null,
                        "Por favor, ingrese un número entre 1 y 60.",
                        "Error de Rango",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!entradaValida);

        long tiempoLimiteMillis = (long) tiempoEnSegundos * 1000; 
        StringBuilder sb = new StringBuilder(a);
        long inicioNano = System.nanoTime(); 
        long inicioMillis = System.currentTimeMillis(); 
        long finMillis = inicioMillis; // Inicializado para entrar al bucle

        // Bucle de rendimiento: Ejecutar mientras el tiempo transcurrido sea menor al límite.
        do {
            // Aplicamos un bucle interno para aumentar la carga de trabajo
            for (int i = 0; i < CARGA_TRABAJO; i++) {
                sb.append(a).append(b).append("\n");
            }
            
            sb.setLength(0); 
            
            iteraciones++;
            
            // OPTIMIZACIÓN CRÍTICA: Solo verifica el tiempo cada FACTOR_VERIFICACION
            if (iteraciones % FACTOR_VERIFICACION == 0) {
                finMillis = System.currentTimeMillis();
            }

        } while ((finMillis - inicioMillis) < tiempoLimiteMillis);
        
        // Asegurarse de tener el tiempo final real si el bucle terminó
        if (iteraciones % FACTOR_VERIFICACION != 0) {
             finMillis = System.currentTimeMillis();
        }

        // Medición final y cálculos
        long finNano = System.nanoTime();
        long tiempoEjecucionNano = finNano - inicioNano;
        long tiempoEjecucionMillis = tiempoEjecucionNano / 1_000_000; 
        long totalOperaciones = iteraciones * CARGA_TRABAJO;
        
        // **********************************************
        // * LÓGICA DE CONVERSIÓN DE TIEMPO *
        // **********************************************
        long tiempoRestante = tiempoEjecucionMillis;
        long milisegundosDia = 86400000; 
        long dias = tiempoRestante / milisegundosDia;
        tiempoRestante %= milisegundosDia;

        long milisegundosHora = 3600000; 
        long horas = tiempoRestante / milisegundosHora;
        tiempoRestante %= milisegundosHora;

        long milisegundosMinuto = 60000; 
        long minutos = tiempoRestante / milisegundosMinuto;
        tiempoRestante %= milisegundosMinuto;

        long segundos = tiempoRestante / 1000;
        long milisegundosFinales = tiempoRestante % 1000; 

        // 5. Creación del mensaje detallado de conversión
        String mensajeDetallado = String.format(
            "\n" +
            "╔════════════════════════════════════╗\n" +
            "  TIEMPO DE EJECUCIÓN CONVERTIDO \n" +
            "╚════════════════════════════════════╝\n" +
            "Días:         **%d**\n" +
            "Horas:        **%d**\n" +
            "Minutos:      **%d**\n" +
            "Segundos:     **%d**\n" +
            "Milisegundos: **%d**",
            dias,
            horas,
            minutos,
            segundos,
            milisegundosFinales
        );

        // 3. Crear el mensaje principal con formato
        String mensaje = String.format(
            "╔════════════════════════════════════╗\n" +
            "  RESULTADO DEL TEST DE RENDIMIENTO \n" +
            "╚════════════════════════════════════╝\n\n" +
            "Tiempo LÍMITE solicitado: **%d segundos**\n" +
            "Tiempo de ejecución real: **%,d ms**\n" +
            "Operación probada: **StringBuilder.append()**\n" +
            "Total de appends realizados: **%,d**",
            tiempoEnSegundos, 
            tiempoEjecucionMillis,
            totalOperaciones
        );
        
        // 4. Mostrar resultado (Concatenando el mensaje detallado)
        JOptionPane.showMessageDialog(null, mensaje + mensajeDetallado, "Test Finalizado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "El programa ha finalizado", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}//funciona.