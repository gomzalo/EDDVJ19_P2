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
public class Salon {
    private int numero;
    private String nombre_edificio;
    private int capacidad;
    private int estudiantes_asignados;

    public Salon(int numero, String nombre_edificio, int capacidad) {
        this.numero = numero;
        this.nombre_edificio = nombre_edificio;
        this.capacidad = capacidad;
        this.estudiantes_asignados = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre_edificio() {
        return nombre_edificio;
    }

    public void setNombre_edificio(String nombre_edificio) {
        this.nombre_edificio = nombre_edificio;
    }

    public int getEstudiantes_asignados() {
        return estudiantes_asignados;
    }

    public void setEstudiantes_asignados(int estudiantes_asignados) {
        this.estudiantes_asignados = estudiantes_asignados;
    }
    
}
