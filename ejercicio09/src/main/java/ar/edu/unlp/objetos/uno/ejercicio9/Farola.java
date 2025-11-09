package ar.edu.unlp.objetos.uno.ejercicio9;

import java.util.List;
import java.util.LinkedList;

public class Farola {
	private Boolean estado;
	private List<Farola> vecinas;
	
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/

	
	public Farola () {
		this.estado = false;
		this.vecinas = new LinkedList<>();
	}

	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos 
	* entre las farolas es recíproca, es decir el receptor del mensaje será 
	* vecino de otraFarola, al igual que otraFarola también se convertirá en 
	* vecina del receptor del mensaje
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		if (!this.vecinas.contains(otraFarola)) {
			this.vecinas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}

	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors () {
		return this.vecinas;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.estado) {
			this.estado = true; // la enciendo
			this.vecinas.stream()
				.filter(Farola::isOff)
				.forEach(Farola::turnOn);
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.estado) {
			this.estado = false;
			this.vecinas.stream()
				.filter(Farola::isOn)
				.forEach(Farola::turnOff);
			
		}
	}
	
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.estado;
	}

	/*
	* Retorna true si la farola está apagada.
	*/
	public boolean isOff() {
		return !this.estado;
	}

}
