package ar.edu.unlp.objetos.uno;

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
        return (int) this.sizeInDays;
    }

    @Override 
    public boolean includesDate (LocalDate other) {
        LocalDate to = this.getTo();
        return !other.isBefore(this.from) && !other.isAfter(to);
    }

    @Override
    public boolean overlapse(DateLapseInterface other) {
        LocalDate thisFrom = this.getFrom();
        LocalDate thisTo   = this.getTo();
        LocalDate otherFrom = other.getFrom();
        LocalDate otherTo   = other.getTo();

        // NO se solapan si uno termina antes de que el otro empiece
        if (thisTo.isBefore(otherFrom) || otherTo.isBefore(thisFrom)) {
            return false;
        }
        // en cualquier otro caso sí se solapan
        return true;
    }
}
