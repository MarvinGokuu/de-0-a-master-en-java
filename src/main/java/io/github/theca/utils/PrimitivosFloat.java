package io.github.theca.utils;
public class PrimitivosFloat {

public static void main(String[] args) {

        // === Tipo primitivo float en Java ===
        float numFloat = 10.5f;
        float realFloat = 5.75f;
        float cientificoFloat = 1.2e3f; // 1.2 * 10^3 = 1200.0
        float negativoFloat = -3.4f;
        float ceroFloat = 0.0f;
        float infinitoPositivo = Float.POSITIVE_INFINITY;
        float infinitoNegativo = Float.NEGATIVE_INFINITY;
        float notANumber = Float.NaN; // Not a Number

        System.out.println("=== Información del Tipo Primitivo float ===\n");
        System.out.println("float:");
        System.out.println("  Valor (numFloat): " + numFloat);
        System.out.println("  Valor (realFloat): " + realFloat);
        System.out.println("  Valor (cientificoFloat): " + cientificoFloat);
        System.out.println("  Valor (negativoFloat): " + negativoFloat);
        System.out.println("  Valor (ceroFloat): " + ceroFloat);
        System.out.println("  Valor (infinitoPositivo): " + infinitoPositivo);
        System.out.println("  Valor (infinitoNegativo): " + infinitoNegativo);
        System.out.println("  Valor (notANumber): " + notANumber);


    }
}
