package ar.edu.unlp.objetos.uno.ejercicio13;

public class InversionEnAcciones extends Inversion {
    private int cantidad;
    private String nombreAccion;
    private double valorUnitario;

    public InversionEnAcciones(String nombreAccion, int cantidad,
                                double valorUnitario) {
        this.nombreAccion = nombreAccion;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public double valorActual() {
        return this.cantidad * this.valorUnitario;
    }

    public String getNombreAccion() { return nombreAccion;}
    public int getCantidad() { return cantidad; }
    public double getValorUnitario() { return valorUnitario; }
}
