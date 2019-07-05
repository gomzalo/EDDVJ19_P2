/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.dobles.circular;

import archivos.Escritura;
import java.io.IOException;

/**
 *
 * @author g
 */
public class ListaDC {
    private NodoDC inicio;
    private NodoDC fin;
    private int tamano;

    public ListaDC() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }

    public NodoDC getInicio() {
        return inicio;
    }

    public NodoDC getFin() {
        return fin;
    }

    public int getTamano() {
        return tamano;
    }
        
    public void insertar(NodoDC nuevo){
        if(buscar(nuevo.getEdificio().getNombre())){
            System.out.println("Ya se ha ingresado un edificio con el nombre: " + nuevo.getEdificio().getNombre() + ".");
        }else{
            if(esVacia()){
                inicio = fin = nuevo;
                nuevo.setSiguiente(nuevo);
                nuevo.setAnterior(nuevo);
                System.out.println("Lista vacia, se inserto correctamente el nombre: " + nuevo.getEdificio().getNombre());
            }else if(nuevo.getEdificio().getNombre().compareTo(inicio.getEdificio().getNombre()) < 0){
                insertarAlInicio(nuevo);
            }else if(nuevo.getEdificio().getNombre().compareTo(fin.getEdificio().getNombre()) > 0){
                insertarAlFinal(nuevo);
            }else{
                insertarAlMedio(nuevo);
            }
            tamano++;
        }
    }
    
    protected void insertarAlInicio(NodoDC nuevo){
        nuevo.setAnterior(fin);
        fin.setSiguiente(nuevo);
        inicio.setAnterior(nuevo);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        System.out.println("Se inserto correctamente el nombre: " + nuevo.getEdificio().getNombre() + ", al inicio.");
    }
    
    protected void insertarAlFinal(NodoDC nuevo){
        fin.setSiguiente(nuevo);
        nuevo.setAnterior(fin);
        nuevo.setSiguiente(inicio);
        inicio.setAnterior(nuevo);
        fin = nuevo;
        System.out.println("Se inserto correctamente el nombre: " + nuevo.getEdificio().getNombre() + ", al final.");
    }
    
    protected void insertarAlMedio(NodoDC nuevo){
        boolean ins = false;
        NodoDC temporal = inicio;
        NodoDC auxiliar = inicio.getSiguiente();
        while(auxiliar != null){
//            if(nuevo.getId() >= temporal.getId() && nuevo.getId() <= auxiliar.getId()){
            if(nuevo.getEdificio().getNombre().compareTo(temporal.getEdificio().getNombre()) > 0 
            && nuevo.getEdificio().getNombre().compareTo(auxiliar.getEdificio().getNombre()) < 0){
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
        System.out.println("Se inserto correctamente el nombre: " + nuevo.getEdificio().getNombre() + ", al medio.");
    }
    
    public boolean buscar(String nombre){
        if(esVacia()){
            System.out.println("Lista vacia.");
            return false;
        } else {
            if(nombre.equals(inicio.getEdificio().getNombre())){
                System.out.println( "Se ha encontrado el nodo: "
                                +   "\nnombre: " + inicio.getEdificio().getNombre());
                return true;
            }
            NodoDC auxiliar = inicio.getSiguiente();
            while(auxiliar != inicio){
                if(nombre.equals(auxiliar.getEdificio().getNombre())){
                    System.out.println( "Se ha encontrado el nodo: "
                                +   "\nnombre: " + auxiliar.getEdificio().getNombre());
                    return true;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        return false;
    }
    
    public NodoDC buscarNodo(String nombre){
        NodoDC encontrado;
        if(esVacia()){
            System.out.println("Lista vacia.");
            return null;
        } else {
            if(nombre.equals(inicio.getEdificio().getNombre())){
                System.out.println( "Se ha encontrado el nodo: "
                                +   "\nID: " + inicio.getEdificio().getNombre());
                encontrado = inicio;
                return encontrado;
            }
            NodoDC auxiliar = inicio.getSiguiente();
            while(auxiliar != inicio){
                if(nombre.equals(auxiliar.getEdificio().getNombre())){
                    System.out.println( "Se ha encontrado el nodo: "
                                +   "\nID: " + auxiliar.getEdificio().getNombre());
                    encontrado = auxiliar;
                    return encontrado;
                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        return null;
    }
    
    public void eliminar(String nombre){
        if(!buscar(nombre)){
            System.out.println("No existe este ID en la lista.");
        }else{
            // Solo hay un elemento
//            if(id == inicio.getId() && id == fin.getId() && inicio == fin){
            if(nombre.equals(inicio.getEdificio().getNombre()) 
            && nombre.equals(fin.getEdificio().getNombre()) && inicio == fin){
                 System.out.println( "Se ha eliminado el nodo: "
                                +   "\nnombre: " + inicio.getEdificio().getNombre()
                                +   ", la lista ha quedado vacia.");
                fin = inicio = null;
                tamano = 0;
                return;
            // Eliminacion al inicio
            }else if(nombre.equals(inicio.getEdificio().getNombre())){
                System.out.println( "Se ha eliminado el nodo: "
                                +   "\nnombre: " + inicio.getEdificio().getNombre()
                                +   ", al inicio.");
                inicio = inicio.getSiguiente();
                inicio.setAnterior(fin);
                fin.setSiguiente(inicio);
                tamano--;
            // Eliminacion al final
//            }else if(id == fin.getId()){
            }else if(nombre.equals(fin.getEdificio().getNombre())){
                System.out.println( "Se ha eliminado el nodo: "
                                +   "\nnombre: " + inicio.getEdificio().getNombre()
                                +   ", al final.");
                fin = fin.getAnterior();
                fin.setSiguiente(inicio);
                inicio.setAnterior(fin);
                tamano--;
            // Eliminacion al medio
            }else{
                NodoDC auxiliar = inicio.getSiguiente();
                while(auxiliar != inicio){
//                    if(id == auxiliar.getId()){
                    if(nombre.equals(auxiliar.getEdificio().getNombre())){
                        System.out.println( "Se ha eliminado el nodo: "
                               +   "\nnombre: " + inicio.getEdificio().getNombre()
                               +   ", al medio.");
                        auxiliar.getSiguiente().setAnterior(auxiliar.getAnterior());
                        auxiliar.getAnterior().setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(null);
                        auxiliar.setAnterior(null);
                        return;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
                tamano--;
            }
        }
    }
    
    public void mostrar(){
        if(esVacia()){
            System.out.println("Lista vacia.");
        } else {
            System.out.println("Se muestra los elementos en la lista:");
            System.out.print("Nombre: " + inicio.getEdificio().getNombre() + "<->");
            NodoDC auxiliar = inicio.getSiguiente();
            while(auxiliar.getSiguiente() != inicio){
                System.out.print( "Nombre: " + auxiliar.getEdificio().getNombre()
                                +   "<->");
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.print( "Nombre: " + auxiliar.getEdificio().getNombre()
                        +   "\n");
        }
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
        System.out.println("Se muestra la grafica de los elementos en la lista doble circular:");
        String nombre = "lista_doble_circular";
        String dot_subgrafo_lista_doble_circular =
        "\n\tsubgraph cluster_lista_doble_circular"
        +   "\n\t{"
        +   "\n"
        +       "\n\t\tgraph[color = \"cornflowerblue:darkslateblue\", fontcolor = \"black\", fontname = serif, style = filled, label = \"Edificios\", rankdir = \"LR\"];"
        +       "\n\t\tnode[shape = tripleoctagon, style = filled, color = cyan1, fillcolor = ghostwhite, fontcolor = black, peripheries = 2];"
        + 	"\n\t\tedge[color = \"blue:grey100:greenyellow\"];"
        + 	"\n"
        + 	"\n"
            +   generarDot("edificio_")
        +   "\n\t}";
        
        if(opcion.equals("grafo")){
            String dot_grafo_lista_doble_circular =
            "digraph lista_doble_circular"
            +   "\n{"
                +   dot_subgrafo_lista_doble_circular    
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_lista_doble_circular);
            Escritura.generarImagenDot(nombre);
            return "";
        }else if(opcion.equals("subgrafo")){
            return dot_subgrafo_lista_doble_circular;
        }
        return "";
    }
    
    public String generarDot(String _id) throws IOException{
        String dot = "";
        if(!esVacia()){
            NodoDC auxiliar_contenido = inicio;
            while(auxiliar_contenido.getSiguiente() != inicio){
                // -------------------  Contendio   -------------------
                // Actual
                dot += auxiliar_contenido.getContenido(_id);
                auxiliar_contenido = auxiliar_contenido.getSiguiente();
            }
            dot += auxiliar_contenido.getContenido(_id);
            
//            dot += "\n\t\t{ 
//            + "\n\t\trank = same ";

            NodoDC auxiliar_enlaces = inicio;
            while(auxiliar_enlaces.getSiguiente() != inicio) {
                // -------------------  Enlaces siguientes  -------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getEdificio().getNombre().replaceAll("\\s+", "") + "->" 
                    + _id + auxiliar_enlaces.getSiguiente().getEdificio().getNombre().replaceAll("\\s+", "");
                // -------------------  Enlaces anteriores  -------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getSiguiente().getEdificio().getNombre().replaceAll("\\s+", "") + "->" 
                    + _id + auxiliar_enlaces.getEdificio().getNombre().replaceAll("\\s+", "");  
            	auxiliar_enlaces = auxiliar_enlaces.getSiguiente();
            }
            
//            dot +=  "\n\t\t}"
//                +   "\n";
            dot +=  "\n";
            // -------------------  Enlaces al final  	-------------------
            dot += "\n\t\t" + _id + inicio.getEdificio().getNombre().replaceAll("\\s+", "") 
            + "->" + _id + inicio.getAnterior().getEdificio().getNombre().replaceAll("\\s+", "");
            dot += "\n\t\t" + _id + fin.getEdificio().getNombre().replaceAll("\\s+", "") 
            + "->" + _id + fin.getSiguiente().getEdificio().getNombre().replaceAll("\\s+", "");
        }
        return dot;
    }
}
