package ar.edu.unlp.objetos.uno.ejercicio21;

public class Corporativo extends Cliente {
	
	private String nombreEmpresa;
	private String cuit;
	
	public Corporativo (String nombreEmpresa, String direccion, String cuit) {
		super(direccion);
		this.nombreEmpresa = nombreEmpresa;
		this.cuit = nombreEmpresa;
	}
	
}
