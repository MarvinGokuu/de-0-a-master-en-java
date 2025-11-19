public class ConversionesCompletas {
// programa de conversion de tipos de datos en Java
    public static void main(String[] args) {

        // Valores iniciales
        String str = "123";
        byte b = 10;
        short s = 100;
        int i = 1000;
        long l = 10000L;
        float f = 12.34f;
        double d = 123.45;

        Byte objB = 10;
        Short objS = 100;
        Integer objI = 1000;
        Long objL = 10000L;
        Float objF = 12.34f;
        Double objD = 123.45;

        // ===== String a primitivo =====
        int strAInt = Integer.parseInt(str); // String -> int
        double strADouble = Double.parseDouble(str); // String -> double
        float strAFloat = Float.parseFloat(str); // String -> float
        long strALong = Long.parseLong(str); // String -> long
        short strAShort = Short.parseShort(str); // String -> short
        byte strAByte = Byte.parseByte(str); // String -> byte

        // ===== String a objeto =====
        Integer strAInteger = Integer.valueOf(str); // String -> Integer
        Double strADoubleObj = Double.valueOf(str); // String -> Double
        Float strAFloatObj = Float.valueOf(str); // String -> Float
        Long strALongObj = Long.valueOf(str); // String -> Long
        Short strAShortObj = Short.valueOf(str); // String -> Short
        Byte strAByteObj = Byte.valueOf(str); // String -> Byte

        // ===== Primitivo a objeto (Autoboxing) =====
        Integer intAInteger = i; // int -> Integer
        Double doubleADoubleObj = d; // double -> Double
        Float floatAFloatObj = f; // float -> Float
        Long longALongObj = l; // long -> Long
        Short shortAShortObj = s; // short -> Short
        Byte byteAByteObj = b; // byte -> Byte

        // ===== Objeto a primitivo (Unboxing) =====
        int integerAInt = objI; // Integer -> int
        double doubleObjADouble = objD; // Double -> double
        float floatObjAFloat = objF; // Float -> float
        long longObjALong = objL; // Long -> long
        short shortObjAShort = objS; // Short -> short
        byte byteObjAByte = objB; // Byte -> byte

        // ===== Casting entre primitivos =====
        short bAShort = b; // byte -> short
        int bAInt = b; // byte -> int
        long bALong = b; // byte -> long
        float bAFloat = b; // byte -> float
        double bADouble = b; // byte -> double

        int sAInt = s; // short -> int
        long sALong = s; // short -> long
        float sAFloat = s; // short -> float
        double sADouble = s; // short -> double

        long iALong = i; // int -> long
        float iAFloat = i; // int -> float
        double iADouble = i; // int -> double

        float lAFloat = l; // long -> float (posible pérdida de precisión)
        double lADouble = l; // long -> double

        double fADouble = f; // float -> double
        float dAFloat = (float) d; // double -> float (casting obligatorio)

        int dAInt = (int) d; // double -> int (casting obligatorio)
        long dALong = (long) d; // double -> long (casting obligatorio)
        short dAShort = (short) d; // double -> short (casting obligatorio)
        byte dAByte = (byte) d; // double -> byte (casting obligatorio)

        // ===== De objetos a otros objetos =====
        Integer deDoubleObjAInteger = objD.intValue(); // Double -> Integer
        Float deDoubleObjAFloat = objD.floatValue(); // Double -> Float
        Long deDoubleObjALong = objD.longValue(); // Double -> Long
        Short deDoubleObjAShort = objD.shortValue(); // Double -> Short
        Byte deDoubleObjAByte = objD.byteValue(); // Double -> Byte

        Double deIntObjADouble = objI.doubleValue(); // Integer -> Double
        Float deIntObjAFloat = objI.floatValue(); // Integer -> Float
        Long deIntObjALong = objI.longValue(); // Integer -> Long
        Short deIntObjAShort = objI.shortValue(); // Integer -> Short
        Byte deIntObjAByte = objI.byteValue(); // Integer -> Byte

        // ===== Mostrar algunos resultados =====
        System.out.println("strAInt = " + strAInt);
        System.out.println("deDoubleObjAInteger = " + deDoubleObjAInteger);
        System.out.println("dAInt = " + dAInt);
        System.out.println("floatObjAFloat = " + floatObjAFloat);
    }
}
