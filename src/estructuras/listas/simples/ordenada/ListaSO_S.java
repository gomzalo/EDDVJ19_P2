/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples.ordenada;

import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ListaSO_S {
    private NodoSO_S inicio;
    private int tamano;

    public ListaSO_S() {
        this.inicio = null;
        this.tamano = 0;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public NodoSO_S getInicio() {
        return inicio;
    }

    public int getTamano() {
        return tamano;
    }
    
    public void insertar(NodoSO_S nuevo){
        if(buscar(nuevo.getSalon().getNumero())){
            System.out.println("El salon con numero: " + nuevo.getSalon().getNumero() + ", ya existe en la lista.");
        }else{
            if(esVacia()){
                inicio = nuevo;
                System.out.println("Lista vacia, se inserto correctamente el salon con numero: " + nuevo.getSalon().getNumero() + ", a la lista.");
            }else{
                //Al inicio
                if(nuevo.getSalon().getNumero() < inicio.getSalon().getNumero()){
                    nuevo.setSiguiente(inicio);
                    inicio = nuevo;
                    System.out.println("Se inserto correctamente el salon con numero: "
                            + nuevo.getSalon().getNumero() + ", al inicio.");
                }else{
                    NodoSO_S auxiliar = inicio;

                    while(auxiliar.getSiguiente() != null){
                        NodoSO_S auxiliar2 = auxiliar.getSiguiente();
                        if(nuevo.getSalon().getNumero() < auxiliar2.getSalon().getNumero()){
                            nuevo.setSiguiente(auxiliar2);
                            auxiliar.setSiguiente(nuevo);
                            System.out.println("Se inserto correctamente el salon con numero: " 
                                    + nuevo.getSalon().getNumero() + ", al medio.");
                            return;
                        }
                        auxiliar = auxiliar.getSiguiente();
                    }
                    auxiliar.setSiguiente(nuevo);
                    System.out.println("Se inserto correctamente el salon con numero: " 
                            + nuevo.getSalon().getNumero() + ", al final.");
                }
                tamano++;
            }
        }
    }
    
    // Arreglar eliminación
    public void eliminar(int numero){
        if(!buscar(numero)){
            System.out.println("El salon con numero: " + numero + ", no existe en la lista.");
        }else{
            if(esVacia()){
                System.out.println("Lista vacia, nada que eliminar.");
            }else{
                if(numero == inicio.getSalon().getNumero()){
                    System.out.println("Se ha eliminado correctamente el salon con el numero: " + 
                            inicio.getSalon().getNumero() + ", al inicio.");
                    NodoSO_S auxiliar = inicio.getSiguiente();
                    inicio.setSiguiente(null);
                    inicio = auxiliar;
                    tamano--;
                }else{
                    NodoSO_S auxiliar = inicio;
                    while(auxiliar != null){
                        NodoSO_S auxiliar1 = auxiliar.getSiguiente();
                        if(numero == auxiliar.getSiguiente().getSalon().getNumero()){
                            System.out.println("Se ha eliminado correctamente el salon con el numero: " + 
                            auxiliar.getSalon().getNumero() + ", de la lista.");
                            auxiliar = null;
                            auxiliar1.setSiguiente(auxiliar);
                            return;
                        }
                        auxiliar = auxiliar.getSiguiente();
                    }
                    tamano--;
    //                auxiliar.setSiguiente(null);
                }
                System.out.println("El salon con numero: " + numero + ", no existe.");
            }   
        }
    }
    
    public void mostrar(){
        if(esVacia()){
            System.out.println("Lista simple ordenada vacia.");
        }else{
            NodoSO_S auxiliar = inicio;
            System.out.println("Se muestran los salones en la lista:");
            while(auxiliar != null){
                System.out.print("Numero: " + auxiliar.getSalon().getNumero() + " -> ");
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.println("");
        }
    }
    
    public void modificar(int numero, String nuevo_nombre_edificio, int nueva_capacidad){
        if(buscar(numero)){
//            buscarNodo(numero).getSalon().setNombre_edificio(nuevo_nombre_edificio);
            buscarNodo(numero).getSalon().setCapacidad(nueva_capacidad);
            System.out.println("Se ha modificado el salon con numero: " + numero + ", por: "
            + "\ncapacidad: "+ nueva_capacidad + ".");
        }else{
            System.out.println("No existe el salon con numero: " + numero + ".");
        }
    }
    
    public boolean buscar(int numero){
        boolean encontrado = false;
         if(esVacia()){
            System.out.println("Lista simple ordenada vacia.");
        }else{
            NodoSO_S auxiliar = inicio;
            while(auxiliar != null){
                if(numero == auxiliar.getSalon().getNumero()){
                    System.out.println("Se ha encontrado el salon con numero: " + auxiliar.getSalon().getNumero() + ".");
                    encontrado = true;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se ha encontrado el salon con numero: " + numero + ".");
        return encontrado;
    }
    
    public NodoSO_S buscarNodo(int numero){
        NodoSO_S encontrado;
        if(esVacia()){
            System.out.println("Lista simple ordenada vacia.");
            return null;
        }else{
            NodoSO_S auxiliar = inicio;
            while(auxiliar != null){
                if(numero == auxiliar.getSalon().getNumero()){
                    System.out.println("Se ha encontrado el salon con numero: " + auxiliar.getSalon().getNumero() + ".");
                    encontrado = auxiliar;
                    return encontrado;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se ha encontrado el salon con numero: " + numero + ".");
        return null;
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
        System.out.println("Se muestra la grafica de los salones en la lista simple ordenada:");
        String nombre = "lista_simple_ordenada_salones";
        String dot_subgrafo_lista_simple_ordenada_salones =
             	"\n\tsubgraph cluster_lista_simple_ordenada_salones"
            + 	"\n\t{"
            +   "\n"
            +   "\n\t\tgraph[color = \"crimson:firebrick3\", fontcolor = \"white\", fontname = serif, style = filled, label = \"Salones\"];"
            + 	"\n\t\tnode[shape = house, style = filled, color = white, fillcolor = \"honeydew4:azure\", fontcolor = red3, peripheries = 2];"
            + 	"\n\t\tedge[color = \"teal:paleturquoise\"];"
            + 	"\n"
            + 	"\n"
                +   generarDot("salon_")
            +	"\n\t}";
        
        if(opcion.equals("grafo")){
            String dot_grafo_lista_simple_ordenada_salones =
            "digraph lista_simple_ordenada_salones"
            +   "\n{"
                +   dot_subgrafo_lista_simple_ordenada_salones    
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_lista_simple_ordenada_salones);
            Escritura.generarImagenDot(nombre);
            return "";
        }else if(opcion.equals("subgrafo")){
            return dot_subgrafo_lista_simple_ordenada_salones;
        }
        return "";
    }
    
    public String generarDot(String _id){
        String dot = "";
        if(!esVacia()){
            NodoSO_S auxiliar_contenido = inicio;
            while(auxiliar_contenido != null){
                // -------------------  Contendio   -------------------
                // Actual
                dot += auxiliar_contenido.getContenido(_id);
                auxiliar_contenido = auxiliar_contenido.getSiguiente();
            }
//            dot += "\n\t\t{ "
//            + "\n\t\trank = same";
            
            NodoSO_S auxiliar_enlaces = inicio;
            while(auxiliar_enlaces.getSiguiente() != null) {
                // -------------------  Enlaces   	-------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getSalon().getNumero() + "->" 
                    + _id + auxiliar_enlaces.getSiguiente().getSalon().getNumero();
            	auxiliar_enlaces = auxiliar_enlaces.getSiguiente();
            }
            
//            dot += 	"\n\t\t}"
//                + 	"\n";
        }
        return dot;
    }
    
}