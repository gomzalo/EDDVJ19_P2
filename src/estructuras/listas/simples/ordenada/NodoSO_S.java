/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples.ordenada;

import pojos.Salon;

/**
 *
 * @author g
 */
public class NodoSO_S {
    private Salon salon;
    private NodoSO_S siguiente;

    public NodoSO_S(Salon salon) {
        this.salon = salon;
        this.siguiente = null;
    }

    public NodoSO_S getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSO_S siguiente) {
        this.siguiente = siguiente;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    
    public String getContenido(String _id){
        String contenido = "";
        if(this.getSalon() != null){
            contenido +=
                "\t\t" + _id + this.getSalon().getNumero()
            +   "[label = "
                +   "<"
                +   " Numero: " + this.getSalon().getNumero()
                +   " <BR /> "
                    +   "<FONT POINT-SIZE = \"10\">"
                    +   "Nombre edificio: " + this.getSalon().getNombre_edificio()
                    +   " <BR /> "
                    +   "Capacidad: " + this.getSalon().getCapacidad()
                    +   " <BR /> "
                    +   "Cantidad de asignados: " + this.getSalon().getEstudiantes_asignados()
                    +   " </FONT>"
                +   ">"
            +   "]"
            +   "\n";
        }
        return contenido;
    }
    
}