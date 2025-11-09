package ar.edu.unlp.objetos.uno.ejercicio14;

public abstract class Pieza {
    private String material;
    private String color;
    private double altura;

    public Pieza(String material, String color, double altura){
        this.material = material;
        this.color = color;
        this.altura = altura;
    }

    protected abstract double getVolumen();
    protected abstract double getSuperficie();

    public void setMaterial(String material){
        this.material = material;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getMaterial() { return material;}
    public String getColor() { return color; }
    public double getAltura() { return altura; }
}
