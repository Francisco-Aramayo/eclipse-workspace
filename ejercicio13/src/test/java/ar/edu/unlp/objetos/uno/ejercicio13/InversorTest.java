package ar.edu.unlp.objetos.uno.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
    private Inversor inversor;

    @BeforeEach
    public void setUp() {
        inversor = new Inversor("Francisco");
    }

    @Test 
    public void testInversionEnAcciones() {
        InversionEnAcciones accion = new InversionEnAcciones("YPF", 10,500);
        assertEquals(5000, accion.valorActual(), 0.01);
    }

    @Test
    public void testValorTotalInversor() {
        InversionEnAcciones a1 = new InversionEnAcciones("Tesla",
         5, 200);
        PlazoFijo pf = new PlazoFijo(1000,
          0.01, LocalDate.now().minusDays(5));
        
        inversor.agregarInversion(a1);
        inversor.agregarInversion(pf);

        double totalEsperado = a1.valorActual() + pf.valorActual();
        assertEquals(totalEsperado, inversor.valorActualTotal(), 0.01);
         
    }

    // valores borders

    @Test
    public void testPlazoFijoSinDias() {
        PlazoFijo pf = new PlazoFijo(1000, 0.01, LocalDate.now());
        assertEquals(1000, pf.valorActual(), 0.01);
    }

    @Test
    public void testInversionAccionesCantidadCero() {
        InversionEnAcciones accion = new InversionEnAcciones("MSFT", 0,
         200);
        assertEquals(0, accion.valorActual(), 0.01);
    }

    
}
