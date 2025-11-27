package ar.edu.unlp.objetos.uno.ejercicio21;

import java.time.LocalDate;

public class EnvioInterUrbano extends Envio{
	
	private double distancia;
	
	public EnvioInterUrbano (LocalDate fechaDespacho, String direccionOrigen, String
			direccionDestino, double peso, double distancia) {
		super(fechaDespacho,direccionOrigen,direccionDestino,peso);
		this.distancia = distancia;
	}

	/*Los envíos interurbanos tienen un costo que depende de la distancia entre
	 *  el origen y el destino (utilice $20 para menos de 100 km por cada gramo 
	 *  de peso, $25 para distancias entre 100 km y 500 km por gramo de peso, y 
	 *  $30 para distancias de más de 500 km por gramo de peso). */
	
	
	@Override
	public double calcularCosto() {
	
		double pesoGramos = super.getPeso();
		
		double distanciaKm = this.distancia;
		
		double costoPorGramo = (distanciaKm < 100) ? 
				20.0 : 
				(distanciaKm <= 500) ?
						25.0 : 
						30.0;
		
		return costoPorGramo * pesoGramos;
	
	}
	
	

}
