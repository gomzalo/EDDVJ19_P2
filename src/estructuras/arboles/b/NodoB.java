/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.b;

import estructuras.listas.simples.ListaS;

/**
 *
 * @author G
 */
public class NodoB<Horario> {
    private Horario horario;
    private int llave;
    private ListaS asignaciones;
    
//     public NodoB(Horario horario, String llave) {
//        this.horario = horario;
//        this.llave = llave;
//    }
     
    public NodoB(Horario horario, ListaS asignaciones, int llave) {
        this.horario = horario;
        this.asignaciones = asignaciones;
        this.llave = llave;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ListaS getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(ListaS asignaciones) {
        this.asignaciones = asignaciones;
    }
    
}
