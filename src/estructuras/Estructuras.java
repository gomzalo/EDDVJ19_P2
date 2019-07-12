/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import archivos.Escritura;
import estructuras.arboles.avl.ArbolAVL;
import estructuras.arboles.b.ArbolB;
import estructuras.arboles.b.PaginaB;
import estructuras.arboles.b.subestructuras.cola.ColaB;
import estructuras.listas.dobles.circular.ListaDC_E;
import estructuras.listas.dobles.ordenada.ListaDO_U;
import estructuras.listas.simples.ordenada.ListaSO_C;
import estructuras.listas.simples.ordenada.NodoSO_C;
import estructuras.tabla.hash.TablaHash;
import java.io.IOException;
import pojos.Curso;
import pojos.Horario;

/**
 *
 * @author g
 */
public class Estructuras {
    // __________________________________	E	S	T	R	U	C	T	U	R	A	S	__________________________________
    public static ListaDO_U ldo_usuarios = new ListaDO_U();
    public static ListaDC_E ldc_edificios = new ListaDC_E();
    public static ListaSO_C lso_cursos = new ListaSO_C();
    public static ArbolAVL avl_catedraticos = new ArbolAVL();
    public static TablaHash th_estudiantes = new TablaHash();
    public static ArbolB<Horario> b_horarios = new ArbolB<Horario>(5);
    
    public static void graficar(String grafica, int id) throws IOException, InterruptedException{
        
        
        String dot = "";
        switch(grafica){
            case "todo":
                dot = generarDotTodo();
                break;
            case "cursos":
                dot = generarDotCursos(id);
                break;
            case "notas":
                dot = generarDotNotas(id);
                break;
        }
        
        System.out.println("Se muestra la grafica de los catedraticos en el arbol AVL:");
        String nombre = grafica;
        String dot_subgrafo_todo =
            "\n\tsubgraph cluster_" + grafica
        +   "\n\t{"
        +   "\n"
            +   "\n\t\tgraph[color = \"orange:black\", fontcolor = \"white\", fontname = serif, style = filled, label = \"" + grafica + "\"];"
            +   "\n\t\tnode[shape = egg, style = filled, color = \"white\", fillcolor = yellow, fontcolor = black, peripheries = 2];"
            +   "\n\t\tedge[color = \"blue:yellow:red\"];"
            +   "\n"
            + 	"\n"
            +   dot
        +   "\n\t}";
        
        String dot_grafo_todo =   
            "digraph " + grafica
            +   "\n{"
                +   dot_subgrafo_todo
            +   "\n}";
        Escritura.escribirArchivoDot(nombre, dot_grafo_todo);
        Escritura.generarImagenDot(nombre);
    }
    
    private static String generarDotTodo() throws IOException, InterruptedException{
        //Estudiantes, Usuarios, Catedraticos, Edificios, Cursos, Horarios
        String dot = "";
        if(!th_estudiantes.esVacia()){
            dot += th_estudiantes.graficar("subgrafo");
        }
        if(!ldo_usuarios.esVacia()){
            dot += ldo_usuarios.graficar("subgrafo");
        }
        if(!avl_catedraticos.esVacio()){
            dot += avl_catedraticos.graficar("subgrafo");
        }
        if(!ldc_edificios.esVacia()){
            dot += ldc_edificios.graficar("subgrafo");
        }
        if(!lso_cursos.esVacia()){
            dot += lso_cursos.graficar("subgrafo");
        }
        if(!b_horarios.esVacio()){
            dot += b_horarios.graficar("subgrafo");
        }
        return dot;
    }
    
    private static String generarDotCursos(int id) throws IOException, InterruptedException{
        String dot = "";
        if(!th_estudiantes.esVacia()){
            dot += th_estudiantes.buscar(id).getContenido("estudiante_");
        }
        if(!b_horarios.esVacio()){
            if(b_horarios.getRaiz() != null){
                lista_cursos = new ListaSO_C();
                getCursos(b_horarios.getRaiz(), id);
            }
            if(!lista_cursos.esVacia()){
                dot += lista_cursos.graficar("subgrafo");
            }
        }
        return dot;
    }
    
    static ListaSO_C lista_cursos;
    private static String generarDotNotas(int id) throws IOException, InterruptedException{
        String dot = "";
        if(!th_estudiantes.esVacia()){
            dot += th_estudiantes.buscar(id).getContenido("estudiante_");
        }
        if(!b_horarios.esVacio()){
            if(b_horarios.getRaiz() != null){
                lista_cursos = new ListaSO_C();
                getCursos(b_horarios.getRaiz(), id);
            }
            if(!lista_cursos.esVacia()){
                dot += lista_cursos.graficar("subgrafo");
            }
        }
        return dot;
    }
    
    private static void getCursos(PaginaB<Horario> actual, int id){
        if(actual != null){
            if(actual.getHijos() != null){
                for (int i = 0; i < actual.getLlenura(); i++) {
                    if(actual.getHijos()[i] != null){
                        getCursos(actual.getHijos()[i], id);
                        if(actual.getLlaves()[i].getAsignaciones() != null){
                            if(actual.getLlaves()[i].getAsignaciones().buscar(id)){
                                lista_cursos.insertar(new NodoSO_C(
                                new Curso(actual.getLlaves()[i].getHorario().getCodigo_curso(), "", -1, -1)));
                                System.out.println(actual.getLlaves()[i].getHorario().getCodigo());
                            }
                        }
                    }
            }
            getCursos(actual.getHijos()[actual.getLlenura()], id);
            }else{
                for (int i = 0; i < actual.getLlenura(); i++) {
                    if(actual.getLlaves()[i] != null){
//                        System.out.println(actual.getLlaves()[i].getHorario().getCodigo());
                        if(actual.getLlaves()[i].getAsignaciones() != null){
                            if(actual.getLlaves()[i].getAsignaciones().buscar(id)){
                                lista_cursos.insertar(new NodoSO_C(
                                new Curso(actual.getLlaves()[i].getHorario().getCodigo_curso(), "", -1, -1)));
                                System.out.println(actual.getLlaves()[i].getHorario().getCodigo());
                            }
                        }
                        
                    }
                }
                System.out.println("\n");
            }
            
        }
    }
}
