package ar.edu.unlp.objetos.uno;

public class Reserva {

    private Usuario usuario;
    private Propiedad propiedad;
    private DateLapseInterface periodo;
    
    public Reserva(Usuario usuario, Propiedad propiedad, DateLapseInterface
        periodo){

        this.usuario = usuario;
        this.propiedad = propiedad;
        this.periodo = periodo;
    }

    public DateLapseInterface getPeriodo() {
        return this.periodo;
    }

    public double calcularPrecio() {
        return this.periodo.sizeInDays() * this.propiedad.getPrecioxNoche();
    }

    public boolean estaEnCurso() {
        return this.periodo.includesDate(java.time.LocalDate.now());
    }

    public Propiedad getPropiedad() { return this.propiedad; }
}
