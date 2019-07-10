/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arboles.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojos.Horario;
import archivos.Escritura;
import estructuras.listas.simples.ListaS;

/**
 *
 * @author G
 */
public class ArbolB<T> {
    private PaginaB<T> raiz;
    private int orden;
    private int indiceDivision;
    private int tamPagina;
    
    public static String b_aux;
    
    public ArbolB(){
    }

    public ArbolB(int orden) {
        indiceDivision = (orden+1)/2;
        this.raiz = new PaginaB(orden,indiceDivision);
        this.orden = orden;
    }
    
    
    public boolean esVacio() {
    	return raiz == null;
    }
    
    public void Insertar(Horario nuevo_horario, ListaS asignaciones){
        
//        if(nuevo_horario != null){
//            
//        }
        //verificar si la raiz no es nula
        PaginaB<T> retorno=Insertar(new NodoB<Horario>(nuevo_horario, asignaciones, nuevo_horario.getCodigo()),raiz);
        if(retorno != null){
            raiz=retorno;
        }
    }
    
    public PaginaB<T> Insertar(NodoB<Horario> nuevo, PaginaB<T> actual){
        if(actual.getHijos() != null){//si no es hoja
            int indice = actual.buscarIndice(nuevo.getLlave());//indice en el que se tiene que insertar
            PaginaB<T> retorno = Insertar(nuevo, actual.getHijos()[indice]);
            if(retorno != null){//si se hizo division en el hijo
                actual.insertarHijoBorrando(retorno.getHijos()[0],indice);//inserta en un indice determinado
                actual.insertarHijoSinBorrar(retorno.getHijos()[1],indice+1);//inserta en un indice determinado
                PaginaB<T> retorno2 = actual.insertarLlave(retorno.getLlaves()[0]);//siempre se inserta en orden por getLlave()
                if(retorno2 != null){//si la pagina se divide
                    return retorno2;
                }else{//si la pagina no se divide
                    return null;
                }
            }else{//si no se hizo division de hijo
                return null;
            }
        }else{//si es hoja
            return actual.insertarLlave(nuevo);
        }
    }
    
    public String ImprimirRaiz(){
        String texto = "";
        for (int i = 0; i < raiz.getTam(); i++) {
            if(raiz.getLlaves()[i] != null){
                texto += raiz.getLlaves()[i].getLlave() + ",";
            }
        }
        return texto;
    }
    
    public void Imprimir(){
        if(this.raiz != null){
            Imprimir(raiz);
        }
    }
      
    public void Imprimir(PaginaB<T> actual){
        if(actual != null){
            if(actual.getHijos() != null){
                for (int i = 0; i < actual.getLlenura(); i++) {
                    if(actual.getHijos()[i] != null){
                        Imprimir(actual.getHijos()[i]);
                        System.out.println(actual.getLlaves()[i].getHorario().getCodigo());
                    }
            }
            Imprimir(actual.getHijos()[actual.getLlenura()]);
            }else{
                for (int i = 0; i < actual.getLlenura(); i++) {
                    if(actual.getLlaves()[i] != null){
                        System.out.println(actual.getLlaves()[i].getHorario().getCodigo());
                        
                        
                    }
                }
                System.out.println("\n");
            }
            
        }
    }
    
    public NodoB<Horario> buscarPorParametro(int codigo){
        return buscarPorParametro(raiz, codigo);
    }
    
    public void modificar(int codigo, T info){
        NodoB<Horario> aModificar=buscarPorParametro(codigo);
        if(aModificar != null){
            aModificar.setHorario((Horario) info);
        }
    }
    
//    public void agregarDetalle(String parametro, Cola detalle){
//        if(buscarPorParametro(parametro).getInfo().getDetalle() == null){
//            buscarPorParametro(parametro).getInfo().setDetalle(detalle);
//        }else{
//            NodoCola aux = detalle.getCabeza();
//            NodoCola ultimoAux = detalle.getUltimo();
//            while(aux != ultimoAux.getSiguiente()){
//                buscarPorParametro(parametro).getInfo().getDetalle().insertar(aux.getCantidad(), aux.getPrecio(), aux.getProducto());
//                aux = aux.getSiguiente();
//            }            
//        }
//    }
    
    private NodoB<Horario> buscarPorParametro(PaginaB<T> actual, int codigo){
        if(actual != null){
            NodoB<Horario> aRetornar = null;
            for (int i = 0; i < actual.getLlaves().length; i++) {
                if(actual.getLlaves()[i] != null){
                    if(codigo == actual.getLlaves()[i].getHorario().getCodigo()){
                        //si son iguales, retornar
                        aRetornar = actual.getLlaves()[i];
                        return aRetornar;
                    }else{
                        if(actual.getHijos() != null){
                            aRetornar = buscarPorParametro(actual.getHijos()[i], codigo);
                            if(aRetornar != null){
                                return aRetornar;
                            }
                        }
                    }
                }else{
                    if(actual.getHijos() != null){
                        aRetornar = buscarPorParametro(actual.getHijos()[i], codigo);
                        if(aRetornar != null){
                            return aRetornar;
                        }
                        i=actual.getLlaves().length;
                    }
                }
            }
        }
        return null;
    }
    
    public String graficar(String opcion) throws IOException, InterruptedException{
    	String nombre = "arbol_b";
        String dot_subgrafo_arbol_b = 
        "\n\tsubgraph cluster_arbol_b_horarios"
        + "\n\t{"
        + "\n"
            + "\n\t\tgraph[color = \"magenta:cyan\", fontcolor = \"indigo\", fontname = serif, style = filled, label = \"Horarios\"];"
            + "\n\t\tnode[shape = record, color = \"indigo\", fontname = serif, style = filled, fillcolor = \"honeydew4:lavenderblush\", fontcolor = \"black\", fontsize = 11];"
            + "\n\t\tedge[color = \"deeppink:black:greenyellow\"];"
            + "\n"
            + "\n"
                + generarDot()
        + "\n\t}";
        if(opcion.equals("grafo")) {
            String dot_grafo_arbol_b = 
            "digraph b"
            + "\n{"
                + dot_subgrafo_arbol_b
            + "\n}";
            Escritura.escribirArchivoDot(nombre, dot_grafo_arbol_b);
            Escritura.generarImagenDot(nombre);
            b_aux = "";
            dot_grafo_arbol_b = "";
            return "";
        }else if(opcion.equals("subgrafo")) {
            b_aux = "";
            return dot_subgrafo_arbol_b;
        }
        
        return "";
    }
    
    // Variables para grafica
    
//    String label = "";
//    String nodo  = "";
//    String texto = "";
//    String conexion = "";
//    String enlacePrincipal = "";
//    String t = "";
    
    public String generarDot() throws IOException, InterruptedException{
        //recursiva  
//    	b_aux = "";
//    	label = "";
//        nodo  = "";
//        texto = "";
//        conexion = "";
//        enlacePrincipal = "";
//        t = "";
        return generarDot(this.raiz);
    }

    private String generarDot(PaginaB<T> pagina) throws IOException, InterruptedException{
        if(pagina != null){
            
            String label = "[label = \"";
            String nodo = "\t\tNodo";
            int contador = 0;
            for (int i = 0; i < pagina.getLlaves().length; i++) {
                if(pagina.getLlaves()[i] != null){
                    nodo += pagina.getLlaves()[i].getLlave();
                    label += "<" + Integer.toString(i) + ">"
                    		+ "|"
                                + pagina.getLlaves()[i].getHorario().getContenido()
//                                + pagina.getLlaves()[i].getHorario().getCodigo()
                    		+ "|";
                    contador++;
                }
            }
            label 	+=	"<" + Integer.toString(contador) + ">\"];";
            nodo 	+=	label 
            		+ 	"\n";
            String texto = "";
            if(pagina.getHijos() != null){
                for (int i = 0; i < pagina.getHijos().length; i++) {
                    if(pagina.getHijos()[i] != null){
                        texto += generarDot(pagina.getHijos()[i]);
                    }
                }    
            }
//            String textoConexiones="";
            //System.out.print("Nodo");
//            int contador2=0;
            /*for (int i = 0; i < pagina.getLlaves().length; i++) {
                
                if(pagina.getLlaves()[i]!=null){
                    System.out.print(Integer.toString(pagina.getLlaves()[i].getLlave()));
                    //llamada a metodo
                    contador++;
                }
            }
            System.out.println(":");*/
            
            String conexion = "";
            if(pagina.getHijos() != null){
                
                String enlacePrincipal = generarTextoNodo(pagina);
                for (int i = 0; i < pagina.getHijos().length; i++) {
                    if(pagina.getHijos()[i] != null){
                        
                        String t = generarTextoNodo(pagina.getHijos()[i]);
                        conexion += enlacePrincipal + ":" + Integer.toString(i) + "->" + t + ";"
                        		 + 	"\n";
                        //System.out.println(enlacePrincipal+":"+Integer.toString(i)+"->"+t+";");
                    }else{
                        i = pagina.getHijos().length;
                    }
                    
                }
            }
            
            String asignaciones = "";
            // Asignaciones
            for (int i = 0; i < pagina.getLlaves().length; i++) {
                if(pagina.getLlaves()[i] != null){
                    // Verificando si tiene asignaciones
                    if(pagina.getLlaves()[i].getAsignaciones() != null){
                        System.out.println("Tiene asignaciones");
                        // Obteniendo la grafica de la lista de asignacioens
                        asignaciones += 
                        pagina.getLlaves()[i].getAsignaciones().
                        graficar("subgrafo", "horario_" + String.valueOf(pagina.getLlaves()[i].getLlave()))
                        + "\n"
                        + "\n";
                        // Enlazando nodo actual con su lista de asignaciones
                        String conexionn = "";
                        String enlacePrincipal = generarTextoNodo(pagina);
//                                        String t = generarTextoNodo(pagina.getHijos()[k]);
                        conexionn += 
                        enlacePrincipal + ":" + Integer.toString(i);

                        asignaciones +=
                        "\n\t\t" + conexionn 
                        + "->" + "horario_" + pagina.getLlaves()[i].getLlave() + "_asignacion_"
                        + pagina.getLlaves()[i].getAsignaciones().getInicio().getAsignacion().getCarnet()
                        + "\n"
                        + "\n";

                    }
                }
            }    
            
            b_aux = nodo + texto + conexion + asignaciones;
            return b_aux;
        }
        
        return "";
    }
    
    private String generarTextoNodo(PaginaB<T> pagina){
        if(pagina != null){
            String texto = "\t\tNodo";
            for (int i = 0; i < pagina.getLlaves().length; i++) {
                if(pagina.getLlaves()[i] != null){
                    texto += pagina.getLlaves()[i].getLlave();
                }
            }
            return texto;
        }
        return "";
    }
   
    public NodoB<Horario> buscarPorIndice(String parametro){
        return buscarPorIndice((PaginaB<Horario>) raiz,parametro);
//        return buscarPorIndice(raiz,parametro);
    }
    
    private NodoB<Horario> buscarPorIndice(PaginaB<Horario> actual, String parametro){
        if(actual!=null){
            NodoB<Horario> aRetornar=null;
            for (int i = 0; i < actual.getLlaves().length; i++) {
                if(actual.getLlaves()[i]!=null){
                    if(parametro.equals(actual.getLlaves()[i].getLlave())){
                        //si son iguales, retornar
                        aRetornar=actual.getLlaves()[i];
                        return aRetornar;
                    }else{
                        if(actual.getHijos()!=null){
                            aRetornar=buscarPorIndice(actual.getHijos()[i], parametro);
                            if(aRetornar!=null){
                                return aRetornar;
                            }
                        }
                    }
                }else{
                    if(actual.getHijos()!=null){
                        aRetornar=buscarPorIndice(actual.getHijos()[i], parametro);
                        if(aRetornar!=null){
                            return aRetornar;
                        }
                        i=actual.getLlaves().length;
                    }
                }
            }
        }
        return null;
    }

//	public List<Horario> listar() {
//		lista = new ArrayList<>();
//		listar(raiz);
//		return lista;
//	}
//	
//	private void listar(PaginaB<T> actual){
//        if(actual != null){
//            if(actual.getHijos() != null){
//                for (int i = 0; i < actual.getLlenura(); i++) {
//                if(actual.getHijos()[i] != null){
//                	listar(actual.getHijos()[i]);
//                    System.out.println(actual.getLlaves()[i].getInfo_factura().getId_factura());
//                    lista.add(actual.getLlaves()[i].getInfo_factura());
//                }
//            }
//                listar(actual.getHijos()[actual.getLlenura()]);
//            }else{
//                for (int i = 0; i < actual.getLlenura(); i++) {
//                    if(actual.getLlaves()[i] != null){
//                        System.out.println(actual.getLlaves()[i].getInfo_factura().getId_factura());
//                        lista.add(actual.getLlaves()[i].getInfo_factura());
//                    }
//                }
//                System.out.println("\n");
//            }
//            
//        }
//    }
    
    
}
