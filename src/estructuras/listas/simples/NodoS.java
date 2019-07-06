/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples;

import pojos.Asignacion;

/**
 *
 * @author g
 */
public class NodoS {
    private NodoS siguiente;
    private Asignacion asignacion;

    public NodoS() {
        this.siguiente = null;
        this.asignacion = null;
    }
    
    public NodoS(Asignacion asignacion) {
        this.siguiente = null;
        this.asignacion = asignacion;
    }

    public NodoS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoS siguiente) {
        this.siguiente = siguiente;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }
    
    public String getContenido(String _id){
        String contenido = "";
        if(this.getAsignacion()!= null){
            contenido +=
                "\t\t" + _id + this.getAsignacion().getCarnet()
            +   "[label = "
                +   "<"
                +   " Codigo: " + this.getAsignacion().getCarnet()
                +   " <BR /> "
                    +   "<FONT POINT-SIZE = \"9\">"
                    +   " <BR /> "
                    +   "Codigo curso: " + this.getAsignacion().getCodigo_curso()
                    +   " <BR /> "
                    +   "Zona: " + this.getAsignacion().getZona()
                    +   " <BR /> "
                    +   "Final: " + this.getAsignacion().getNota_final()
                    +   " </FONT>"
                +   ">"
            +   "]"
            +   "\n";
        }
        return contenido;
    }
    
}
