/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author g
 */
public class Asignacion {
    private int carnet;
    private int codigo_horario;
    private int zona;
    private int nota_final;

    public Asignacion(int carnet, int codigo_horario, int zona, int nota_final) {
        this.carnet = carnet;
        this.codigo_horario = codigo_horario;
        this.zona = zona;
        this.nota_final = nota_final;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public int getCodigo_horario() {
        return codigo_horario;
    }

    public void setCodigo_horario(int codigo_horario) {
        this.codigo_horario = codigo_horario;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }
    
}
