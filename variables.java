public class variables {
    public static void main(String[] args) {
        // declaramos la variable
        String saludar = "Hola Mundo desde Java!";

        // imprimimos en consola
        System.out.println(saludar);

        /* metodo 1: devuelve el carácter que está en una posición específica
         dentro de una cadena (String) */
        System.out.println(saludar.charAt(0));  // H
        System.out.println(saludar.charAt(1));  // o
        System.out.println(saludar.charAt(2));  // l
        System.out.println(saludar.charAt(3));  // a
        System.out.println(saludar.charAt(4));  //  
        System.out.println(saludar.charAt(5));  // M
        System.out.println(saludar.charAt(6));  // u
        System.out.println(saludar.charAt(7));  // n
        System.out.println(saludar.charAt(8));  // d
        System.out.println(saludar.charAt(9));  // o
        System.out.println(saludar.charAt(10)); //  
        System.out.println(saludar.charAt(11)); // d
        System.out.println(saludar.charAt(12)); // e
        System.out.println(saludar.charAt(13)); // s
        System.out.println(saludar.charAt(14)); // d
        System.out.println(saludar.charAt(15)); // e
        System.out.println(saludar.charAt(16)); //  
        System.out.println(saludar.charAt(17)); // J
        System.out.println(saludar.charAt(18)); // a
        System.out.println(saludar.charAt(19)); // v
        System.out.println(saludar.charAt(20)); // a
        System.out.println(saludar.charAt(21)); // !

        /* metodo 2: devuelve un IntStream que representa la secuencia
           de valores de código Unicode del objeto String. */
        saludar.chars().forEach(c -> System.out.println((char) c));
    }
}


/* // imprimimos en Mayuscula
System.out.println("toUpperCase() = " + saludar.toUpperCase());
// imprimimos en Minuscula
System.out.println("toLowerCase() = " + saludar.toLowerCase());
// imprimimos Locale actual del sistema:
System.out.println("Locale.getDefault() = " + saludar.toLowerCase
(Locale.getDefault()));
// concatenamos cadenas
System.out.println("toUpperCase() = " + saludar.concat(saludar)); */
/*  d    */