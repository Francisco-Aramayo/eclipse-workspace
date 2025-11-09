package ar.edu.unlp.objetos.uno.ejercicio2;

public class Balanza {

	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Balanza () {
		this.ponerEnCero();
	}
	
	public void ponerEnCero () {
		this.pesoTotal = 0;
		this.precioTotal = 0;
		this.cantidadDeProductos = 0;
	}
	
	public void agregarProducto (Producto producto) {
		this.cantidadDeProductos++;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
	}
	
	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(this.cantidadDeProductos, this.precioTotal, this.pesoTotal);
		return ticket;
	}
	
	public double getPrecioTotal () {
		return this.precioTotal;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public int getCantidadDeProductos () {
		return this.cantidadDeProductos;
	}
	
}
