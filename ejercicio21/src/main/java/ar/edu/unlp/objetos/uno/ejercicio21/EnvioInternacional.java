package ar.edu.unlp.objetos.uno.ejercicio21;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {
	
	private boolean rapido;
	
	public EnvioInternacional (LocalDate fechaDespacho, String direccionOrigen, String
			direccionDestino, double peso, boolean rapido) {
		super(fechaDespacho,direccionOrigen,direccionDestino,peso);
		this.rapido = rapido;
	}

	@Override
	public double calcularCosto() {
		double peso = super.getPeso();
		
		// en base al peso 
		double factorRecargo = (peso <= 1000) ? 10.0 : 12.0;
		// base + peso * recargo
		double costoBase = 5000.0 + peso * factorRecargo;
		
		return costoBase + (this.rapido ? 500.0 : 0.0);
	}
}
