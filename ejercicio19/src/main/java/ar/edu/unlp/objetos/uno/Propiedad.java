package ar.edu.unlp.objetos.uno;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {

    private String direccion;
    private String nombre;
    private double precioxNoche;
    private List<Reserva> reservas;

    public Propiedad (String direccion, String nombre, double precioxNoche){
        
        this.direccion = direccion;
        this.nombre = nombre;
        this.precioxNoche = precioxNoche;
        this.reservas = new ArrayList<>();
    }

    public double getPrecioxNoche (){ return this.precioxNoche; }
    public List<Reserva> getReservas() { return this.reservas; }

    public boolean estaDisponible (DateLapseInterface periodo) {
        return this.reservas.stream()
            .noneMatch(reserva -> reserva.getPeriodo().overlapse(periodo));
    }

    public void agregarReserva(Reserva r){
        this.reservas.add(r);
    }
}

