package ar.edu.unlp.objetos.uno.ejercicio11;

public class CuentaCorriente extends Cuenta {

	// pueden extraer saldo aun sin tener saldo suficiente.
	
	/* SOLAMENTE si no supera el limite de saldo negativo
	
	*	limiteDescubierto = diferente en cada cuenta, lo negocia el 
	*	cliente con el banco
	*
	*/
	
	// cuando se abre una cuenta corriente, su límite descubierto es 0
	
	private double descubierto;
	
	
	public CuentaCorriente () {
		this.descubierto = 0;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	@Override 
	protected boolean puedeExtraer(double monto) {
		return this.getSaldo() + this.getDescubierto() >= monto;
	}
	
	
}
