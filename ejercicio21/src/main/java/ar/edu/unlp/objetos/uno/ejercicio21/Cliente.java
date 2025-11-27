package ar.edu.unlp.objetos.uno.ejercicio21;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public abstract class Cliente {
	private String direccion;
	private List<Envio> envios;
	
	public Cliente (String direccion) {
		this.direccion = direccion;
		this.envios = new ArrayList<>();
	}
	
	
	public void agregarPedido(Envio envio) {
		this.envios.add(envio);
	}
	
	public double montoPagar(LocalDate inicio, LocalDate fin) {
		
		return this.envios.stream()
				.filter(e -> !e.getFechaDespacho().isBefore(inicio)
						&& !e.getFechaDespacho().isAfter(fin))
				.mapToDouble(Envio :: calcularCosto)
				.sum();
	}
	
	
	
}
