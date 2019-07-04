/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.avl.subestructura.cola;

import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ColaAVL {
    NodoColaAVL inicio;
    int tamano;

    public ColaAVL() {
        this.inicio = null;
        this.tamano = 0;
    }
        
    public boolean esVacia(){
        return inicio == null;
    }

    public NodoColaAVL getInicio() {
        return inicio;
    }

    public int getTamano() {
        return tamano;
    }
    
    public void encolar(NodoColaAVL nuevo){
        if(buscar(nuevo.getCatedratico().getId())){
            System.out.println("El ID: " + nuevo.getCatedratico().getId() + ", ya existe en la cola.");
        }else{
            if(esVacia()){
                inicio = nuevo;
                System.out.println("Se ha agregado correctamente el id: " + nuevo.getCatedratico().getId() + ", a la cola.");
                tamano++;
            }else{
                NodoColaAVL auxiliar = inicio;
                while(auxiliar != null){
                    if(auxiliar.getSiguiente() == null){
                        auxiliar.setSiguiente(nuevo);
                        nuevo.setSiguiente(null);
                        System.out.println("Se ha agregado correctamente el id: " + nuevo.getCatedratico().getId() + ", a la cola.");
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
                tamano++;
            }
        }
    }
    
    public NodoColaAVL desencolar(){
        if(esVacia()){
            System.out.println("No hay nada que desencolar.");
            return null;
        }else{
            NodoColaAVL eliminado;
            System.out.println("Se desencolo ID: " + inicio.getCatedratico().getId());
            NodoColaAVL auxiliar = inicio.getSiguiente();
            eliminado = inicio;
            inicio.setSiguiente(null);
            inicio = auxiliar;
            
            tamano--;
            return eliminado;
        }        
    }
    
    public void mostrar(){
        if(esVacia()){
            System.out.println("Cola vacia.");
        }else{
            NodoColaAVL auxiliar = inicio;
            System.out.println("\nContenido en la cola.");
            while(auxiliar != null){
                System.out.print("\nID: " + inicio.getCatedratico().getId() + "->");
                auxiliar = auxiliar.getSiguiente();
            }
        }
    }
    
    public boolean buscar(int id){
        boolean encontrado = false;
        NodoColaAVL auxiliar = inicio;
        while(auxiliar != null){
            if(id == auxiliar.getCatedratico().getId()){
                encontrado = true;
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return encontrado;
    }
    
}
