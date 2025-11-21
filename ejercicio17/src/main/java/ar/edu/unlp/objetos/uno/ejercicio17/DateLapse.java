package ar.edu.unlp.objetos.uno.ejercicio17;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements DateLapseInterface {

    private LocalDate from;
    private long sizeInDays;

    public DateLapse (LocalDate from, LocalDate to){
        this.from = from;
        this.sizeInDays = from.until(to, ChronoUnit.DAYS);
    }

    @Override
    public LocalDate getFrom(){
        return this.from;
    }

    @Override
    public LocalDate getTo(){
        return this.from.plusDays(this.sizeInDays);
    }

    @Override
    public int sizeInDays(){
        return (int) this.sizeInDays();
    }

    @Override 
    public boolean includesDate (LocalDate other) {
        // debe calcular to internamente
        LocalDate to = this.getTo();    // reutiliza metodo
        return !other.isBefore(this.from) && !other.isAfter(to);
    }

}
