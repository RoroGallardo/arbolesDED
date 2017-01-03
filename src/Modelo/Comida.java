package Modelo;

/**
 *
 * @author Mauricio
 */
public class Comida {
    private int calorias;
    private String nombre;
    
    public Comida(){
    
    }

    public Comida(int calorias, String nombre) {
        this.calorias = calorias;
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "calorias = " + calorias + ", nombre = " + nombre;
    }
    
    
}
