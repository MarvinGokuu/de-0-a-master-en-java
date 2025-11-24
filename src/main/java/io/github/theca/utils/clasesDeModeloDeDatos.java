
package io.github.theca.utils; 
import lombok.Data;
@Data
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
