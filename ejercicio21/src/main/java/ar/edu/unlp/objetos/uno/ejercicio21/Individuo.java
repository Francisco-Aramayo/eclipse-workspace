package ar.edu.unlp.objetos.uno.ejercicio21;

import java.time.LocalDate;

public class Individuo extends Cliente {
	
	private String DNI;
	private String nombre;

	public Individuo (String nombre, String direccion, String DNI) {
		super(direccion);
		this.DNI = DNI;
		this.nombre = nombre;
	}
	
	@Override
	public double montoPagar(LocalDate inicio, LocalDate fin) {
		double montoBase = super.montoPagar(inicio, fin);
		return montoBase * 0.90;
	}
	
}
