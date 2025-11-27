package ar.edu.unlp.objetos.uno.ejercicio21;

import java.time.LocalDate;

public abstract class Envio {
	
	private LocalDate fechaDespacho;
	private String direccionOrigen;
	private String direccionDestino;
	private double peso;
	
	
	public Envio (LocalDate fechaDespacho, String direccionOrigen, String
			direccionDestino, double peso) {
		this.fechaDespacho = fechaDespacho;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.peso = peso;
	}
	
	public abstract double calcularCosto();
	
	public double getPeso() { return this.peso; }
	
	public LocalDate getFechaDespacho() { return this.fechaDespacho; }
	
}
