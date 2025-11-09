package ar.edu.unlp.objetos.uno.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Inversor {
    private String nombre;
    private List<Inversion> inversiones;

    public Inversor (String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public void agregarInversion (Inversion inversion) {
        this.inversiones.add(inversion);
    }

    public void quitarInversion(Inversion inversion) {
        this.inversiones.remove(inversion);
    }

    public double valorActualTotal() {
        // utilizar un stream
        return this.inversiones.stream()
                .mapToDouble(Inversion :: valorActual)
                .sum();
    }

    public String getNombre() { return nombre; }

}
