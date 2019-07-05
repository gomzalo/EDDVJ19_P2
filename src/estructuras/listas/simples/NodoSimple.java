/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples;

/**
 *
 * @author g
 */
public class NodoSimple {
    private NodoSimple siguiente;
    private int id;

    public NodoSimple() {
        this.siguiente = null;
        this.id = 0;
    }
    
    public NodoSimple(int dato) {
        this.siguiente = null;
        this.id = dato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }

}
