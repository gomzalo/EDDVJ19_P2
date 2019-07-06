/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listas.simples.ordenada;

import estructuras.listas.simples.ordenada.*;
import pojos.Curso;
import pojos.Salon;

/**
 *
 * @author g
 */
public class NodoSO_C {
    private Curso curso;
    private NodoSO_C siguiente;

    public NodoSO_C(Curso curso) {
        this.curso = curso;
        this.siguiente = null;
    }

    public NodoSO_C getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSO_C siguiente) {
        this.siguiente = siguiente;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public String getContenido(String _id){
        String contenido = "";
        if(this.getCurso() != null){
            contenido +=
                "\t\t" + _id + this.getCurso().getCodigo()
            +   "[label = "
                +   "<"
                +   " Codigo: " + this.getCurso().getCodigo()
                +   " <BR /> "
                    +   "<FONT POINT-SIZE = \"9\">"
                    +   " <BR /> "
                    +   "Nombre: " + this.getCurso().getNombre()
                    +   " <BR /> "
                    +   "Semestre: " + this.getCurso().getSemestre()
                    +   " <BR /> "
                    +   "Creditos: " + this.getCurso().getCreditos()
                    +   " </FONT>"
                +   ">"
            +   "]"
            +   "\n";
        }
        return contenido;
    }
    
}