/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples.ordenada;

import estructuras.listas.simples.ordenada.*;
import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ListaSO_C {
    private NodoSO_C inicio;
    private int tamano;

    public ListaSO_C() {
        this.inicio = null;
        this.tamano = 0;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public NodoSO_C getInicio() {
        return inicio;
    }

    public int getTamano() {
        return tamano;
    }
    
    public void insertar(NodoSO_C nuevo){
        if(buscar(nuevo.getCurso().getCodigo())){
            System.out.println("El curso con codigo: " + nuevo.getCurso().getCodigo() + ", ya existe en la lista.");
        }else{
            if(esVacia()){
                inicio = nuevo;
                System.out.println("Lista vacia, se inserto correctamente el curso con codigo: " + nuevo.getCurso().getCodigo() + ", a la lista.");
            }else{
                //Al inicio
                if(nuevo.getCurso().getCodigo() < inicio.getCurso().getCodigo()){
                    nuevo.setSiguiente(inicio);
                    inicio = nuevo;
                    System.out.println("Se inserto correctamente el curso con codigo: "
                            + nuevo.getCurso().getCodigo() + ", al inicio.");
                }else{
                    NodoSO_C auxiliar = inicio;

                    while(auxiliar.getSiguiente() != null){
                        NodoSO_C auxiliar2 = auxiliar.getSiguiente();
                        if(nuevo.getCurso().getCodigo() < auxiliar2.getCurso().getCodigo()){
                            nuevo.setSiguiente(auxiliar2);
                            auxiliar.setSiguiente(nuevo);
                            System.out.println("Se inserto correctamente el curso con codigo: " 
                                    + nuevo.getCurso().getCodigo() + ", al medio.");
                            return;
                        }
                        auxiliar = auxiliar.getSiguiente();
                    }
                    auxiliar.setSiguiente(nuevo);
                    System.out.println("Se inserto correctamente el curso con codigo: " 
                            + nuevo.getCurso().getCodigo() + ", al final.");
                }
            }
            tamano++;
        }
    }
    
    // Arreglar eliminación
    public boolean eliminar(int codigo){
        if(!buscar(codigo)){
            System.out.println("El curso con codigo: " + codigo + ", no existe en la lista.");
            return false;
        }else{
            if(esVacia()){
                System.out.println("Lista vacia, nada que eliminar.");
                return false;
            }else{
                if(codigo == inicio.getCurso().getCodigo()){
                    System.out.println("Se ha eliminado correctamente el curso con el codigo: " + 
                            inicio.getCurso().getCodigo() + ", al inicio.");
                    NodoSO_C auxiliar = inicio.getSiguiente();
                    inicio.setSiguiente(null);
                    inicio = auxiliar;
                    tamano--;
                    return true;
                }else{
                    NodoSO_C auxiliar = inicio;
                    while(auxiliar != null){
                        NodoSO_C auxiliar1 = auxiliar.getSiguiente();
                        if(codigo == auxiliar.getSiguiente().getCurso().getCodigo()){
                            System.out.println("Se ha eliminado correctamente el curso con el codigo: " + 
                            auxiliar.getCurso().getCodigo() + ", de la lista.");
                            auxiliar = null;
                            auxiliar1.setSiguiente(auxiliar);
                            tamano--;
                            return true;
                        }
                        auxiliar = auxiliar.getSiguiente();
                    }
    //                auxiliar.setSiguiente(null);
                }
                System.out.println("El curso con codigo: " + codigo + ", no existe.");
            }   
        }
        return false;
    }
    
    public void mostrar(){
        if(esVacia()){
            System.out.println("Lista simple ordenada vacia.");
        }else{
            NodoSO_C auxiliar = inicio;
            System.out.println("Se muestran los cursos en la lista:");
            while(auxiliar != null){
                System.out.print("Codigo: " + auxiliar.getCurso().getCodigo() + " -> ");
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.println("");
        }
    }
    
    public boolean modificar(int codigo, String nuevo_nombre, int nuevo_semestre, int nuevos_creditos){
        if(buscar(codigo)){
//            buscarNodo(numero).getSalon().setNombre_edificio(nuevo_nombre_edificio);
            buscarNodo(codigo).getCurso().setNombre(nuevo_nombre);
            buscarNodo(codigo).getCurso().setSemestre(nuevo_semestre);
            buscarNodo(codigo).getCurso().setCreditos(nuevos_creditos);
            System.out.println("Se ha modificado el curso con codigo: " + codigo + ", por: "
            + "\nNombre: "+ nuevo_nombre + ", semestre: " + nuevo_semestre + ", creditos: " + nuevos_creditos + ".");
            return true;
        }else{
            System.out.println("No existe el curso con codigo: " + codigo + ".");
            return false;
        }
    }
    
    public boolean buscar(int codigo){
        boolean encontrado = false;
         if(esVacia()){
            System.out.println("Lista simple ordenada vacia.");
        }else{
            NodoSO_C auxiliar = inicio;
            while(auxiliar != null){
                if(codigo == auxiliar.getCurso().getCodigo()){
                    System.out.println("Se ha encontrado el curso con codigo: " + auxiliar.getCurso().getCodigo() + ".");
                    encontrado = true;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se ha encontrado el curso con codigo: " + codigo + ".");
        return encontrado;
    }
    
    public NodoSO_C buscarNodo(int codigo){
        NodoSO_C encontrado;
        if(esVacia()){
            System.out.println("Lista simple ordenada vacia.");
            return null;
        }else{
            NodoSO_C auxiliar = inicio;
            while(auxiliar != null){
                if(codigo == auxiliar.getCurso().getCodigo()){
                    System.out.println("Se ha encontrado el curso con codigo: " + auxiliar.getCurso().getCodigo() + ".");
                    encontrado = auxiliar;
                    return encontrado;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se ha encontrado el curso con codigo: " + codigo + ".");
        return null;
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
        System.out.println("Se muestra la grafica de los cursos en la lista simple ordenada:");
        String nombre = "lista_simple_ordenada_cursos";
        String dot_subgrafo_lista_simple_ordenada_cursos =
             	"\n\tsubgraph cluster_lista_simple_ordenada_cursos"
            + 	"\n\t{"
            +   "\n"
            +   "\n\t\tgraph[color = \"indigo:hotpink2\", fontcolor = \"white\", fontname = serif, style = filled, label = \"Cursos\"];"
            + 	"\n\t\tnode[shape = tripleoctagon, style = filled, color = white, fillcolor = black, fontcolor = white, peripheries = 2];"
            + 	"\n\t\tedge[color = \"purple:grey\"];"
            + 	"\n"
            + 	"\n"
                +   generarDot("curso_")
            +	"\n\t}";
        
        if(opcion.equals("grafo")){
            String dot_grafo_lista_simple_ordenada_cursos =
            "digraph lista_simple_ordenada_cursos"
            +   "\n{"
                +   dot_subgrafo_lista_simple_ordenada_cursos    
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_lista_simple_ordenada_cursos);
            Escritura.generarImagenDot(nombre);
            return "";
        }else if(opcion.equals("subgrafo")){
            return dot_subgrafo_lista_simple_ordenada_cursos;
        }
        return "";
    }
    
    public String generarDot(String _id){
        String dot = "";
        if(!esVacia()){
            NodoSO_C auxiliar_contenido = inicio;
            while(auxiliar_contenido != null){
                // -------------------  Contendio   -------------------
                // Actual
                dot += auxiliar_contenido.getContenido(_id);
                auxiliar_contenido = auxiliar_contenido.getSiguiente();
            }
//            dot += "\n\t\t{ "
//            + "\n\t\trank = same";
            
            NodoSO_C auxiliar_enlaces = inicio;
            while(auxiliar_enlaces.getSiguiente() != null) {
                // -------------------  Enlaces   	-------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getCurso().getCodigo() + "->" 
                    + _id + auxiliar_enlaces.getSiguiente().getCurso().getCodigo();
            	auxiliar_enlaces = auxiliar_enlaces.getSiguiente();
            }
            
//            dot += 	"\n\t\t}"
//                + 	"\n";
        }
        return dot;
    }
    
}