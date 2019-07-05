/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.avl;

import java.io.IOException;

import archivos.Escritura;
import estructuras.arboles.avl.subestructura.cola.ColaAVL;
import estructuras.arboles.avl.subestructura.cola.NodoColaAVL;
import pojos.Catedratico;

/**
 *
 * @author G
 */
public class ArbolAVL {
    public static String avl_aux;
    private NodoAVL raiz;
    ColaAVL cola_auxiliar;

    // Constructor
    public ArbolAVL() {
        raiz = null;
        avl_aux = "";
        cola_auxiliar = null;
    }
    
    // Verifica si esta vacio el arbol.
    public boolean esVacio(){
        return raiz == null;
    }
    
    public void vaciar(){
        raiz = null;
    }
    
    // Inserta la info en los nodos.
    public void insertar(Catedratico nuevo_catedratico){
        raiz = insertar(nuevo_catedratico, raiz);
    }
    
    // Obtiene la altura del nodo.
    private int altura(NodoAVL t){
        return t == null? -1 : t.altura;
    }
    
    // Maximo del nodo izq/der.
    private int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    
    // Factor de equilibrio
    private int getFactorEquilibrio(NodoAVL t) {
    	if(t == null) {
            return 0;
    	}else {
            return altura(t.getIzquierda())-altura(t.getDerecha());
    	}
    }
    
    // Inserta info en nodos, recursivamente.
    private NodoAVL insertar(Catedratico nuevo_catedratico, NodoAVL t){
    	System.out.println(nuevo_catedratico.getId());
    	System.out.println("Insertando");
        if(t == null){
            t = new NodoAVL(nuevo_catedratico);
//            System.out.println("Arbol vacio, insertando en la raiz.");
//        }else if(nuevo_catedratico.getId().compareTo(t.getCatedratico().getId()) < 0){
        }else if(nuevo_catedratico.getId() < t.getCatedratico().getId()){
//        	System.out.println("Insertando en la izquierda.");
            t.setIzquierda(insertar(nuevo_catedratico, t.getIzquierda()));
            if(getFactorEquilibrio(t) == 2){
//                if(nuevo_catedratico.getId().compareTo(t.getIzquierda().getCatedratico().getId()) < 0){
                if(nuevo_catedratico.getId() < t.getIzquierda().getCatedratico().getId()){
                    // CASO 1: Izquierda-izquierda
                    t = rotarConHijoIzq(t);
                }else{
                    // CASO 2: Izquierda-derecha
                    t = rotarDobleConHijoIzq(t);
                }
            }
            
//        }else if(nuevo_catedratico.getId().compareTo(t.getCatedratico().getId()) > 0){
        }else if(nuevo_catedratico.getId() > t.getCatedratico().getId()){
//        	System.out.println("Insertando en la derecha.");
            t.setDerecha(insertar(nuevo_catedratico, t.getDerecha()));
            if(getFactorEquilibrio(t) == 2){
//                if(nuevo_catedratico.getId().compareTo(t.getDerecha().getCatedratico().getId()) > 0){
                if(nuevo_catedratico.getId() > t.getDerecha().getCatedratico().getId()){
                    // CASO 3: Derecha-derecha
                    t = rotarConHijoDer(t);
                }else{
                    // CASO 4: Derecha-izquierda
                    t = rotarDobleConHijoDer(t);
                }
            }
            
        }else{
            ;   // Duplicado; no hace nada.
            System.out.println("Valor duplicado.");
        }
        t.setAltura(max(altura(t.getIzquierda()), altura(t.getDerecha())) + 1);
        return t;
    }
    
    // Rotacion del arbol binario con un hijo izquierdo.
    private NodoAVL rotarConHijoIzq(NodoAVL k2){
        NodoAVL k1 = k2.getIzquierda();
        k2.setIzquierda(k1.getDerecha());
        k1.setDerecha(k2);
        k2.setAltura(max(altura(k2.getIzquierda()), altura(k2.getDerecha()))+1);
        k1.setAltura(max(altura(k1.getIzquierda()), k2.getAltura())+1);
        
        return k1;
    }
    
    // Rotacion del arbol binario con un hijo derecho.
    private NodoAVL rotarConHijoDer(NodoAVL k1){
        NodoAVL k2 = k1.getDerecha();
        k1.setDerecha(k2.getIzquierda());
        k2.setIzquierda(k1);
        k1.setAltura(max(altura(k1.getIzquierda()), altura(k1.getDerecha()))+1);
        k2.setAltura(max(altura(k2.getDerecha()), k1.getAltura())+1);
        
        return k2;
    }
    
    // Doble rotacion de un nodo del arbo binario: Primero el hijo izquierdo
    // con su hijo derecho; luego el nodo k3 con su nuevo hijo izquierdo.
    private NodoAVL rotarDobleConHijoIzq(NodoAVL k3){
        k3.setIzquierda(rotarConHijoDer(k3.getIzquierda()));
        return rotarConHijoIzq(k3);
    }
    
    // Doble rotacion de un nodo del arbo binario: Primero el hijo derecho
    // con su hijo izquierdo; luego el nodo k1 con su nuevo hijo derecho.
    private NodoAVL rotarDobleConHijoDer(NodoAVL k1){
        k1.setDerecha(rotarConHijoIzq(k1.getDerecha()));
        return rotarConHijoDer(k1);
    }
    
    // Devuelve el numero de nodos
    public int contarNodos(){
        return contarNodos(raiz);
    }
    
    // Contar nodos, recursivamente.
    private int contarNodos(NodoAVL r){
        if(r == null){
            return 0;
        }else{
            int l = 1;
            l += contarNodos(r.getIzquierda());
            l += contarNodos(r.getDerecha());
            return l;
        }
    }
    
    // Buscar un elemento.
//    public boolean buscar(String codigo){
    public boolean buscar(int codigo){
        return buscar(raiz, codigo);
    }
    
    // Buscar, recursivamente.
//    private boolean buscar(NodoAVL r, String codigo){
    private boolean buscar(NodoAVL r, int codigo){
        boolean encontrado = false;
        while((r != null) && ! encontrado)        {
//            if(codigo.compareTo(r.getCatedratico().getId()) < 0){
            if(codigo < r.getCatedratico().getId()){
                r = r.getIzquierda();
//            }else if(codigo.compareTo(r.getCatedratico().getId()) > 0){
            }else if(codigo > r.getCatedratico().getId()){
                r = r.getDerecha();
            }else{
                encontrado = true;
                break;
            }
            encontrado = buscar(r, codigo);
        }
        
        return encontrado;
    }
    
    // Eliminar nodo
    public void eliminar(int codigo) {
    	raiz = eliminar(codigo, raiz);
    }
    
//    private NodoAVL eliminar(String codigo, NodoAVL t) {
    private NodoAVL eliminar(int codigo, NodoAVL t) {
    	if(t == null) {
    		return t;
    	}
//    	if(codigo.compareTo(t.getCatedratico().getId()) < 0) {
    	if(codigo < t.getCatedratico().getId()) {
            t.setIzquierda(eliminar(codigo, t.getIzquierda()));
//    	} else if(codigo.compareTo(t.getCatedratico().getId()) > 0) {
    	} else if(codigo > t.getCatedratico().getId()) {
            t.setDerecha(eliminar(codigo, t.getDerecha()));
    	}else {
            if(t.getIzquierda() == null || t.getDerecha() == null) {
                NodoAVL temp = null;
                if(temp == t.getIzquierda()) {
                    temp = t.getDerecha();
                }else {
                    temp = t.getIzquierda();
                }

                if(temp == null) {
                    temp = t;
                    t = null;
                }else {
                    t = temp;
                }
            }else {
                NodoAVL temp = sucesor(t.getDerecha());
                t.setCatedratico(new Catedratico(temp.getCatedratico().getId(), "", ""));
                t.setDerecha(eliminar(temp.getCatedratico().getId(), t.getDerecha()));
            }
    	}
    	
    	if(t == null) {
    		return t;
    	}
    	
    	t.setAltura(max(altura(t.getIzquierda()), altura(t.getDerecha())));
    	int balance = getFactorEquilibrio(t);
    	
    	// CASO 1: Izquierda-izquierda
    	if(balance > 1 && getFactorEquilibrio(t.getIzquierda()) >= 0) {
            return rotarConHijoDer(t);
    	}
    	// CASO 2: Izquierda-derecha
    	if(balance > 1 && getFactorEquilibrio(t.getIzquierda()) < 0) {
            t.setIzquierda(rotarConHijoIzq(t.getIzquierda()));
            return rotarConHijoDer(t);
    	}
    	// CASO 3: Derecha-derecha
    	if(balance < -1 && getFactorEquilibrio(t.getDerecha()) <= 0) {
            return rotarConHijoIzq(t);
    	}
    	// CASO 4: Derecha-izquierda
    	if(balance < -1 && getFactorEquilibrio(t.getDerecha()) > 0) {
            t.setDerecha(rotarConHijoDer(t.getDerecha()));
            return rotarConHijoIzq(t);
    	}
    	
    	return t;
    }
    
    // Nodo sucesor
    private NodoAVL sucesor(NodoAVL t) {
    	NodoAVL aux = t;
    	while(aux.getIzquierda() != null) {
            aux = aux.getIzquierda();
    	}
    	return aux;
    }
    
    // Editar
//    public void editar(String codigo_, Catedratico catedratico_nuevo) {
    public void editar(int codigo_, Catedratico catedratico_nuevo) {
    	editar(codigo_, catedratico_nuevo, raiz);
    }
    
//    private void editar(String codigo_, Catedratico catedratico_nuevo, NodoAVL t) {
    private void editar(int codigo_, Catedratico catedratico_nuevo, NodoAVL t) {
    	if(t != null) {
//            if(t.getCatedratico().getId().compareTo(codigo_) == 0) {
            if(t.getCatedratico().getId() == codigo_) {
                t.setCatedratico(null);
                t.setCatedratico(catedratico_nuevo);
                return;
            }
            editar(codigo_, catedratico_nuevo, t.getIzquierda());
            editar(codigo_, catedratico_nuevo, t.getDerecha());
    	}
    }

    boolean esRaiz, esIzquierdo;
	
    // Buscar catedratico
//    public Catedratico buscarCatedratico(String codigo) {
    public Catedratico buscarCatedratico(int codigo) {
        Catedratico user_temp = null;
        user_temp = buscarNodo(raiz, codigo).getCatedratico();
        return user_temp;
    }
	
    // Buscar nodo
//    public NodoAVL buscarNodo(String codigo) {
    public NodoAVL buscarNodo(int codigo) {
        return buscarNodo(raiz, codigo);
    }
	
	// Buscar nodo recursivo
//    private NodoAVL buscarNodo(NodoAVL r, String codigo){
    private NodoAVL buscarNodo(NodoAVL r, int codigo){
        if(r == null){
            return null;
        }
//        if(codigo.compareTo(r.getCatedratico().getId()) == 0){
        if(codigo == r.getCatedratico().getId()){
            System.out.println("Se encontro catedratico con ID: " + codigo);
            return r;
//        }else if(codigo.compareTo(r.getCatedratico().getId()) < 0){
        }else if(codigo < r.getCatedratico().getId()){
//            System.out.println("No se encontro catedratico con ID: "+codigo);
            return buscarNodo(r.getIzquierda(), codigo);
        }else{
            return buscarNodo(r.getDerecha(), codigo);
//            System.out.println("Se encontro catedratico con ID: "+aux.Catedratico().getId());
        }
    }
    
//    public Catedratico verificarContraseña(String codigo, String contrasena){
////        System.out.println("Pass a verificar: "+contrasena);
////        System.out.println("Nodo encontrado: "+buscarNodo(raiz, nickname).getNickname());
////        System.out.println("Pass: "+buscarNodo(raiz, nickname).getContraseña());
//    	Catedratico user_temp = null;
//        if(buscarNodo(raiz, codigo).Catedratico().getContrasena().equals(contrasena)){
//            user_temp = buscarNodo(raiz, codigo).Catedratico();
//            return user_temp;
//        }
//        return null;
//    }
    
    // Recorrer inorder.
    public void inorder(){
        inorder(raiz);
    }
        
    private void inorder(NodoAVL r){
        if(r != null){
            inorder(r.getIzquierda());
            System.out.print(r.getCatedratico().getId()+", ");
            inorder(r.getDerecha());
        }
    }
    
    public ColaAVL listar(){
        cola_auxiliar = new ColaAVL();
        listar(raiz);
        return cola_auxiliar;
    }
    
    private void listar(NodoAVL nodo){
        if(nodo == null){
            System.out.println("Arbol vacio.");
        }
        if(nodo != null){
            listar(nodo.getIzquierda());
            cola_auxiliar.encolar(new NodoColaAVL(nodo.getCatedratico()));
            listar(nodo.getDerecha());
        }
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
        String nombre = "arbolAVL";
        String dot_subgrafo_arbol_avl =
        "\n\tsubgraph cluster_avl"
        +   "\n\t{"
        +   "\n\t\tgraph[color = \"lightcyan\", fontcolor = \"steelblue4\", fontname = serif, style = filled, label = \"Catedraticos\"];"
        +   "\n\t\tnode[shape = egg, style = filled, color = navyblue, fontcolor = white, peripheries = 2];"
        +   "\n\t\tedge[color = deeppink];"
        +       "\n"
        + 	"\n"
            +   generarDot(raiz, "catedratico_")
        +   "\n\t}";
        
        if(opcion.equals("grafo")) {
            String dot_grafo_arbol_avl =   
            "digraph avl"
            +   "\n{"
                +   dot_subgrafo_arbol_avl
            +   "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_arbol_avl);
            Escritura.generarImagenDot(nombre);
            avl_aux = "";
            return "";
        }else if(opcion.equals("subgrafo")) {
            avl_aux = "";
            return dot_subgrafo_arbol_avl;
        }
        return "";
    }
    
    private String generarDot(NodoAVL r, String _id) throws IOException{
        if(r != null)
        {
            generarDot(r.getIzquierda(), _id);
            // ................ Inicia codigo para graficar ................
            // Verificando si tiene ambos hijos
            if(r.getIzquierda() != null && r.getDerecha() != null)
            {
                // Verificando hijo izquierdo
                if(r.getIzquierda() != null)
                {
                    // Contenido del nodo raiz
                    avl_aux += r.getContenido(_id);
                    // Contenido del nodo izquierdo
                    avl_aux +=	r.getIzquierda().getContenido(_id);
                    // Enlaces a los nodos
                    avl_aux += 	
                    "\t\t" + _id + r.getCatedratico().getId() + "->" + _id + r.getIzquierda().getCatedratico().getId()
                    +   "\n";
                }
                // Verificando hijo derecho
                if(r.getDerecha() != null)
                {
                    // Contenido del nodo raiz
                    avl_aux += r.getContenido(_id);
                    // Contenido del nodo izquierdo
                    avl_aux += r.getDerecha().getContenido(_id);
                    // Enlaces a los nodos
                    avl_aux += 	
                    "\t\t" + _id + r.getCatedratico().getId() + "->" + _id + r.getDerecha().getCatedratico().getId() 
                    +   "\n";
                }
            }
            // Si solo tiene un hijo
            else
            {
            	// Contenido del nodo raiz
            	avl_aux += r.getContenido(_id);
            	// Enlaces a los nodos
                avl_aux += "\t\t" + _id + r.getCatedratico().getId();
                // Verificando si solo tiene hijo derecho
                if(r.getIzquierda() != null && r.getDerecha() == null)
                {
                    // Enlaces a los nodos
                    avl_aux += 	
                    "->" + _id + r.getIzquierda().getCatedratico().getId() 
                    +   "\n";
                    // Contenido del nodo izquierdo
                    avl_aux += r.getIzquierda().getContenido(_id);
                }
                // Verificando si solo tiene hijo izquierdo
                if(r.getIzquierda() == null && r.getDerecha() != null)
                {
                    // Enlaces a los nodos
                    avl_aux += 	
                    "->" + _id + r.getDerecha().getCatedratico().getId()
                    + 	"\n";
                    // Contenido del nodo derecho
                    avl_aux += r.getDerecha().getContenido(_id);
                }
            }
            avl_aux += "\n";
            // ................ Finaliza codigo para graficar ................
            generarDot(r.getDerecha(), _id);
        }
        return avl_aux;
    }
    
}
