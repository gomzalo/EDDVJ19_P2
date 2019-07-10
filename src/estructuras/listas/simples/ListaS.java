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
public class ListaS {
    private NodoS inicio;
    private int tamano;

    public ListaS() {
        inicio = null;
        tamano = 0;
    }

    public NodoS getInicio() {
        return inicio;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamano(){
        return this.tamano;
    }
    
    public void insertar(NodoS nuevo){
        //Agregar al final
        if(buscar(nuevo.getAsignacion().getCarnet())){
            System.out.println("La asignacion para el carnet: " + nuevo.getAsignacion().getCarnet() + ", ya ha sido realizada.");
        }else{
            if(esVacia()){
                // Lista vacia, por lo que el inicio sera igual al nodo nuevo.
                inicio = nuevo;
                System.out.println("Lista vacia, se inserto correctamente la asignacion del carnet: " + nuevo.getAsignacion().getCarnet()+ ", a la lista.");
            }else{
                // Se posiciona al inicio el nodo auxiliar.
                NodoS auxiliar = inicio;
                while(auxiliar.getSiguiente() != null){
                    auxiliar = auxiliar.getSiguiente();
                }
                // Una vez alcanzado el final, se agrega el nuevo nodo.
                auxiliar.setSiguiente(nuevo);
                System.out.println("Se inserto correctamente la asignacion del carnet: " + nuevo.getAsignacion().getCarnet()+ ", a la lista.");
            }
            tamano++;
        }
        
    }
    
    public void modificar(int carnet, int nuevo_codigo_curso, int nueva_zona, int nuevo_final){
        if(buscar(carnet)){
//            buscarNodo(numero).getSalon().setNombre_edificio(nuevo_nombre_edificio);
            buscarNodo(carnet).getAsignacion().setCodigo_curso(nuevo_codigo_curso);
            buscarNodo(carnet).getAsignacion().setZona(nueva_zona);
            buscarNodo(carnet).getAsignacion().setNota_final(nuevo_final);
            System.out.println("Se ha modificado la asignacion del carnet: " + carnet + ", por: "
            + "\ncodigo curso: "+ nuevo_codigo_curso + ", zona: " + nueva_zona + ", final: " + nuevo_final + ".");
        }else{
            System.out.println("No existe el salon con numero: " + carnet + ".");
        }
    }
    
    public NodoS buscarNodo(int carnet){
//        NodoS encontrado;
        if(!esVacia()){
            NodoS auxiliar = inicio;
            while(auxiliar != null){
                if(carnet == auxiliar.getAsignacion().getCarnet()){
//                    encontrado = auxiliar;
                    System.out.println("Se encontro la asignacion del carnet: " + carnet + ".");
                    return auxiliar;
                }
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.println("No se encontro la asignacion del carnet: " + carnet + ".");
        }else{
            System.out.println("Lista simple vacia.");
        }
        
        return null;
    }
    
    public boolean buscar(int carnet){
        boolean encontrado = false;
        if(!esVacia()){
            NodoS auxiliar = inicio;
            while(auxiliar != null && encontrado != true){
                if(carnet == auxiliar.getAsignacion().getCarnet()){
                    System.out.println("Se encontro la asignacion del carnet: " + carnet + ".");
                    encontrado = true;
                }else{
                    auxiliar = auxiliar.getSiguiente();
                }
            }
            System.out.println("No se encontro la asignacion del carnet: " + carnet + ".");
        }else{
            System.out.println("Lista simple vacia.");
        }
        return encontrado;
    }
    
    public void eliminar(int carnet){
        if(!buscar(carnet)){
            System.out.println("No se encontro la asignacion del carnet: " + carnet + ".");
        }else{
            if(inicio.getAsignacion().getCarnet() == carnet){
                System.out.println("Se ha eliminado correctamente la asignacion del carnet: " + 
                            inicio.getAsignacion().getCarnet() + ", al inicio.");
                inicio = inicio.getSiguiente();
            }else{
                NodoS auxiliar = inicio;
                while(auxiliar.getSiguiente() != null){
                    if(auxiliar.getSiguiente().getAsignacion().getCarnet() == carnet){
                        System.out.println("Se ha eliminado correctamente la asignacion del carnet: " + 
                        inicio.getAsignacion().getCarnet() + ", de la lista.");
                        auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
                        return;
                    }
                    auxiliar = auxiliar.getSiguiente();
                }
            }
            tamano--;
        }
    }
    
    public void mostrar(){
        if(esVacia()){
            System.out.println("Lista simple vacia.");
        }else{
            NodoS auxiliar = inicio;
            System.out.println("Se muestran las asignaciones en la lista:");
            while(auxiliar != null){
                System.out.print("Carnet: " + auxiliar.getAsignacion().getCarnet() + " -> ");
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.println("");
        }
    }
    
    public String graficar(String opcion, String id_horario) throws IOException, InterruptedException{
        System.out.println("Se muestra la grafica de las asignaciones en la lista simple:");
        String nombre = "lista_simple_asignaciones";
        String dot_subgrafo_lista_simple_asignaciones =
        "\n\tsubgraph cluster_lista_simple_asignaciones_" + id_horario
        +   "\n\t{"
        +   "\n"
        +   "\n\t\tgraph[color = \"white:aliceblue\", fontcolor = \"black\", style = filled, label = \"Asignaciones\"];"
        +   "\n\t\tnode[shape = component, style = filled, color = lightsalmon4, fillcolor = \"invis:palegreen1\", fontcolor = black, peripheries = 2];"
        +   "\n\t\tedge[color = \"olivedrab1:grey:navyblue\"];"
        +   "\n"
        +   "\n"
            +   generarDot(id_horario + "_asignacion_")
        +   "\n\t}";
        
        if(opcion.equals("grafo")){
            String dot_grafo_lista_simple_asignaciones =
            "digraph lista_simple_asignaciones_" + id_horario
            +   "\n{"
                +   dot_subgrafo_lista_simple_asignaciones    
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_lista_simple_asignaciones);
            Escritura.generarImagenDot(nombre);
            return "";
        }else if(opcion.equals("subgrafo")){
            return dot_subgrafo_lista_simple_asignaciones;
        }
        return "";
    }
    
    public String generarDot(String _id){
        String dot = "";
        if(!esVacia()){
            NodoS auxiliar_contenido = inicio;
            while(auxiliar_contenido != null){
                // -------------------  Contendio   -------------------
                // Actual
                dot += auxiliar_contenido.getContenido(_id);
                auxiliar_contenido = auxiliar_contenido.getSiguiente();
            }
            
            NodoS auxiliar_enlaces = inicio;
            while(auxiliar_enlaces.getSiguiente() != null) {
                // -------------------  Enlaces   	-------------------
            	dot += "\n\t\t" + _id + auxiliar_enlaces.getAsignacion().getCarnet()+ "->" 
                    + _id + auxiliar_enlaces.getSiguiente().getAsignacion().getCarnet();
            	auxiliar_enlaces = auxiliar_enlaces.getSiguiente();
            }
        }
        return dot;
    }
    
}
