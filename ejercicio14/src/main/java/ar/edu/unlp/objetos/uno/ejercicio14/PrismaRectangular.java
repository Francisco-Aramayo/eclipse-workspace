package ar.edu.unlp.objetos.uno.ejercicio14;

public class PrismaRectangular extends Pieza{
    private double ladoMayor;
    private double ladoMenor;

    public PrismaRectangular(String material, String color, double altura, 
                double ladoMayor, double ladoMenor){
        super(material, color, altura);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
    }

    @Override
    public double getVolumen(){
        return ladoMayor * ladoMenor*super.getAltura();
    }

    @Override
    public double getSuperficie() {
        return 2 * (ladoMayor * ladoMenor + ladoMayor * super.getAltura()
                        + ladoMenor* super.getAltura());
    }
}
