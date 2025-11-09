package ar.edu.unlp.objetos.uno.ejercicio14;

public class Esfera extends Pieza{
    private double radio;

    public Esfera (String material, String color, double altura, double radio){
        super(material,color,altura);
        this.radio = radio;
    }

    @Override
    public double getVolumen(){
        return (4.0/3.0) * Math.PI * Math.pow(radio, 3); 
    }

    @Override
    public double getSuperficie(){
        return 4 * Math.PI * Math.pow(radio, 2);
    }

}
