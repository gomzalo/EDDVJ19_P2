/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.dobles.circular;

import pojos.Edificio;

/**
 *
 * @author g
 */
public class NodoDC {
    private NodoDC siguiente;
    private NodoDC anterior;
    private Edificio edificio;

    public NodoDC(Edificio edificio) {
        this.siguiente = null;
        this.anterior = null;
        this.edificio = edificio;
    }

    public NodoDC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDC anterior) {
        this.anterior = anterior;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public String getContenido(String _id){
        String contenido = "";
        if(this.getEdificio()!= null){
            contenido +=
            "\t\t" + _id + this.getEdificio().getNombre().replaceAll("\\s+", "")
            +   "[label = "
                +   "<"
                    +   "<FONT POINT-SIZE = \"10\">"
                    +   " Nombre: " + this.getEdificio().getNombre()
                    +   " </FONT>"
                +   ">"
            +   "]"
            +   "\n";
        }
        return contenido;
    }
    
}
