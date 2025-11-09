package ar.edu.unlp.objetos.uno.ejercicio11;

public class CajaDeAhorro extends Cuenta{

	// solo puedo extraer y transferir cuando tengo fondos suficientes
	
	// costo adicional de 2% del monto en cada op (tener  en cuenta antes de 
	// permitir una extracción o transferencia
	
	// viene a actuar de constante
	private static final double COSTO_OPERACION = 0.02;
	
	// calcula el monto total y devuelve si cumple
	
	@Override
	protected boolean puedeExtraer (double monto) {
		double montoTotal = monto + (monto * COSTO_OPERACION);
		return this.getSaldo() >= montoTotal;
	}
	
	@Override 
	protected void extraerSinControlar(double monto) {
		double montoTotal = monto + (monto * COSTO_OPERACION);
		super.extraerSinControlar(montoTotal);
	}
	
	@Override
	public void depositar(double monto) {
		double montoNeto = monto - (monto * COSTO_OPERACION);
		super.depositar(montoNeto);
	}
	
}
