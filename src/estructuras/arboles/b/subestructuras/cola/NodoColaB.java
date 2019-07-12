/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.b.subestructuras.cola;

import estructuras.arboles.avl.subestructura.cola.*;
import pojos.Catedratico;
import pojos.Horario;

/**
 *
 * @author g
 */
public class NodoColaB {
    private Horario horario;
    private NodoColaB siguiente;

    public NodoColaB(Horario horario) {
        this.horario = horario;
        this.siguiente = null;
    }

    public NodoColaB getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaB siguiente) {
        this.siguiente = siguiente;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}
