/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples;

import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ListaSimple {
    protected NodoSimple inicio;
    protected int tamano;

    public ListaSimple() {
        inicio = null;
        tamano = 0;
    }

    public NodoSimple getInicio() {
        return inicio;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamano(){
        return this.tamano;
    }
    
    public void agregarAlFinal(NodoSimple nuevo){
//        NodoSimple nuevo = new NodoSimple(dato);
        if(esVacia()){
            // Lista vacia, por lo que el inicio sera igual al nodo nuevo.
            inicio = nuevo;
        }else{
            // Se posiciona al inicio el nodo auxiliar.
            NodoSimple auxiliar = inicio;
            while(auxiliar.getSiguiente() != null){
                auxiliar = auxiliar.getSiguiente();
            }
            // Una vez alcanzado el final, se agrega el nuevo nodo.
            auxiliar.setSiguiente(nuevo);
        }
        tamano++;
    }
    
    public NodoSimple buscarNodo(int id){
//        NodoSimple encontrado;
        if(!esVacia()){
            NodoSimple auxiliar = inicio;
            while(auxiliar != null){
                if(id == auxiliar.getId()){
//                    encontrado = auxiliar;
                    System.out.println("Se encontro el ID: " + id);
                    return auxiliar;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se encontro el ID: " + id);
        return null;
    }
    
    public boolean buscar(int id){
        NodoSimple auxiliar = inicio;
        boolean encontrado = false;
        
        while(auxiliar != null && encontrado != true){
            if(id == auxiliar.getId()){
                encontrado = true;
            }else{
                auxiliar = auxiliar.getSiguiente();
            }
        }
        
        return encontrado;
    }
    
    public void eliminar(int id){
//        if(buscar(id)){
            if(inicio.getId() == id){
                inicio = inicio.getSiguiente();
            }else{
                NodoSimple auxiliar = inicio;
                while(auxiliar.getSiguiente() != null){
                    if(auxiliar.getSiguiente().getId() == id){
                        System.out.println("Se elimino la imagen de ID: " + id);
                        auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
                        return;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
//                NodoSimple siguiente = auxiliar.getSiguiente().getSiguiente();
//                auxiliar.setSiguiente(siguiente);
            }
            tamano--;
//        }
    }
    
    public String graficar(String id, String titulo) throws IOException{
        String dot_grafo_lista_ordenada =
        "\n\t\tsubgraph cluster_lista_simple" + id
        +   "\n\t\t{"
        +   "\n\t\t\tgraph[color = \"white:gray\", fontcolor = \"black\", style = filled, fontsize = 7, label = \"" + titulo + "\"];"
        +   "\n\t\t\tnode[shape = tripleoctagon, style = filled, color = white, fillcolor = black, fontcolor = white, peripheries = 2];"
        +   "\n\t\t\tedge[color = \"purple:grey\"];"
        +   "\n"
            +   generarDot(id)
        +   "\n\t\t}"
        +   "\n";
        return dot_grafo_lista_ordenada;
    }
    
    public String generarDot(String id){
        String dot = "";
        if(!esVacia()){
            NodoSimple auxiliar_contenido = inicio;
            while(auxiliar_contenido != null){
                // -------------------  Contendio   -------------------
                // Actual
                dot += 	"\n\t\t\t" + id + auxiliar_contenido.getId()
                    + 	"[fillcolor = black, fontcolor = white, label = <"
                    +   "<FONT POINT-SIZE = \"9\">"
                    +   " ID imagen: " + auxiliar_contenido.getId()
                    +   " </FONT>"
                    +   ">"
                    +   "]";
                
                auxiliar_contenido = auxiliar_contenido.getSiguiente();
            }
            dot += "\n";
            
            NodoSimple auxiliar_enlaces = inicio;
            while(auxiliar_enlaces.getSiguiente() != null) {
                // -------------------  Enlaces   	-------------------
            	dot += "\n\t\t\t" + id + auxiliar_enlaces.getId() + "->" 
                    + id + auxiliar_enlaces.getSiguiente().getId();
            	auxiliar_enlaces = auxiliar_enlaces.getSiguiente();
            }
        }
        return dot;
    }
    
}
