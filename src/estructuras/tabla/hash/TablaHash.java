/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.tabla.hash;

import archivos.Escritura;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import pojos.Estudiante;

/**
 *
 * @author g
 */
public class TablaHash {
//    static final int TAM_TABLA = 37;
    public Estudiante[] tabla;
    int tamano;
    int N;
    int factorCarga;
    
    public TablaHash(){
        tamano = 37;
        tabla = new Estudiante[tamano];
        N = 0;
        factorCarga = 0;
        Arrays.fill(this.tabla, null);
    }
    
    public int funcionHash(int clave){
        return (clave % tamano);
    }
    
    public void insertar(Estudiante nuevo_estudiante){
        double Por = ((double) N / tamano)*100;
        System.out.println("POR = " + Por);
        if(Por >= 55){
            reHash();
        }
        
        int indice = funcionHash(nuevo_estudiante.getCarnet());
        System.out.println("Se obtuvo el indice: " + indice);
        int tamano_tabla = tamano - 1;
        int i = 1;

        while(tabla[indice] != null){
            System.err.println("Colision en indice: " + indice + ", carnet: " + nuevo_estudiante.getCarnet() + ".");
            indice = indice + colision(nuevo_estudiante.getCarnet(), i);
            indice = indice%tamano;
            System.err.println("Nuevo indice/clave: " + indice + ".");
            i++;
        }

        tabla[indice] = nuevo_estudiante;
        System.out.println("La posicion i = " + i + ", (indice = " + indice + ")"
        + " esta libre, se inserto el carnet: " + nuevo_estudiante.getCarnet() + ". N: " + N);
        N++;
//        System.err.println("El estudiante con carnet: " + nuevo_estudiante.getCarnet()+ ", no pudo ser ingresado");
    }
    
    public int colision(int clave, int i){
        return ((clave % 7 + 1) * i);
    }
    
    public void mostrar(){
        if(this.tabla.length > 0){
            System.out.println("Elementos en la tabla hash:");
//            for (int i = 0; i < this.tabla.length - 1; i++) {
            int i = 0;
            for (Estudiante e : tabla) {
                if(e != null){
//                    System.out.println("Carnet: " + tabla[i].getCarnet() + " (pos = " + i + ")");
                    System.out.println("i: " + i + ", " + e.getCarnet() + ", nombre: " + e.getNombre());
                }else{
                    System.out.println("i: " + i + ", 0 ");
                }
                i++;
            }
                
//            }
            System.out.println("");
//            System.out.println("N: " + this.N);
        }else{
            System.out.println("Tabla vacia.");
        }
    }
    
    public int getTamano(){
        return this.N;
    }
    
    public boolean esVacia(){
        return this.tabla.length < 1;
    }
    
    public void reHash(){
        System.err.println("¡Se ha superado el 55%!");
        Estudiante[] array_limpio = limpiarEspacios();
        tamano = getProximoPrimo(tamano * 2);
        System.err.println("Nuevo tamano: " + tamano + ".");
        tabla = new Estudiante[tamano];
        N = 0;
        
        
        Arrays.fill(tabla, null);
        
        for (Estudiante estudiante : array_limpio) {
            insertar(estudiante);
        }
    }
    
    public Estudiante[] limpiarEspacios(){
        ArrayList<Estudiante> List = new ArrayList<>();
        for(Estudiante e : this.tabla){
            if(e != null){
                List.add(e);
            }
        }
        return List.toArray(new Estudiante[List.size()]);
    }
    
    private boolean esPrimo(int num){
        if(num == 2 || num == 3){
            return true;
        }
        if(num == 1 || num % 2 == 0){
            return false;
        }
        for(int i = 3; i * i <= num; i += 2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    private int getProximoPrimo(int numMinimo){
//        for (int i = numMinimo; true; i++) {
//            if(esPrimo(i)){
//                return i;
//            }
//        }
        if(numMinimo % 2 == 0){
            numMinimo++;
        }
        for(; !esPrimo(numMinimo); numMinimo += 2);
        
        return numMinimo;
    }
    
    public Estudiante buscar(int carnet){
//        int indice = funcionHash(carnet);
        if(!esVacia()){
//            for (int i = 0; i < this.tabla.length - 1; i++) {
//                if(i == indice){
//                    if(tabla[i] != null){
//                        return tabla[i];
//                    }else{
//                        return null;
//                    }
//                }
//            }
            for (Estudiante e : tabla) {
                if(e != null){
                    if(carnet == e.getCarnet()){
                        return e;
                    }
                }
            }
        }else{
            System.out.println("Tabla vacia.");
        }
        return null;
    }
    
    public boolean modificar(int carnet, String nuevo_nombre, String nueva_direccion){
        if(buscar(carnet) != null){
            buscar(carnet).setNombre(nuevo_nombre);
            buscar(carnet).setDireccion(nueva_direccion);
            System.out.println("Se ha modificado el carnet: " +  carnet + 
            ", por nombre: " + nuevo_nombre + ", direccion: " + nueva_direccion + ".");
            return true;
        }else{
            System.out.println("No existe tal carnet en la tabla.");
            return false;
        }
    }
    
    public boolean eliminar(int carnet){
        int indice = funcionHash(carnet);
        if(this.tabla.length > 0){
            for (int i = 0; i < this.tabla.length - 1; i++) {
                if(i == indice){
                    tabla[i] = null;
                    System.out.println("Se ha eliminado el carnet: " + carnet + ".");
                    N--;
                    return true;
                }
            }
        }else{
            System.out.println("Tabla vacia.");
            return false;
        }
        return false;
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
        System.out.println("Se muestra la grafica de los estudiantes en la tabla hash:");
        String nombre = "tabla_hash_estudiantes";
        String dot_subgrafo_tabla_hash_estudiantes =
         	"\n\tsubgraph cluster_tabla_hash_estudiantes"
            + 	"\n\t{"
            +   "\n"
            +   "\n\t\tgraph[color = \"grey19:grey6\", fontcolor = \"white\", fontname = serif, style = filled, label = \"Estudiantes\"];"
            + 	"\n\t\tnode[shape = record, style = filled, color = black, fillcolor = \"white:seagreen1\", fontcolor = black, peripheries = 2];"
            + 	"\n\t\tedge[color = \"aquamarine:white:blue\"];"
            + 	"\n"
            + 	"\n"
                +   generarDot("estudiante_")
            +	"\n\t}";
        if(opcion.equals("grafo")){
            String dot_grafo_tabla_hash_estudiantes =
            "digraph tabla_hash_estudiantes"
            +   "\n{"
                + "rankdir=\"LR\""
                +   dot_subgrafo_tabla_hash_estudiantes    
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_tabla_hash_estudiantes);
            Escritura.generarImagenDot(nombre);
            return "";
        }else if(opcion.equals("subgrafo")){
            return dot_subgrafo_tabla_hash_estudiantes;
        }
        return "";
    }
    
    public String generarDot(String _id){
        String dot = "";
        if(this.tabla.length > 0){
             // ----------------------	Llenando tabla				----------------------
            dot += "\t\tTABLAHASH  [label = \"";
            int length = this.tabla.length - 1;
            for (int i = 0; i <= length; i++) {
                dot += "<p" + i + "> " + i;
                if (i != length) {
                    dot += "|";
                }
            }

            dot +=  "\""
                +   "];"
                +   "\n";
            
            // ----------------------	Contendio					----------------------
            for (Estudiante estudiantes_auxiliar : this.tabla) {
                if (estudiantes_auxiliar != null) {
                    dot +=  estudiantes_auxiliar.getContenido(_id);
                }
            }
            dot += 	"\n"
                + 	"\n";
        
            // ----------------------	Enlaces de tabla a nodos	----------------------
            for (int i = 0; i <= length; i++) {
                Estudiante estudiante_auxiliar = this.tabla[i];
                if (estudiante_auxiliar != null) {
                    dot += 	"\t\tTABLAHASH:p" + i + " -> prod" + _id + estudiante_auxiliar.getCarnet()+ ";"
                            + 	"\n";
                }
            }
        }else{
            System.err.println("Tabla vacia, nada que graficar.");
        }
        return dot;
    }
    
}
