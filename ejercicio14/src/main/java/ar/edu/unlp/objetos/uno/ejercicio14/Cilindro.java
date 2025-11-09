package ar.edu.unlp.objetos.uno.ejercicio14;

public class Cilindro extends Pieza{
    private double radio;

    public Cilindro (String material, String color,
                        double altura, double radio){
        super(material, color, altura);
        this.radio = radio;
    }

    @Override
    public double getVolumen(){
        return Math.PI * Math.pow(radio, 2)
                * super.getAltura();
    }

    @Override
    public double getSuperficie(){
        return 2 * Math.PI * this.radio * super.getAltura()
                + 2 * Math.PI * Math.pow(radio, 2);
    }
}
