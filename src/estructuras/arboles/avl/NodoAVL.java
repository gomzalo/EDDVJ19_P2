/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.avl;

import pojos.Catedratico;

/**
 *
 * @author G
 */
public class NodoAVL {
    private NodoAVL izquierda, derecha;
    int altura;
    private Catedratico catedratico;

    public NodoAVL(Catedratico catedratico) {
        izquierda = null;
        derecha = null;
        altura = 0;
        this.catedratico = catedratico;
    }

    public NodoAVL() {
        izquierda = null;
        derecha = null;
        altura = 0;
        catedratico = null;
    }

    public NodoAVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }
    
}
