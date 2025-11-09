package ar.edu.unlp.objetos.uno.ejercicio4;
import java.time.LocalDate;
import java.util.List;

public class Ticket {
	
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	public Ticket (int cantidadDeProductos , double precioTotal, double 
			pesoTotal, List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
		this.productos = productos;
	}
	
	public double impuesto () {
		return this.precioTotal * 0.21;
	}
	
	public List<Producto> getProductos (){
		return this.productos;
	}
	
	
	
	public LocalDate getFecha () {
		return this.fecha;
	}
	
	public int getCantidadDeProductos () {
		return this.cantidadDeProductos;
	}
	
	public double getPrecioTotal () {
		return this.precioTotal;
	}
	
	public double getPesoTotal () {
		return this.pesoTotal;
	}
}
