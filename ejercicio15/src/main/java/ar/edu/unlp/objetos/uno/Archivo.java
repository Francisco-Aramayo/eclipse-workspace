package ar.edu.unlp.objetos.uno;

public class Archivo {
    private String nombre;
    /*Para simplificar, asuma que el tamaño de un archivo es el largo de su
     nombre. */

    public Archivo(String nombre){
        this.nombre = nombre;
    }

    public int getTamanio(){
        return this.nombre.length();
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
