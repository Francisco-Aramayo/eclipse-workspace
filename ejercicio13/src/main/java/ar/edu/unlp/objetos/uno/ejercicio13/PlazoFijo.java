package ar.edu.unlp.objetos.uno.ejercicio13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo extends Inversion {
    private double montoDepositado;
    private double porcentajeIntereses;
    private LocalDate fechaConstitucion;

    // al crear un plazo fijo se setea automagicamente la fecha
    public PlazoFijo(double monto, double interes, LocalDate fechaConstitucion){
        this.montoDepositado = monto;
        this.porcentajeIntereses = interes;
        this.fechaConstitucion = fechaConstitucion;
    }

    @Override
    public double valorActual() {
        long dias = ChronoUnit.DAYS.between(this.fechaConstitucion,
        LocalDate.now());
        double interesTotal = this.montoDepositado * this.porcentajeIntereses *
        dias;

        return this.montoDepositado + interesTotal;

    }

}
