/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.b;

/**
 *
 * @author G
 */
public class NodoB<Horario> {
    private Horario horario;
    private String llave;
    
     public NodoB(Horario horario, String llave) {
        this.horario = horario;
        this.llave = llave;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
}
