/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.b;

import pojos.Horario;

/**
 *
 * @author G
 */
public class PaginaB<T> {
    private int indice;
    private PaginaB<T>[] hijos;
    private NodoB<Horario>[] llaves;
    private int llenura;
    private int tam;
    private int indiceDivision;
    
    public PaginaB(int tam, int indiceDivision){
        this.tam = tam;
        this.llenura = 0;
        this.hijos = null;
        this.llaves = new NodoB[tam+1];
        this.indiceDivision = indiceDivision;
    }

    public PaginaB<T> insertarLlave(NodoB<Horario> nuevo){
        if(this.llaves != null){
            NodoB<Horario> temporal=nuevo;
            for (int i = 0; i <= tam; i++) {
                if(llaves[i] != null){
                    if(temporal.getLlave().compareTo(llaves[i].getLlave()) < 0 ){//si toca insertar al NUEVO en ese lugar
                        NodoB<Horario> temporal2= llaves[i];
                        llaves[i] = temporal;
                        temporal = temporal2;
                    }else if(!nuevo.equals(temporal)){//si ya se inserto el nuevo
                        NodoB<Horario> temporal2 = llaves[i];
                        llaves[i] = temporal;
                        temporal = temporal2;
                    }
                }else{
                    llaves[i] = temporal;
                    i = tam;
                }
            }
            llenura++;
            if(llenura>tam){//si ya esta lleno el nodo, dividirlo
                PaginaB<T> nueva = new PaginaB<>(tam,indiceDivision);
                PaginaB<T> izq = new PaginaB<>(tam,indiceDivision);
                PaginaB<T> der = new PaginaB<>(tam,indiceDivision);
                if(hijos != null){
                    izq.hijos = new PaginaB[tam+2];
                    der.hijos = new PaginaB[tam+2];
                }
                for (int i = 0; i < llenura; i++) {
                    if(i > indiceDivision){//insertar en el nodo derecho
                        der.llaves[i-indiceDivision-1] = llaves[i];
                        der.llenura++;
                        if(hijos != null)
                            der.hijos[i-indiceDivision] = hijos[i+1];
                    }else if(i == indiceDivision){//insertar en el nodo izquierdo, insertar ultimo hijo
                        nueva.llaves[i-indiceDivision] = llaves[i];
                        nueva.llenura++;
                        if(hijos != null){
                            izq.hijos[i] = hijos[i];
                            der.hijos[i-indiceDivision] = hijos[i+1];
                        }
                    }else{//insertar en el nodo izquierdo
                        if(hijos != null)
                            izq.hijos[i] = hijos[i];
                        izq.llaves[i] = llaves[i];
                        izq.llenura++;
                    }
                }
                nueva.hijos = new PaginaB[tam+2];
                nueva.hijos[0] = izq;
                nueva.hijos[1] = der;
                return nueva;
            }
            return null;
        }
        return null;
        
        
    }
    

    public void insertarHijo(PaginaB<T> nuevoHijo){
        if(hijos == null){
            hijos = new PaginaB[tam + 2];
        }
        hijos[llenura] = nuevoHijo;
        llenura++;
    }
    
    public void insertarHijoBorrando(PaginaB<T> nuevoHijo, int indice){
        /*
        if(indice>=tam){
            hijos[indice]=nuevoHijo;
        }else{
            PaginaB<T> temporal=nuevoHijo;
            for (int i = indice; i < tam; i++) {
                if(hijos[i]!=null){
                    PaginaB<T> temporal2=hijos[i];
                    hijos[i]=temporal;
                    temporal=temporal2;
                }else{
                    hijos[i]=temporal;
                    
                }
            }
        }*/
        hijos[indice]=nuevoHijo;
        
    }
    
    public void insertarHijoSinBorrar(PaginaB<T> nuevoHijo, int indice){
        
        if(indice >= tam){
            hijos[indice] = nuevoHijo;
        }else{
            PaginaB<T> temporal = nuevoHijo;
            for (int i = indice; i <= tam+1; i++) {
                if(hijos[i] != null) {
                    PaginaB<T> temporal2 = hijos[i];
                    hijos[i] = temporal;
                    temporal = temporal2;
                }else{
                    hijos[i] = temporal;
                    i = tam;
                }
            }
        }
    }
    
    public int buscarIndice(String llave){
        for (int i = 0; i < llenura; i++) {
            if(llaves[i] != null){
            	if(llaves[i].getLlave().compareTo(llave) > 0){
                    return i;
                }
            }
        }
        return llenura;
    }
    
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public PaginaB<T>[] getHijos() {
        return hijos;
    }

    public void setHijos(PaginaB<T>[] hijos) {
        this.hijos = hijos;
    }

    public NodoB<Horario>[] getLlaves() {
        return llaves;
    }

    public void setLlaves(NodoB<Horario>[] llaves) {
        this.llaves = llaves;
    }

    public int getLlenura() {
        return llenura;
    }

    public void setLlenura(int llenura) {
        this.llenura = llenura;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getIndiceDivision() {
        return indiceDivision;
    }

    public void setIndiceDivision(int indiceDivision) {
        this.indiceDivision = indiceDivision;
    }
    
    
}