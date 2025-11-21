package ar.edu.unlp.objetos.uno.ejercicio17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateLapseTest {
    private DateLapse standarLapse;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    // configuracion inicial, nates de cada prueba establece rango 
    @BeforeEach
    void setUp(){
        // rango estandar: 15/9/2023 añ 20/12/2023
        this.dateFrom = LocalDate.of(2023, 9, 15);
        this.dateTo = LocalDate.of(2023, 12, 20);
        this.standarLapse = new DateLapse(dateFrom, dateTo);
    }

    @Test
    void dentroDelRango (){
        LocalDate fecha = LocalDate.of(2023, 11, 11);
        assertTrue(standarLapse.includesDate(fecha));
    }

    @Test
    void antesDelRango () {
        LocalDate fecha = LocalDate.of(2022, 11, 11);
        assertFalse(standarLapse.includesDate(fecha));
    }

    @Test
    void pasadoRango (){
        LocalDate fecha = LocalDate.of(2030, 11, 11);
        assertFalse(standarLapse.includesDate(fecha));
    }

    // valores borde
    @Test
    void igualFrom (){
        assertEquals(this.dateFrom, dateFrom);
    }

    @Test
    void igualTo (){
        assertEquals(this.dateTo, dateTo);
    }

    @Test
    void unDiaAntes () {
        LocalDate fecha = dateFrom.minusDays(1);
        assertFalse(standarLapse.includesDate(fecha));
    }

    @Test
    void unDiaDespues () {
        LocalDate fecha = LocalDate.of(2023, 12, 21);
        assertFalse(standarLapse.includesDate(fecha));
    }

    // test sizeInDays
    @Test
    void intervaloEstandar(){
        assertEquals(96, standarLapse.sizeInDays());
    }

    @Test
    void mismaFechas () {
        LocalDate fecha = LocalDate.of(2025, 1, 1);
        DateLapse lapseCero = new DateLapse(fecha, fecha);

        assertEquals(0, lapseCero.sizeInDays());

    }

    @Test
    void minimaDiferencia (){
        LocalDate from = LocalDate.of(2025, 1, 1);
        LocalDate to = LocalDate.of(2025, 1, 2);

        DateLapse lapseUno = new DateLapse(from, to);

        assertEquals(1, lapseUno.sizeInDays());
    }

}