package ar.edu.unlp.objetos.uno.ejercicio14;

import java.util.List;
import java.util.LinkedList;

public class ReporteDeConstruccion {

    private List<Pieza> piezas; 


    public ReporteDeConstruccion (){
        this.piezas = new LinkedList<>();
    }

    /*Recibe como parametro un nombre de material
     * y retorna la suma de los volmenes de todas las piezas hechas
     * en ese material
      */
    public double volumenDeMaterial(String material){
        return piezas.stream()
        .filter(pieza->pieza.getMaterial().equals(material))
        .mapToDouble(Pieza->Pieza.getVolumen())
        .sum();
    }

    /*Recibe como parámetro un color. Retorna la suma de las superficies
     * externas de todas las piezas pintadas con ese color
     */

    public double superficieDeColor(String color){
        return piezas.stream()
        .filter(pieza->pieza.getColor().equals(color))
        .mapToDouble(pieza->pieza.getSuperficie())
        .sum();
    }


    public void agregarPieza(Pieza pieza){
        this.piezas.add(pieza);
    }

}
