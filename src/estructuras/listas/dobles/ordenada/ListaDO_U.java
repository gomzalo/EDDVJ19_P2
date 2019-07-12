/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.dobles.ordenada;

import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ListaDO_U {
    private NodoDO_U inicio;
    private int tamano;

    public ListaDO_U() {
        this.inicio = null;
        this.tamano = 0;
    }

    public boolean esVacia(){
        return inicio == null;
    }
    
    public NodoDO_U getInicio() {
        return inicio;
    }

    public int getTamano() {
        return tamano;
    }
    
    public void insertar(NodoDO_U nuevo){
        if(buscar(nuevo.getUsuario().getId())){
            System.out.println("Ya existe un usuario con el ID: " + nuevo.getUsuario().getId() +  ".");
        }else{
            if(esVacia()){
                inicio = nuevo;
                System.out.println("Lista vacia, se inserto correctamente el usuario con ID: " + nuevo.getUsuario().getId() + ".");
            }else if(nuevo.getUsuario().getId() < inicio.getUsuario().getId()){
                insertarAlInicio(nuevo);
            }else{
                insertarAlMedio(nuevo);
            }
            tamano++;
        }
    }
    
    public void insertarAlInicio(NodoDO_U nuevo){
        nuevo.setSiguiente(inicio);
        inicio.setAnterior(nuevo);
        inicio = nuevo;
        System.out.println("Se inserto correctamente el usuario con ID: " + nuevo.getUsuario().getId() + ", al inicio.");
    }
    
    public void insertarAlMedio(NodoDO_U nuevo){
        boolean ins = false;
        NodoDO_U temporal = inicio;
        NodoDO_U auxiliar = inicio.getSiguiente();
        while(auxiliar != null){
            if(nuevo.getUsuario().getId() >= temporal.getUsuario().getId() && nuevo.getUsuario().getId() <= auxiliar.getUsuario().getId()){
                temporal.setSiguiente(nuevo);
                nuevo.setAnterior(temporal);
                nuevo.setSiguiente(auxiliar);
                auxiliar.setAnterior(nuevo);
                ins = true;
                break;
            } else {
                temporal = auxiliar;
                auxiliar = auxiliar.getSiguiente();
            }
        }
        if(!ins){
            temporal.setSiguiente(nuevo);
            nuevo.setAnterior(temporal);
        }
        System.out.println("Se inserto correctamente el usuario con ID: " + nuevo.getUsuario().getId() + ", al medio.");
    }
    
    public boolean modificar(int id, String nuevo_nombre, String nueva_contrasena){
        if(buscar(id)){
            buscarNodo(id).getUsuario().setNombre(nuevo_nombre);
            buscarNodo(id).getUsuario().setContrasena(nueva_contrasena);
            System.out.println("Se ha modificado el usuario con ID: " + id + ", por: "
                    + "\nnombre: " + nuevo_nombre + ", contrasena: "+ nueva_contrasena + ".");
            return true;
        }else{
            System.out.println("No existe un usuario con ID: " + id + ".");
            return false;
        }
    }
    
    public boolean buscar(int id){
        if(esVacia()){
            System.out.println("Lista doble ordenada vacia.");
            return false;
        } else {
            if(id == inicio.getUsuario().getId()){
                System.out.println("Se ha encontrado el usuario con ID: " + inicio.getUsuario().getId() + ".");
                return true;
            }
            NodoDO_U auxiliar = inicio.getSiguiente();
            while(auxiliar != null){
                if(id == auxiliar.getUsuario().getId()){
                    System.out.println("Se ha encontrado el usuario con ID: " + auxiliar.getUsuario().getId() + ".");
                    return true;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se ha encontrado el usuario con ID: " + id + ".");
        return false;
    }
    
    public NodoDO_U buscarNodo(int id){
        NodoDO_U encontrado;
        if(esVacia()){
            System.out.println("Lista doble ordenada vacia.");
            return null;
        } else {
            if(id == inicio.getUsuario().getId()){
                System.out.println("Se ha encontrado el usuario con ID: " + inicio.getUsuario().getId() + ".");
                encontrado = inicio;
                return encontrado;
            }
            NodoDO_U auxiliar = inicio.getSiguiente();
            while(auxiliar != null){
                if(id == auxiliar.getUsuario().getId()){
                    System.out.println("Se ha encontrado el usuario con ID: " + auxiliar.getUsuario().getId() + ".");
                    encontrado = auxiliar;
                    return encontrado;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        System.out.println("No se ha encontrado el usuario con ID: " + id + ".");
        return null;
    }
    
    public void mostrar(){
        if(esVacia()){
            System.out.println("Lista doble ordenada vacia.");
        } else {
            System.out.println("Se muestran los usuarios en la lista:");
            System.out.print("ID: " + inicio.getUsuario().getId() + " <-> ");
            NodoDO_U auxiliar = inicio;
            while(auxiliar != null){
                System.out.print("ID: " + auxiliar.getUsuario().getId()
                                + " <-> ");
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.print("\n");
        }
    }
    
    public boolean eliminar(int id){
        if(!buscar(id)){
            System.out.println("No existe el usuario con ID: " + id + ", en la lista.");
            return false;
        }else{
            // Solo hay un elemento
            if(id == inicio.getUsuario().getId() && inicio.getSiguiente() == null){

                 System.out.println("Se ha eliminado el usuario con ID: " + inicio.getUsuario().getId()
                                +   ", la lista ha quedado vacia.");
                inicio = null;
                tamano = 0;
                return true;
            // Eliminacion al inicio
            }else if(id == inicio.getUsuario().getId()){
                System.out.println("Se ha eliminado el usuario con ID: " + inicio.getUsuario().getId()
                                +   ", al inicio.");
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
                tamano--;
                return true;
            }else{
                NodoDO_U auxiliar = inicio.getSiguiente();
                while(auxiliar.getSiguiente() != null){
                    if(id == auxiliar.getUsuario().getId()){
                        System.out.println("Se ha eliminado el usuario con ID: " + auxiliar.getUsuario().getId()
                               +   ", al medio.");
                        auxiliar.getAnterior().setSiguiente(auxiliar.getSiguiente());
                        auxiliar.getSiguiente().setAnterior(auxiliar.getAnterior());
                        auxiliar.setSiguiente(null);
                        auxiliar.setAnterior(null);
                        return true;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
                if(id == auxiliar.getUsuario().getId()){
                    System.out.println( "Se ha eliminado el usuario con ID: " + auxiliar.getUsuario().getId()
                               +   ", al final.");
                    auxiliar.getAnterior().setSiguiente(null);
                    return true;
                }
                tamano--;
            }
        }
        return false;
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
        System.out.println("Se muestra la grafica de los usuarios en la lista doble ordenada:");
        String nombre = "lista_doble_ordenada_usuarios";
        String dot_subgrafo_lista_doble_ordenada =
        "\n\tsubgraph cluster_lista_doble_ordenada_usuarios"
        +   "\n\t{"
        +   "\n"
        +       "\n\t\tgraph[color = \"grey9:darkslategray\", fontcolor = \"aquamarine2\", fontname = serif, style = filled, label = \"Usuarios\"];"
        +       "\n\t\tnode[shape = circle, style = filled, color = hotpink, fillcolor = \"aquamarine1:gray\", fontcolor = black, peripheries = 2];"
        + 	"\n\t\tedge[color = \"blue:white:grey\"];"
        + 	"\n"
        + 	"\n"
            +   generarDot("usuario_")
        +   "\n\t}";
        
        if(opcion.equals("grafo")){
            String dot_grafo_lista_doble_ordenada =
            "digraph lista_doble_ordenada_usuarios"
            +   "\n{"
                +   dot_subgrafo_lista_doble_ordenada    
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_lista_doble_ordenada);
            Escritura.generarImagenDot(nombre);
            return "";
        }else if(opcion.equals("subgrafo")){
            return dot_subgrafo_lista_doble_ordenada;
        }
        return "";
    }
    
    public String generarDot(String _id) throws IOException{
        String dot = "";
        if(!esVacia()){
            NodoDO_U auxiliar_contenido = inicio;
            while(auxiliar_contenido.getSiguiente() != null){
                // -------------------  Contendio   -------------------
                // Actual
                dot += 	auxiliar_contenido.getContenido(_id);
                auxiliar_contenido = auxiliar_contenido.getSiguiente();
            }
            // Ultimo
            dot += auxiliar_contenido.getContenido(_id);
            
//            dot += "\n\t\t{"
//            + "\n\t\trank = same ";
            
            NodoDO_U auxiliar_enlaces = inicio;
            while(auxiliar_enlaces.getSiguiente() != null) {
                // -------------------  Enlaces siguientes  -------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getUsuario().getId() + "->" 
                    + _id + auxiliar_enlaces.getSiguiente().getUsuario().getId();                
                // -------------------  Enlaces anteriores  -------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getSiguiente().getUsuario().getId() + "->" 
                    + _id + auxiliar_enlaces.getUsuario().getId();
                auxiliar_enlaces = auxiliar_enlaces.getSiguiente();
            }
            
//            dot +=  "\n\t\t}"
//                +   "\n";
        }
        return dot;
    }
    
}
