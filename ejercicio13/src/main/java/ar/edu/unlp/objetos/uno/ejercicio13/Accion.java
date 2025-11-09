package ar.edu.unlp.objetos.uno.ejercicio13;

public class Accion {
    private String nombre;
    private double valorUnitario;

    public Accion (String nombre, double valorUnitario) {
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getValorUnitario() {
        return this.valorUnitario;
    }
}
