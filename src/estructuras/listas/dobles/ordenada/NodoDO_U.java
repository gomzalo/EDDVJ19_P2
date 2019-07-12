/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.dobles.ordenada;

import pojos.Usuario;

/**
 *
 * @author g
 */
public class NodoDO_U {
    private Usuario usuario;
    private NodoDO_U siguiente;
    private NodoDO_U anterior;

    public NodoDO_U(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
        this.anterior = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public NodoDO_U getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDO_U siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDO_U getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDO_U anterior) {
        this.anterior = anterior;
    }
    
    public String getContenido(String _id){
        String contenido = "";
        if(this.getUsuario()!= null){
            contenido +=
                "\t\t" + _id + this.getUsuario().getId()
            +   "[label = "
                +   "<"
                +   " ID: " + this.getUsuario().getId()
                +   " <BR /> "
                    +   "<FONT POINT-SIZE = \"9\">"
                    +   "Nombre: " + this.getUsuario().getNombre()
                    +   " <BR /> "
                    +   "Contrasena: " + this.getUsuario().getContrasena()
                    +   " <BR /> "
                    +   "Tipo: " + this.getUsuario().getTipo()
                    +   " </FONT>"
                +   ">"
            +   "]"
            +   "\n";
        }
        return contenido;
    }
    
}
