// Octonion.java
// Implementación de octoniones en Java (8 componentes).
// Compilar: javac Octonion.java
// Ejecutar:   java Octonion

import java.util.Arrays;

public class Octonion {
    // componentes: a0 + a1*e1 + ... + a7*e7
    public final double a0, a1, a2, a3, a4, a5, a6, a7;
    private static final double EPS = 1e-12;

    // Tablas de multiplicación: sign[i][j] y idx[i][j] tal que e_i * e_j = sign *
    // e_idx
    // índices: 0..7 (0 = 1, 1..7 las unidades imaginarias)
    private static final int[][] sign = new int[8][8];
    private static final int[][] idx = new int[8][8];

    static {
        // Inicializar: 1 * x = x, x * 1 = x
        for (int i = 0; i < 8; i++) {
            sign[0][i] = 1;
            idx[0][i] = i;
            sign[i][0] = 1;
            idx[i][0] = i;
        }
        idx[0][0] = 0;
        sign[0][0] = 1;

        // e_i * e_i = -1
        for (int i = 1; i < 8; i++) {
            idx[i][i] = 0;
            sign[i][i] = -1;
        }

        // Tríadas del Fano (convención común):
        // (1,2,3), (1,4,5), (1,7,6), (2,4,6), (2,5,7), (3,4,7), (3,6,5)
        int[][] triples = {
                { 1, 2, 3 },
                { 1, 4, 5 },
                { 1, 7, 6 },
                { 2, 4, 6 },
                { 2, 5, 7 },
                { 3, 4, 7 },
                { 3, 6, 5 }
        };

        for (int[] t : triples) {
            int i = t[0], j = t[1], k = t[2];
            // e_i * e_j = + e_k
            idx[i][j] = k;
            sign[i][j] = 1;
            idx[j][k] = i;
            sign[j][k] = 1;
            idx[k][i] = j;
            sign[k][i] = 1;
            // inversión de orden cambia signo
            idx[j][i] = k;
            sign[j][i] = -1;
            idx[k][j] = i;
            sign[k][j] = -1;
            idx[i][k] = j;
            sign[i][k] = -1;
        }
    }

    // Constructor
    public Octonion(double a0, double a1, double a2, double a3,
            double a4, double a5, double a6, double a7) {
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
    }

    // Crea a partir de array (longitud 8)
    public static Octonion fromArray(double[] arr) {
        if (arr.length != 8)
            throw new IllegalArgumentException("Array length must be 8");
        return new Octonion(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
    }

    // Suma
    public Octonion add(Octonion o) {
        return new Octonion(
                this.a0 + o.a0,
                this.a1 + o.a1,
                this.a2 + o.a2,
                this.a3 + o.a3,
                this.a4 + o.a4,
                this.a5 + o.a5,
                this.a6 + o.a6,
                this.a7 + o.a7);
    }

    // Resta
    public Octonion sub(Octonion o) {
        return new Octonion(
                this.a0 - o.a0,
                this.a1 - o.a1,
                this.a2 - o.a2,
                this.a3 - o.a3,
                this.a4 - o.a4,
                this.a5 - o.a5,
                this.a6 - o.a6,
                this.a7 - o.a7);
    }

    // Negación
    public Octonion neg() {
        return new Octonion(-a0, -a1, -a2, -a3, -a4, -a5, -a6, -a7);
    }

    // Producto por escalar (izq/der iguales en campos reales)
    public Octonion scalarMul(double s) {
        return new Octonion(a0 * s, a1 * s, a2 * s, a3 * s, a4 * s, a5 * s, a6 * s, a7 * s);
    }

    // Conjugado: invierte las imaginarias
    public Octonion conjugate() {
        return new Octonion(a0, -a1, -a2, -a3, -a4, -a5, -a6, -a7);
    }

    // Norma al cuadrado
    public double normSq() {
        return a0 * a0 + a1 * a1 + a2 * a2 + a3 * a3 + a4 * a4 + a5 * a5 + a6 * a6 + a7 * a7;
    }

    // Norma
    public double norm() {
        return Math.sqrt(normSq());
    }

    // Inverso: conj(x) / ||x||^2 (lanza ArithmeticException si norma 0)
    public Octonion inverse() {
        double ns = normSq();
        if (ns < EPS)
            throw new ArithmeticException("El octonión tiene norma cero; no tiene inverso.");
        Octonion c = conjugate();
        return c.scalarMul(1.0 / ns);
    }

    // Multiplicación: distribuye usando tabla de producto de bases
    public Octonion mul(Octonion o) {
        double[] A = { a0, a1, a2, a3, a4, a5, a6, a7 };
        double[] B = { o.a0, o.a1, o.a2, o.a3, o.a4, o.a5, o.a6, o.a7 };
        double[] R = new double[8];

        for (int i = 0; i < 8; i++) {
            if (Math.abs(A[i]) < EPS)
                continue;
            for (int j = 0; j < 8; j++) {
                if (Math.abs(B[j]) < EPS)
                    continue;
                int s = sign[i][j];
                int k = idx[i][j];
                // e_i * e_j = s * e_k
                R[k] += A[i] * B[j] * s;
            }
        }
        return fromArray(R);
    }

    // División por otro octonión: a / b = a * b^{-1}
    public Octonion div(Octonion b) {
        return this.mul(b.inverse());
    }

    // Igualdad con tolerancia
    public boolean approxEquals(Octonion o, double tol) {
        return Math.abs(a0 - o.a0) <= tol &&
                Math.abs(a1 - o.a1) <= tol &&
                Math.abs(a2 - o.a2) <= tol &&
                Math.abs(a3 - o.a3) <= tol &&
                Math.abs(a4 - o.a4) <= tol &&
                Math.abs(a5 - o.a5) <= tol &&
                Math.abs(a6 - o.a6) <= tol &&
                Math.abs(a7 - o.a7) <= tol;
    }

    public boolean approxEquals(Octonion o) {
        return approxEquals(o, 1e-9);
    }

    // Representación legible
    @Override
    public String toString() {
        double[] c = { a0, a1, a2, a3, a4, a5, a6, a7 };
        String[] basis = { "", "e1", "e2", "e3", "e4", "e5", "e6", "e7" };
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < 8; i++) {
            double v = c[i];
            if (Math.abs(v) < 1e-12)
                continue;
            String term;
            if (i == 0) {
                term = String.format("%.6g", v);
            } else {
                term = String.format("%.6g%s", Math.abs(v), basis[i]);
                if (v < 0)
                    term = "-" + term;
            }
            if (first) {
                if (i == 0)
                    sb.append(term);
                else if (c[i] < 0)
                    sb.append("-").append(term.replaceFirst("-", ""));
                else
                    sb.append(term);
                first = false;
            } else {
                if (i == 0) {
                    sb.append(c[i] < 0 ? " - " + String.format("%.6g", -c[i]) : " + " + String.format("%.6g", c[i]));
                } else {
                    sb.append(c[i] < 0 ? " - " + term.replaceFirst("-", "") : " + " + term);
                }
            }
        }
        if (first)
            return "0";
        return sb.toString();
    }

    // --- Ejemplos y pruebas en main ---
    public static void main(String[] args) {
        Octonion a = new Octonion(1, 2, -1, 0.5, 0, 0, 0, 0.1);
        Octonion b = new Octonion(0.2, -1, 0.3, 0, 0.1, 0.4, -0.2, 0.0);

        Octonion ab = a.mul(b);
        Octonion ba = b.mul(a);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("\na * b = " + ab);
        System.out.println("b * a = " + ba);
        System.out.println("¿a*b == b*a ? " + ab.approxEquals(ba));

        // Propiedad del conjugado: conj(a*b) == conj(b) * conj(a)
        Octonion conj_ab = ab.conjugate();
        Octonion conj_ba = b.conjugate().mul(a.conjugate());
        System.out.println("\nconj(a*b) = " + conj_ab);
        System.out.println("conj(b) * conj(a) = " + conj_ba);
        System.out.println("¿conj(a*b) ≈ conj(b)*conj(a)? " + conj_ab.approxEquals(conj_ba));

        // Inverso y comprobación x * x^{-1} ≈ 1
        Octonion x = new Octonion(1.1963015972738038, -18.314712741526464, -0.559879968658, -1.2516772780188554,
                -0.046874923345920916, 0, 0, 0);
        Octonion xInv = x.inverse();
        Octonion identity = x.mul(xInv);
        System.out.println("\nx = " + x);
        System.out.println("x^{-1} = " + xInv);
        System.out.println("x * x^{-1} ≈ " + identity);

        // No asociatividad ejemplo
        Octonion p = new Octonion(-0.2762489378065811, 0.990845602363859, -0.9648085198574, -0.9492660971749163,
                0.16985840140528552, 0, 0, 0);
        Octonion q = new Octonion(-0.0959291886239464, 0.07845248075294498, -0.2585146204, 0.13641430190720327,
                -0.16953426027146246, 0, 0, 0);
        Octonion r = new Octonion(-0.6418822930338894, 0.3664951969096777, 0.5244342162879, 0.24370876126975394,
                0.818993455386682, 0, 0, 0);

        Octonion left = p.mul(q).mul(r);
        Octonion right = p.mul(q.mul(r));
        System.out.println("\nEjemplo no asociativo:");
        System.out.println("(p*q)*r = " + left);
        System.out.println("p*(q*r) = " + right);
        System.out.println("¿(p*q)*r == p*(q*r) ? " + left.approxEquals(right));
    }
}
