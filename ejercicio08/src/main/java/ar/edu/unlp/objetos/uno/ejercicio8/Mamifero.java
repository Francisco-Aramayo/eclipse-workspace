package ar.edu.unlp.objetos.uno.ejercicio8;

import java.time.LocalDate;

import java.time.LocalDate;

public class Mamifero {

	private Mamifero madre;
	private Mamifero padre;
	private String especie;
	private String id;
	private LocalDate fechaNacimiento;
	
	
	public Mamifero(String id) {
		this.id = id;
	}
	public Mamifero() {
		
	}
	
	public String getIdentificador() {
		return this.id;
	}
	public void setIdentificador(String id) {
		this.id = id;
	}
	public String getEspecie() {
		return this.especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}
	public Mamifero getPadre() {
		return this.padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return this.madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbueloMaterno() {
		if (this.madre != null) {
			return this.madre.getPadre();
		}
		
		return null;
	}
	public Mamifero getAbuelaMaterna() {
		if (this.madre != null) {
			return this.madre.getMadre();
		}
		
		return null;
	}
	public Mamifero getAbueloPaterno() {
		if (this.padre != null) {
			return this.padre.getPadre();
		}
		
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if (this.padre != null) {
			return this.padre.getMadre();
		}
		
		return null;
	}
	
	// mensaje a sus padres es recursivo?
	public Boolean helper (Mamifero unMamifero) {
		return this.equals(unMamifero) || 
				(this.padre != null && this.padre.helper(unMamifero)) ||
				(this.madre != null && this.madre.helper(unMamifero)); 
	}
	
	public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		/*if (this.madre == null && this.padre == null) {
			return false;
		}else if (this.madre.getIdentificador() == unMamifero.id || 
					this.padre.getIdentificador() == unMamifero.id) {
			return true;
		}else {
			if (this.madre != null) {
				this.madre.tieneComoAncestro(unMamifero);
			}
			if (this.padre != null) {
				this.padre.tieneComoAncestro(unMamifero);
			}
		}*/
		return (!this.equals(unMamifero) && this.helper(unMamifero));
		
	}
	
	
}
