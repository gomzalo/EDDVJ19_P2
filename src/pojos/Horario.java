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
public class Horario {
    private int codigo;
    private String periodo;
    private String dia;
    private int codigo_curso;
    private int codigo_salon;
    private String nombre_edificio;
    private int id_catedratico;
    

    public Horario(int codigo, String periodo, String dia, int codigo_curso, int codigo_salon, String nombre_edificio, int id_catedratico) {
        this.codigo = codigo;
        this.periodo = periodo;
        this.dia = dia;
        this.codigo_curso = codigo_curso;
        this.codigo_salon = codigo_salon;
        this.nombre_edificio = nombre_edificio;
        this.id_catedratico = id_catedratico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_salon() {
        return codigo_salon;
    }

    public void setCodigo_salon(int codigo_salon) {
        this.codigo_salon = codigo_salon;
    }

    public int getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getNombre_edificio() {
        return nombre_edificio;
    }

    public void setNombre_edificio(String nombre_edificio) {
        this.nombre_edificio = nombre_edificio;
    }

    public int getId_catedratico() {
        return id_catedratico;
    }

    public void setId_catedratico(int id_catedratico) {
        this.id_catedratico = id_catedratico;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getContenido(){
        String contenido = "";
        contenido += "Codigo: "     + this.getCodigo()
        + "\\nPeriodo: "            + this.getPeriodo()
        + "\\nDia: "                + this.getDia()
        + "\\nCodigo de curso: "    + this.getCodigo_curso()
        + "\\nCodigo de salon: "    + this.getCodigo_salon()
        + "\\nCodigo de edificio: " + this.getNombre_edificio()
        + "\\nID de catedratico: "  + this.getId_catedratico();
        return contenido;
    }
    
}
