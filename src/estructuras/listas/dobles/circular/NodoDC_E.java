/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.dobles.circular;

import estructuras.listas.simples.ordenada.ListaSO_S;
import pojos.Edificio;

/**
 *
 * @author g
 */
public class NodoDC_E {
    private NodoDC_E siguiente;
    private NodoDC_E anterior;
    private Edificio edificio;
    private ListaSO_S salones;

//    public NodoDC_E(Edificio edificio) {
//        this.siguiente = null;
//        this.anterior = null;
//        this.edificio = edificio;
//    }
    
    public NodoDC_E(Edificio edificio, ListaSO_S salones) {
        this.siguiente = null;
        this.anterior = null;
        this.edificio = edificio;
        this.salones = salones;
    }

    public NodoDC_E getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDC_E siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDC_E getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDC_E anterior) {
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

    public ListaSO_S getSalones() {
        return salones;
    }

    public void setSalones(ListaSO_S salones) {
        this.salones = salones;
    }
    
}
