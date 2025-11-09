package ar.edu.unlp.objetos.uno.ejercicio14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReporteTest {

    private ReporteDeConstruccion reporte;
    private Esfera esfera;
    private Cilindro cilindro;
    private PrismaRectangular prisma;

    @BeforeEach
    void setUp(){
        esfera = new Esfera("Hierro","Rojo",100,50);
        cilindro = new Cilindro("Cobre","Rojo",75,25);
        prisma = new PrismaRectangular("Hierro", "Verde", 15, 25, 25);

        reporte = new ReporteDeConstruccion();

        reporte.agregarPieza(esfera);
        reporte.agregarPieza(cilindro);
        reporte.agregarPieza(prisma);
    }

    @Test
    void testSumaVolumenes(){
        double volumenes = reporte.volumenDeMaterial("Hierro");
        double sumaMismo = esfera.getVolumen() + prisma.getVolumen();
        assertEquals(sumaMismo, volumenes);  // ¿¿
    }

    @Test 
    void testSumaSuperficies(){
        double superficies = reporte.superficieDeColor("Rojo");
        double sumaMismo = esfera.getSuperficie() + cilindro.getSuperficie();
        assertEquals(sumaMismo, superficies);
    }

    // 1. Test para Partición Equivalente: Material no existente
    @Test
    void testVolumenDeMaterial_NoExiste() {
        // Buscamos un material que no existe en el reporte
        double volumenes = reporte.volumenDeMaterial("Madera");
        // El resultado esperado debe ser 0.0
        assertEquals(0.0, volumenes, 0.001); 
    }

    // 2. Test para Partición Equivalente: Material existe pero no es el buscado
    @Test
    void testVolumenDeMaterial_OtroMaterial() {
        // Buscamos el material "Cobre"
        double volumenes = reporte.volumenDeMaterial("Cobre");
        // El resultado esperado es solo el volumen del Cilindro
        assertEquals(cilindro.getVolumen(), volumenes, 0.001); 
    }

    // 3. Test para Borde/Partición Equivalente: Mayúsculas/Minúsculas
    @Test
    void testSuperficieDeColor_BusquedaCaseInsensitive() {
        // Buscamos con minúsculas (asumiendo que las piezas tienen "Rojo" o "Verde")
        double superficies = reporte.superficieDeColor("rojo");
        double sumaEsperada = esfera.getSuperficie() + cilindro.getSuperficie();
        // Verificamos que funcione gracias a equalsIgnoreCase()
        assertEquals(sumaEsperada, superficies, 0.001); 
    }

    // 4. Test para Borde: Colección vacía
    @Test
    void testVolumenEnReporteVacio() {
        ReporteDeConstruccion reporteVacio = new ReporteDeConstruccion();
        double volumenes = reporteVacio.volumenDeMaterial("Hierro");
        // La suma de un stream vacío debe ser 0.0
        assertEquals(0.0, volumenes, 0.001);
    }

}
