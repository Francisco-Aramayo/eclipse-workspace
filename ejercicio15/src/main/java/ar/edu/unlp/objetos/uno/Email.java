package ar.edu.unlp.objetos.uno;

import java.util.List;
import java.util.LinkedList;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;

    public Email (String titulo, String cuerpo){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new LinkedList<>();
    }

    public void agregarAdjunto(Archivo archivo){
        this.adjuntos.add(archivo);
    }

    public boolean cumple(String texto){
        return this.titulo.equals(texto) || this.cuerpo.equals(texto);
    }

    public String getTitulo() { return titulo; }
    public String getCuerpo() { return cuerpo; }
    public List<Archivo> adjuntos(){
        return new LinkedList<Archivo>(adjuntos);
    }

    /*El tamaño de un email es la suma del largo del título, el largo del 
    cuerpo, y del tamaño de sus adjuntos. */

    public int getTamanio(){
        return this.titulo.length() + this.cuerpo.length()
        + adjuntos.stream()
        .mapToInt(Archivo :: getTamanio)
        .sum();
    }

}
