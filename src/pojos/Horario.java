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
    private int codigo_salon;
    private int codigo_curso;
    private int codigo_edificio;
    private int num_identificacion;
    private String periodo;
    private String dia;

    public Horario(int codigo, int codigo_salon, int codigo_curso, int codigo_edificio, int num_identificacion, String periodo, String dia) {
        this.codigo = codigo;
        this.codigo_salon = codigo_salon;
        this.codigo_curso = codigo_curso;
        this.codigo_edificio = codigo_edificio;
        this.num_identificacion = num_identificacion;
        this.periodo = periodo;
        this.dia = dia;
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

    public int getCodigo_edificio() {
        return codigo_edificio;
    }

    public void setCodigo_edificio(int codigo_edificio) {
        this.codigo_edificio = codigo_edificio;
    }

    public int getNum_identificacion() {
        return num_identificacion;
    }

    public void setNum_identificacion(int num_identificacion) {
        this.num_identificacion = num_identificacion;
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
        + "\\nCodigo de salon: "    + this.getCodigo_salon()
        + "\\nCodigo de curso: "    + this.getCodigo_curso()
        + "\\nCodigo de edificio: " + this.getCodigo_edificio()
        + "\\nNumero de ID: "       + this.getNum_identificacion()
        + "\\nPeriodo: "            + this.getPeriodo()
        + "\\nDia: "                + this.getDia();
        return contenido;
    }
    
}
