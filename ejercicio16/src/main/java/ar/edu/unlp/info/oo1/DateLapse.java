package ar.edu.unlp.info.oo1;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse (LocalDate from, LocalDate to){
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom (){
        // retorna la fecha de inicio del reango
        return this.from;
    }

    public LocalDate getTo(){
        // retorna la fecha de fin del rango
        return this.to;
    }
    
    // utilizar metodo until()
    public int sizeInDays(){
        // retorna la cantidad de dias entre las fechas
        long dias = this.from.until(to, ChronoUnit.DAYS);
        return (int)dias;   // cast explicito
    }

    public boolean includesDate (LocalDate other){
        // recibe un objeto date y retorna true/dalse si esta en rango
        boolean esPosteriorOIgualAFrom = other.isAfter(this.from) || other.isEqual(this.from);
        boolean esAnteriorOIgualATo = other.isBefore(this.to) || other.isEqual(this.to);
    
        return esPosteriorOIgualAFrom && esAnteriorOIgualATo;
    }


}
