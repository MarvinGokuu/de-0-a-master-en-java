public class Primitivos {
    public static void main(String[] args) {

        // === Tipos primitivos en Java ===
        //  empezamos con los tipos numéricos ===
        
        byte numByte = 127;
        short numShort = 32767;
        int numInt = 10;
        long numLong = 9223372036854775807L;
        float numFloat = 10.5f;
        double numDouble = 10.5;
        char caracter = 'A';
        boolean esVerdadero = true;

        System.out.println("=== Información de Tipos Primitivos ===\n");

        // byte
        System.out.println("byte:");
        System.out.println("  Valor: " + numByte);
        System.out.println("  Bytes: " + Byte.BYTES);
        System.out.println("  Bits: " + Byte.SIZE);
        System.out.println("  Máximo: " + Byte.MAX_VALUE);
        System.out.println("  Mínimo: " + Byte.MIN_VALUE);
        System.out.println();

        // short
        System.out.println("short:");
        System.out.println("  Valor: " + numShort);
        System.out.println("  Bytes: " + Short.BYTES);
        System.out.println("  Bits: " + Short.SIZE);
        System.out.println("  Máximo: " + Short.MAX_VALUE);
        System.out.println("  Mínimo: " + Short.MIN_VALUE);
        System.out.println();

        // int
        System.out.println("int:");
        System.out.println("  Valor: " + numInt);
        System.out.println("  Bytes: " + Integer.BYTES);
        System.out.println("  Bits: " + Integer.SIZE);
        System.out.println("  Máximo: " + Integer.MAX_VALUE);
        System.out.println("  Mínimo: " + Integer.MIN_VALUE);
        System.out.println();

        // long
        System.out.println("long:");
        System.out.println("  Valor: " + numLong);
        System.out.println("  Bytes: " + Long.BYTES);
        System.out.println("  Bits: " + Long.SIZE);
        System.out.println("  Máximo: " + Long.MAX_VALUE);
        System.out.println("  Mínimo: " + Long.MIN_VALUE);
        System.out.println();

        // float
        System.out.println("float:");
        System.out.println("  Valor: " + numFloat);
        System.out.println("  Bytes: " + Float.BYTES);
        System.out.println("  Bits: " + Float.SIZE);
        System.out.println("  Máximo: " + Float.MAX_VALUE);
        System.out.println("  Mínimo: " + Float.MIN_VALUE);
        System.out.println();

        // double
        System.out.println("double:");
        System.out.println("  Valor: " + numDouble);
        System.out.println("  Bytes: " + Double.BYTES);
        System.out.println("  Bits: " + Double.SIZE);
        System.out.println("  Máximo: " + Double.MAX_VALUE);
        System.out.println("  Mínimo: " + Double.MIN_VALUE);
        System.out.println();

        // char
        System.out.println("char:");
        System.out.println("  Valor: " + caracter);
        System.out.println("  Bytes: " + Character.BYTES);
        System.out.println("  Bits: " + Character.SIZE);
        System.out.println("  Máximo: " + (int) Character.MAX_VALUE);
        System.out.println("  Mínimo: " + (int) Character.MIN_VALUE);
        System.out.println();

        // boolean
        System.out.println("boolean:");
        System.out.println("  Valor: " + esVerdadero);
        System.out.println("  Máximo: " + Boolean.TRUE);
        System.out.println("  Mínimo: " + Boolean.FALSE);
        System.out.println();
    }
}
