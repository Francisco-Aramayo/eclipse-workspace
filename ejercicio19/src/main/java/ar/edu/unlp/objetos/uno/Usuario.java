package ar.edu.unlp.objetos.uno;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String direccion;
    private String dni;
    private List<Propiedad> propiedades;
    private List<Reserva> reservas;

    public Usuario (String nombre, String direccion, String dni){
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.propiedades = new ArrayList<>();
        this.propiedades = new ArrayList<>();
    }

    public void agregarPropiedad (Propiedad propiedad){
        this.propiedades.add(propiedad);
    }

    public Reserva crearReserva(Propiedad propiedad, DateLapseInterface periodo){
        if (propiedad.estaDisponible(periodo)){
            Reserva nueva = new Reserva(this, propiedad, periodo);
            this.reservas.add(nueva);
            return nueva;
        }
        return null;
    }


    public boolean cancelarReserva(Reserva r) {
        if (!r.estaEnCurso()) {
            this.reservas.remove(r);
            r.getPropiedad().getReservas().remove(r);
            return true;
        }
        return false;
    }

    // ingresa solo reservas de propiedasdes del usuario como duenio
    public double calcularIngresos(DateLapseInterface periodo){
        return this.propiedades.stream()
            .flatMap(p -> p.getReservas().stream())
            .filter(r -> r.getPeriodo().overlapse(periodo))
            .mapToDouble(r -> r.calcularPrecio() * 0.75)
            .sum();
    }

}
