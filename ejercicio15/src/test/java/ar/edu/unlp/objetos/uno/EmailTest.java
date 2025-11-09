package ar.edu.unlp.objetos.uno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
    private Email email, emailVacio;
    private Archivo archivo1, archivo2;

    @BeforeEach
    void setUp(){
        email = new Email("Objetos1", "Ejercicio13");
        emailVacio = new Email("","");

        archivo1 = new Archivo("Archivo1");
        archivo2 = new Archivo("Archivo2");

        email.agregarAdjunto(archivo1);
        email.agregarAdjunto(archivo2);
    }

    @Test
    void testTamanioEmail() {
        assertEquals(35, email.getTamanio());
        assertEquals(0, emailVacio.getTamanio());
    }

    @Test
    void testCumple() {
        assertTrue(email.cumple("Objetos1"));
        assertTrue(emailVacio.cumple(""));
        assertFalse(email.cumple(null));
        assertFalse(email.cumple("HOLA"));
    }
}
