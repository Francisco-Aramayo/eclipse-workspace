package ar.edu.unlp.objetos.uno;

import java.util.List;
import java.util.LinkedList;

public class ClienteDeCorreo {

    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo (String nombre){
        this.inbox = new Carpeta(nombre);
        this.carpetas = new LinkedList<>();
        this.carpetas.add(this.inbox);
    }

    public void agregarCarpeta(Carpeta carpeta) {
        this.carpetas.add(carpeta);
    }


    /*almacena en el inbox (una de las carpetas) el email que recibe como 
    parámetro. */
    public void recibirEmail(Email email){
        this.inbox.agregarMail(email);
    }

    public Carpeta getInbox() {
        return this.inbox;
    }
    public List<Carpeta> getCarpetas(){
        return new LinkedList<Carpeta>(this.carpetas);
    }

    /*retorna el primer email en el Cliente de Correo cuyo título o cuerpo 
    contienen el texto indicado como parámetro. Busca en todas las carpetas.*/
    public Email buscarEmail(String texto){
        return this.carpetas.stream()
                            .map(carpeta -> carpeta.buscar(texto))
                            .filter(carpeta -> carpeta.cumple(texto))
                            .findFirst()
                            .orElse(null);
    }

    /*En respuesta al mensaje espacioOcupado, retorna la suma del espacio 
    ocupado por todos los emails de todas las carpetas */
    public Integer espacioOcupado(){
        return carpetas.stream()
                .mapToInt(Carpeta :: getEspacio)
                .sum();
    }


    /// implementar el MOVER!!!!

}
