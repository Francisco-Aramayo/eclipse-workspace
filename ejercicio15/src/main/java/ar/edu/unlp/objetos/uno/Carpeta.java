package ar.edu.unlp.objetos.uno;

import java.util.List;
import java.util.LinkedList;

public class Carpeta {
    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.emails = new LinkedList<>();
    }

    public String getNombre() { return nombre; }

    public void agregarMail(Email mail){
        this.emails.add(mail);
    }
    
    public void eliminarMail(Email mail) {
        this.emails.remove(mail);
    }

    /*En respuesta al mensaje mover, mueve el email desde una carpeta de 
    origen a una carpeta destino (asuma que el email está en la carpeta origen
    cuando se recibe este mensaje).  */
    public void mover(Email email, Carpeta destino){
        this.eliminarMail(email);
        destino.agregarMail(email);
    }

    // devuelve el espacio de una carpeta
    public int getEspacio(){
        return emails.stream()
        .mapToInt(Email :: getTamanio)
        .sum();
    }

    public Email buscar(String texto){
        return this.emails.stream()
                            .filter(e -> e.cumple(texto))
                            .findFirst()
                            .orElse(null);
    }
}
