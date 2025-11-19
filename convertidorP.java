

public class convertidorP {
    public static void main(String[] args) {

    String numStr = "9876";
    System.out.println(numStr);

    int numInt= Integer.parseInt(numStr);
    System.out.println("numInt: " + numInt);
    
    String realStr = "98765.43e-3";
    System.out.println(realStr);

    double numDouble = Double.parseDouble(realStr);
    System.out.println("numDouble= " +numDouble);

    String logicoStr = "true";
    System.out.println("logicoStr = " + logicoStr);

    boolean logbool = Boolean.parseBoolean(logicoStr);
    System.out.println("logbool = " + logbool);

    int otroNumInt = 100;
    System.out.println("otroNumInt = " + otroNumInt);

    String otroNumStr = Integer.toString(otroNumInt);
    System.out.println("otroNumStr = " + otroNumStr);

    Double otroRealDouble = 1.234567e2;
    System.out.println("otroRealDouble = " + otroRealDouble);

    String otroRealStr = Double.toString(otroRealDouble);
    System.out.println("otroRealStr = " + otroRealStr);
    }
}