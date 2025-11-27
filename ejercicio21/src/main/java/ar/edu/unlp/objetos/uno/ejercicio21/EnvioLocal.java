package ar.edu.unlp.objetos.uno.ejercicio21;

import java.time.LocalDate;

public class EnvioLocal extends Envio{
	
	private boolean rapido;
	
	public EnvioLocal(LocalDate fechaDespacho, String direccionOrigen, String
			direccionDestino, double peso, boolean rapido) {
		super(fechaDespacho,direccionOrigen,direccionDestino,peso);
		this.rapido = rapido;
	}

	@Override
	public double calcularCosto() {
		
		return this.rapido ? 1500.0 : 500.0;
	}
	
}
