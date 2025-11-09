package ar.edu.unlp.objetos.uno.ejercicio7;

public class Cuadrado extends Figura2d{

	private double lado;
	
	public Cuadrado () {
		
	}
	
	public double getPerimetro() {
		return lado * 4;
	}

	public double getArea() {
		return lado * lado;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
}
