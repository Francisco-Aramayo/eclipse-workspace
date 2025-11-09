package ar.edu.unlp.objetos.uno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
    private Archivo archivo;

    @BeforeEach
    void setUp(){
        archivo = new Archivo("Archivo");
    }

    @Test
    void tamanio() {
        assertEquals(7, archivo.getTamanio());
    }
}
