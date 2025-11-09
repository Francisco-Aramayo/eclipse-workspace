package ar.edu.unlp.objetos.uno.ejercicio7;

public class Circulo extends Figura2d{

	private double radio;
	
	public Circulo () {
		
	}
	
	public double getDiametro () {
		return this.radio * 2;
	}
	public void setDiametro (double diametro) {
		this.radio = diametro / 2;
	}
	public double getRadio () {
		return this.radio;
	}
	public void setRadio (double radio) {
		this.radio = radio;
	}
	

	public double getPerimetro() {
		
		return Math.PI * this.radio * 2;
	}

	public double getArea() {

		return Math.PI * (this.radio * this.radio);
		
	}

	
}
