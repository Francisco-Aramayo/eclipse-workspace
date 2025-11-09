package ar.edu.unlp.objetos.uno.ejercicio7;

public class Cuerpo3D {
	
	private Figura2d caraBasal;
	private double altura;
	
	
	public void setAltura (double altura) {
		this.altura = altura;
	}
	
	public double getAltura () {
		return this.altura;
	}
	
	public void setCaraBasal (Figura2d caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public double getVolumen () {
		return this.caraBasal.getArea() * altura;
	}
	
	public double getSuperficieExterior () {
		return 2 * this.caraBasal.getArea() + 
				this.caraBasal.getPerimetro() * this.altura;
	}

	
}
