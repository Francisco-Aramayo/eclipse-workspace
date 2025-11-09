package ar.edu.unlp.objetos.uno.ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para las clases CajaDeAhorro y CuentaCorriente.
 * 
 */
public class CuentaTest {

    private CajaDeAhorro caja;
    private CuentaCorriente corriente;

    @BeforeEach
    void setUp() throws Exception {
        caja = new CajaDeAhorro();
        corriente = new CuentaCorriente();
    }

    @Test
    public void testDepositarEnCajaDeAhorro() {
        caja.depositar(1000);
        // se descuenta 2% por operación
        assertEquals(980, caja.getSaldo(), 0.01);
    }

    @Test
    public void testExtraerDeCajaDeAhorro() {
        caja.depositar(1000); // saldo neto: 980
        boolean pudoExtraer = caja.extraer(500); // se cobra 2% adicional (510)
        assertTrue(pudoExtraer);
        assertEquals(470, caja.getSaldo(), 0.01);
    }

    @Test
    public void testNoPuedeExtraerDeCajaDeAhorroPorFondosInsuficientes() {
        caja.depositar(100); // queda 98
        boolean pudoExtraer = caja.extraer(100); // necesita 102
        assertFalse(pudoExtraer);
        assertEquals(98, caja.getSaldo(), 0.01);
    }

    @Test
    public void testCuentaCorrienteConDescubierto() {
        corriente.depositar(100);
        corriente.setDescubierto(200);
        assertTrue(corriente.extraer(250)); // saldo final -150
        assertEquals(-150, corriente.getSaldo(), 0.01);
    }

    @Test
    public void testCuentaCorrienteSinDescubierto() {
        corriente.depositar(100);
        assertFalse(corriente.extraer(150)); // no tiene descubierto
        assertEquals(100, corriente.getSaldo(), 0.01);
    }

    @Test
    public void testTransferenciaEntreCuentas() {
        caja.depositar(1000); // saldo neto: 980
        corriente.setDescubierto(100);

        boolean pudoTransferir = caja.transferirACuenta(200, corriente);
        assertTrue(pudoTransferir);

        // Caja de ahorro paga 2% adicional sobre los 200 → 204
        assertEquals(776, caja.getSaldo(), 0.01);
        assertEquals(200, corriente.getSaldo(), 0.01);
    }
}
