/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.b.subestructuras.cola;

import estructuras.arboles.avl.subestructura.cola.*;
import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ColaB {
    NodoColaB inicio;
    int tamano;

    public ColaB() {
        this.inicio = null;
        this.tamano = 0;
    }
        
    public boolean esVacia(){
        return inicio == null;
    }

    public NodoColaB getInicio() {
        return inicio;
    }

    public int getTamano() {
        return tamano;
    }
    
    public void encolar(NodoColaB nuevo){
        if(buscar(nuevo.getHorario().getCodigo())){
            System.out.println("El codigo: " + nuevo.getHorario().getCodigo() + ", ya existe en la cola.");
        }else{
            if(esVacia()){
                inicio = nuevo;
                System.out.println("Se ha agregado correctamente el codigo: " + nuevo.getHorario().getCodigo() + ", a la cola.");
                tamano++;
            }else{
                NodoColaB auxiliar = inicio;
                while(auxiliar != null){
                    if(auxiliar.getSiguiente() == null){
                        auxiliar.setSiguiente(nuevo);
                        nuevo.setSiguiente(null);
                        System.out.println("Se ha agregado correctamente el codigo: " + nuevo.getHorario().getCodigo() + ", a la cola.");
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
                tamano++;
            }
        }
    }
    
    public NodoColaB desencolar(){
        if(esVacia()){
            System.out.println("No hay nada que desencolar.");
            return null;
        }else{
            NodoColaB eliminado;
            System.out.println("Se desencolo codigo: " + inicio.getHorario().getCodigo());
            NodoColaB auxiliar = inicio.getSiguiente();
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
            NodoColaB auxiliar = inicio;
            System.out.println("\nContenido en la cola.");
            while(auxiliar != null){
                System.out.print("\ncodigo: " + inicio.getHorario().getCodigo() + "->");
                auxiliar = auxiliar.getSiguiente();
            }
        }
    }
    
    public boolean buscar(int id){
        boolean encontrado = false;
        NodoColaB auxiliar = inicio;
        while(auxiliar != null){
            if(id == auxiliar.getHorario().getCodigo()){
                encontrado = true;
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return encontrado;
    }
    
}
