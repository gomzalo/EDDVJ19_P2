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
public class Estudiante {
    private int carnet;
    private String nombre;
    private String direccion;

    public Estudiante(int carnet, String nombre, String direccion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getContenido(String _id){
        String contenido = "";
            contenido +=
                "\t\t" + _id + this.getCarnet()
            +   "[label = "
                +   "<"
                +   " Carnet: " + this.getCarnet()
                +   " <BR /> "
                    +   "<FONT POINT-SIZE = \"9\">"
                    +   " <BR /> "
                    +   "Nombre: " + this.getNombre()
                    +   " <BR /> "
                    +   "Direccion: " + this.getDireccion()
                    +   " </FONT>"
                +   ">"
            +   "]"
            +   "\n";
        return contenido;
    }
    
}
