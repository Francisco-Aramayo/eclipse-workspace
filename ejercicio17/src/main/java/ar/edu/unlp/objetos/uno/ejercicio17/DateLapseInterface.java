package ar.edu.unlp.objetos.uno.ejercicio17;

import java.time.LocalDate;

public interface DateLapseInterface {

    // métodos de acceso al estado
    LocalDate getFrom();
    LocalDate getTo();

    // métodos de comportamiento
    int sizeInDays();
    boolean includesDate(LocalDate other);
}
