    public static clasesDeModeloDeDatos crearPersona(String nombre, int edad) {
        return new clasesDeModeloDeDatos(nombre, edad);
    }

package io.github.theca.utils;


public class clasesDeModeloDeDatos {
    private String nombre;
    private int edad;

    public clasesDeModeloDeDatos(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
