/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.avl.subestructura.cola;

import pojos.Catedratico;

/**
 *
 * @author g
 */
public class NodoColaAVL {
    private Catedratico catedratico;
    private NodoColaAVL siguiente;

    public NodoColaAVL(Catedratico catedratico) {
        this.catedratico = catedratico;
        this.siguiente = null;
    }

    public NodoColaAVL getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaAVL siguiente) {
        this.siguiente = siguiente;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }

}
