package ar.edu.unlp.objetos.uno;

import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EvenNumberSetTest {

    private Set<Integer> evenNumbers;

    @BeforeEach
    void setUp() {
        // Instanciamos la clase
        this.evenNumbers = new EvenNumberSet();
    }

    // TEST PARA ADD
    @Test
    @DisplayName("P.E - Agregar número PAR valido")
    void testAddPar() {
        // condición debe ser exitosa
        assertTrue(evenNumbers.add(4));
        assertTrue(evenNumbers.contains(4));
        assertEquals(1, evenNumbers.size());
    }

    @Test
    @DisplayName("V.B -Cero (0) debe ser considerado par")
    void testAddCero() {
        assertTrue(evenNumbers.add(0));
        assertTrue(evenNumbers.contains(0));
        assertEquals(1, evenNumbers.size());
    }

    @Test
    @DisplayName("V.B - Agregar un duplicado (restriccion del set)")
    void testAddDuplicado() {
        evenNumbers.add(10);
        // la adicion debe ser rechazada, aunque sea par, ya existe
        assertFalse(evenNumbers.add(10));
        assertEquals(1, evenNumbers.size());
    }

    // Test para addall (collection c)
    @Test
    @DisplayName("V.B - Agregar colección con elementos pares e impares")
    void testAddAllMixto(){
        Collection<Integer> mixta = Arrays.asList(2,5,7,11,14);

        // operación debe retornar true porque se modifico el set
        assertTrue(evenNumbers.addAll(mixta));

        assertEquals(3, evenNumbers.size());
        assertTrue(evenNumbers.contains(2));
        assertTrue(evenNumbers.contains(8));
        assertFalse(evenNumbers.contains(5));   // impar rechazado
        assertFalse(evenNumbers.contains(11));  // impar rechazado
    }

    @Test
    @DisplayName("P.E - Agregar colección vacía o solo impares")
    void testAddAllNoCambia() {
        evenNumbers.add(10);
        Collection<Integer> impares = Arrays.asList(1, 3, 5);

        // Debe retornar false porque ningún elemento cumplió la restricción 
        assertFalse(evenNumbers.addAll(impares));
        assertEquals(1, evenNumbers.size());
    }

    @Test
    @DisplayName("Delegacion - Testear contains y remove")
    void testContainsAndRemove() {
        evenNumbers.add(10);
        evenNumbers.add(20);

        // delegacion de contains
        assertTrue(evenNumbers.contains(10));
        assertFalse(evenNumbers.contains(15));

        // delegación de remove
        assertTrue(evenNumbers.remove(10));
        assertFalse(evenNumbers.contains(10));
        assertEquals(1, evenNumbers.size());
    }

}
