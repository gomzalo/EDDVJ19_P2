/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.tabla.hash;

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
    int N;
    int factorCarga;
    
    public TablaHash(){
        this.tabla = new Estudiante[37];
        this.N = 0;
        this.factorCarga = 0;
        Arrays.fill(this.tabla, null);
    }
    
    public int funcionHash(int clave){
        return (clave % this.tabla.length);
    }
    
    public void insertar(Estudiante nuevo_estudiante){
        double Por = ((double) this.N / this.tabla.length)*100;
        System.out.println("POR = " + Por);
        if(Por >= 55){
            reHash();
        }
        
        int indice = funcionHash(nuevo_estudiante.getCarnet());
        System.out.println("Se obtuvo el indice: " + indice);
        int tamano_tabla = this.tabla.length - 1;
        
        for (int k = 0; k < tamano_tabla; k++) {
//            System.out.println("i: " + i);
            if(k == indice){
                if(tabla[indice] == null){
                    tabla[indice] = nuevo_estudiante;
                    System.out.println("La posicion i = " + k + ", (indice = " + indice + ")"
                    + " esta libre, se inserto el carnet: " + nuevo_estudiante.getCarnet() + ". N: " + N);
                    N++;
                    return;
                }else if(this.tabla[indice].getCarnet() == nuevo_estudiante.getCarnet()){
                    System.err.println("¡Ya se ha ingresado un estudiante con el carnet: " + nuevo_estudiante.getCarnet() + "!");
                    return;
                }else{
                    System.err.println("Colision en indice: " + indice + ", carnet: " + nuevo_estudiante.getCarnet() + ".");
                    int i = 1;
                    indice = colision(nuevo_estudiante.getCarnet(), i);
                    System.err.println("Nuevo indice/clave: " + indice + ".");
                    i++;
                    return;
                }
            }
        }
         System.err.println("El estudiante con carnet: " + nuevo_estudiante.getCarnet()+ ", no pudo ser ingresado");
    }
    
    public int colision(int clave, int i){
        return ((clave % 7 + 1) * i);
    }
    
    public void mostrar(){
        if(this.tabla.length > 0){
            System.out.println("Elementos en la tabla hash:");
            for (int i = 0; i < this.tabla.length - 1; i++) {
                if(tabla[i] != null){
//                    System.out.println("Carnet: " + tabla[i].getCarnet() + " (pos = " + i + ")");
                    System.out.println("i: " + i + ", " + tabla[i].getCarnet() + " ");
                }else{
                    System.out.println("i: " + i + ", 0 ");
                }
            }
            System.out.println("");
            System.out.println("N: " + this.N);
        }else{
            System.out.println("Tabla vacia.");
        }
    }
    
    public void reHash(){
        System.err.println("¡Se ha superado el 55%!");
        Estudiante[] array_limpio = limpiarEspacios();
        int nuevo_tamano = getProximoPrimo(this.tabla.length * 2);
        System.err.println("Nuevo tamano: " + nuevo_tamano + ".");
        this.tabla = new Estudiante[nuevo_tamano];
        this.N = 0;
        
        
        Arrays.fill(this.tabla, null);
        
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
    
}
