/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import estructuras.Estructuras;
import estructuras.listas.dobles.circular.NodoDC_E;
import estructuras.listas.dobles.ordenada.NodoDO_U;
import estructuras.listas.simples.ListaS;
import estructuras.listas.simples.NodoS;
import estructuras.listas.simples.ordenada.ListaSO_S;
import estructuras.listas.simples.ordenada.NodoSO_C;
import estructuras.listas.simples.ordenada.NodoSO_S;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import pojos.Asignacion;
import pojos.Catedratico;
import pojos.Curso;
import pojos.Edificio;
import pojos.Estudiante;
import pojos.Horario;
import pojos.Salon;
import pojos.Usuario;

/**
 *
 * @author g
 */
public class Lectura {
    
    public static void Leer(String ruta) throws FileNotFoundException, IOException, InterruptedException {
        
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(ruta);
            sc = new Scanner(inputStream, "UTF-8");
// ..................... Contenido archivo ..................... 
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                // :::::::::::::::::::  ESTUDIANTE :::::::::::::::::::
                // Estudiante(carnet, nombre, dirección);
                if(linea.startsWith("Estudiante") || linea.startsWith("estudiante")){
                    int carnet = 0;
                    String nombre = "";
                    String direccion = "";
                    
                    linea = linea.replaceAll("Estudiante", "");
                    linea = linea.replaceAll("estudiante", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //carnet, nombre, dirección
                    String[] estudiante = linea.split(",");
                    carnet = Integer.valueOf(estudiante[0].trim());
                    nombre = estudiante[1];
                    nombre = nombre.trim();
                    nombre = nombre.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre: " + nombre);
                    direccion = estudiante[2];
                    direccion = direccion.trim();
                    direccion = direccion.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("direccion: " + direccion);
                    // Insertando a tabla hash de estudiantes
                    estructuras.Estructuras.th_estudiantes.insertar(new Estudiante(carnet, nombre, direccion));
                }
                // :::::::::::::::::::  USUARIO :::::::::::::::::::
                // Usuario(ID, nombre, contraseña, tipo);
                if(linea.startsWith("Usuario") || linea.startsWith("usuario")){
                    int id = 0;
                    String nombre = "";
                    String contrasena = "";
                    String tipo = "";
                    
                    linea = linea.replaceAll("Usuario", "");
                    linea = linea.replaceAll("usuario", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //ID, nombre, contraseña, tipo
                    String[] usuario = linea.split(",");
                    id = Integer.valueOf(usuario[0].trim());
                    nombre = usuario[1];
                    nombre = nombre.trim();
                    nombre = nombre.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre: " + nombre);
                    contrasena = usuario[2];
                    contrasena = contrasena.trim();
                    contrasena = contrasena.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("pass: " + contrasena);
                    tipo = usuario[3];
                    tipo = tipo.trim();
                    tipo = tipo.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("tipo: " + tipo);
                    // Insertando a lista doble ordenada de usuarios
                    if(tipo.equals("Estudiante") || tipo.equals("estudiante")){
                        if(estructuras.Estructuras.th_estudiantes.getTamano() > 0){
                           if(estructuras.Estructuras.th_estudiantes.buscar(id) != null){
                               Usuario usuario_temporal = new Usuario(id, nombre, contrasena, tipo);
                               usuario_temporal.setEstudiante(estructuras.Estructuras.th_estudiantes.buscar(id));
                               estructuras.Estructuras.ldo_usuarios.insertar(new NodoDO_U(usuario_temporal));
                               
                           }else{
                                JOptionPane.showMessageDialog(null, "¡No existe un estudiante con el ID:" + id + "!", 
                                "Atencion", JOptionPane.WARNING_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No se han cargado los estudiantes!", 
                            "Atencion", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        estructuras.Estructuras.ldo_usuarios.insertar(new NodoDO_U(new Usuario(id, nombre, contrasena, tipo)));
                    }
                }
                // :::::::::::::::::::  CATEDRATICO :::::::::::::::::::
                // Catedratico(id, nombre, dirección);
                if(linea.startsWith("Catedratico") || linea.startsWith("catedratico")){
                    int id = 0;
                    String nombre = "";
                    String direccion = "";
                    
                    linea = linea.replaceAll("Catedratico", "");
                    linea = linea.replaceAll("catedratico", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //carnet, nombre, dirección
                    String[] catedratico = linea.split(",");
                    id = Integer.valueOf(catedratico[0].trim());
                    nombre = catedratico[1];
                    nombre = nombre.trim();
                    nombre = nombre.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre: " + nombre);
                    direccion = catedratico[2];
                    direccion = direccion.trim();
                    direccion = direccion.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("direccion: " + direccion);
                    // Insertando al arbol avl de catedraticos
                    estructuras.Estructuras.avl_catedraticos.insertar(new Catedratico(id, nombre, direccion));
                }
                // :::::::::::::::::::  EDIFICIO :::::::::::::::::::
                // Edificio(nombre);
                if(linea.startsWith("Edificio") || linea.startsWith("edificio")){
                    String nombre = "";
                    
                    linea = linea.replaceAll("Edificio", "");
                    linea = linea.replaceAll("edificio", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //nombre
                    nombre = linea;
                    nombre = nombre.trim();
                    nombre = nombre.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre: " + nombre);
                    // Insertando a lista doble circular de edificios
                    estructuras.Estructuras.ldc_edificios.insertar(new NodoDC_E(new Edificio(nombre), null));
                }
                // :::::::::::::::::::  SALON :::::::::::::::::::
                // Salon(nombre, número, capacidad);
                if(linea.startsWith("Salon") || linea.startsWith("salon")){
                    String nombre_edificio = "";
                    int numero = 0;
                    int capacidad = 0;
                    
                    linea = linea.replaceAll("Salon", "");
                    linea = linea.replaceAll("salon", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    // nombre, número, capacidad
                    String[] salon = linea.split(",");
                    nombre_edificio = salon[0].trim();
                    nombre_edificio = nombre_edificio.trim();
                    nombre_edificio = nombre_edificio.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre: " + nombre_edificio);
                    numero = Integer.valueOf(salon[1].trim());
                    capacidad = Integer.valueOf(salon[2].trim());
                    // Insertando a su edificio correspondiente
                    if(estructuras.Estructuras.ldc_edificios.buscar(nombre_edificio)){
                        if(estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).getSalones() == null){
                            ListaSO_S lista_salones_temp = new ListaSO_S();
                            lista_salones_temp.
                            insertar(new NodoSO_S(new Salon(numero, nombre_edificio, capacidad)));
                            
                            estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).
                            setSalones(lista_salones_temp);
                        }else{
                            estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).
                            getSalones().insertar(new NodoSO_S(new Salon(numero, nombre_edificio, capacidad)));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡No se han cargado los edificios!", 
                        "Atencion", JOptionPane.WARNING_MESSAGE);
                    }
                }
                // :::::::::::::::::::  CURSO :::::::::::::::::::
                // Curso(código, nombre, semestre, créditos);
                if(linea.startsWith("Curso") || linea.startsWith("curso")){
                    int codigo = 0;
                    String nombre = "";
                    int semestre = 0;
                    int creditos = 0;
                    
                    linea = linea.replaceAll("Curso", "");
                    linea = linea.replaceAll("curso", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //código, nombre, semestre, créditos
                    String[] curso = linea.split(",");
                    codigo = Integer.valueOf(curso[0].trim());
                    nombre = curso[1];
                    nombre = nombre.trim();
                    nombre = nombre.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre: " + nombre);
                    semestre = Integer.valueOf(curso[2].trim());
                    creditos = Integer.valueOf(curso[3].trim());
                    // Insertando a lista simple ordenada de cursos
                    estructuras.Estructuras.lso_cursos.
                    insertar(new NodoSO_C(new Curso(codigo, nombre, semestre, creditos)));
                }
                // :::::::::::::::::::  HORARIO :::::::::::::::::::
                // Horario(código, período, día, codCurso, codSalón, codEdificio, numIdentificacion);
                if(linea.startsWith("Horario") || linea.startsWith("horario")){
                    int codigo = 0;
                    String periodo = "";
                    String dia = "";
                    int codigo_curso = 0;
                    int codigo_salon = 0;
                    String nombre_edificio = "";
                    int id_catedratico = 0;
                    
                    linea = linea.replaceAll("Horario", "");
                    linea = linea.replaceAll("horario", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //código, período, día, codCurso, codSalón, codEdificio, numIdentificacion
                    String[] curso = linea.split(",");
                    
                    codigo = Integer.valueOf(curso[0].trim());
                    periodo = curso[1];
                    periodo = periodo.trim();
                    periodo = periodo.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("periodo: " + periodo);
                    dia = curso[2];
                    dia = dia.trim();
                    dia = dia.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("dia: " + dia);
                    codigo_curso = Integer.valueOf(curso[3].trim());
                    codigo_salon = Integer.valueOf(curso[4].trim());
                    nombre_edificio = curso[5].trim();
                    nombre_edificio = nombre_edificio.replaceAll("[\"'\u2018\u2019\u201c\u201d]", "");
                    System.out.println("nombre_edificio: " + nombre_edificio);
                    id_catedratico = Integer.valueOf(curso[6].trim());
                    
                    // Insertando al arbol b de horarios
                    if(!estructuras.Estructuras.lso_cursos.esVacia() &&
                    !estructuras.Estructuras.ldc_edificios.esVacia() &&
                    !estructuras.Estructuras.avl_catedraticos.esVacio()){
                        
                        if(estructuras.Estructuras.lso_cursos.buscar(codigo_curso) &&
                        estructuras.Estructuras.ldc_edificios.buscar(nombre_edificio) &&
                        estructuras.Estructuras.avl_catedraticos.buscar(id_catedratico)){
                            
                            if(estructuras.Estructuras.ldc_edificios.
                            buscarNodo(nombre_edificio).getSalones().buscar(codigo_salon)){
                                if(estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).
                                getSalones().buscarNodo(codigo_salon).getSalon().getEstudiantes_asignados() <
                                estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).
                                getSalones().buscarNodo(codigo_salon).getSalon().getCapacidad()){
                                    estructuras.Estructuras.b_horarios.Insertar(
                                    new Horario(codigo, periodo, dia, codigo_curso, codigo_salon,
                                    nombre_edificio, id_catedratico), null);

                                    estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).
                                    getSalones().buscarNodo(codigo_salon).getSalon().setEstudiantes_asignados(
                                    estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio).
                                    getSalones().buscarNodo(codigo_salon).getSalon().getEstudiantes_asignados() + 1);

                                }else{
                                    JOptionPane.showMessageDialog(null, "¡No se pudo insertar el horario: " + codigo
                                    + "\nel salon: " + codigo_salon + ", ya esta lleno!", 
                                    "Atencion", JOptionPane.WARNING_MESSAGE);
                                }

                            }else{
                                JOptionPane.showMessageDialog(null, "¡No se pudo insertar el horario: " + codigo
                                + "\nno existe el salon: " + codigo_salon + ", en el edificio: " + nombre_edificio + "!", 
                                "Atencion", JOptionPane.WARNING_MESSAGE);
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No se pudo insertar el horario " + codigo
                            + "\nno existe el curso, edificio o catedratico!", 
                            "Atencion", JOptionPane.WARNING_MESSAGE);
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "¡No se pudo insertar el horario " + codigo
                        + "\nno se han cargado los cursos, edificios o catedraticos!", 
                        "Atencion", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
                // :::::::::::::::::::  ASIGNAR :::::::::::::::::::
                // Asignar(carnet, codHorario, zona, final);
                if(linea.startsWith("Asignar") || linea.startsWith("asignar")){
                    int carnet = 0;
                    int codigo_horario = 0;
                    int zona = 0;
                    int nota_final = 0;
                    
                    linea = linea.replaceAll("Asignar", "");
                    linea = linea.replaceAll("asignar", "");
                    linea = linea.replaceAll("[();]", "");
//                    System.out.println(linea);
                    //carnet, codHorario, zona, final
                    String[] asignacion = linea.split(",");
                    carnet = Integer.valueOf(asignacion[0].trim());
                    codigo_horario = Integer.valueOf(asignacion[1].trim());
                    zona = Integer.valueOf(asignacion[2].trim());
                    nota_final = Integer.valueOf(asignacion[3].trim());
                    // Insertando a su horario
                    if(!estructuras.Estructuras.b_horarios.esVacio()){
                        if(estructuras.Estructuras.b_horarios.buscarPorParametro(codigo_horario) != null){
                            if(estructuras.Estructuras.th_estudiantes.getTamano() > 0){
                                if(estructuras.Estructuras.th_estudiantes.buscar(carnet) != null){
                                    if(estructuras.Estructuras.b_horarios.
                                    buscarPorParametro(codigo_horario).getAsignaciones() == null){
                                        ListaS lista_asignaciones_temporales = new ListaS();

                                        lista_asignaciones_temporales.insertar(new NodoS(
                                        new Asignacion(carnet, codigo_horario, zona, nota_final), 
                                        estructuras.Estructuras.th_estudiantes.buscar(carnet)));

                                        estructuras.Estructuras.b_horarios.
                                        buscarPorParametro(codigo_horario).
                                        setAsignaciones(lista_asignaciones_temporales);
                                    }else{
                                        estructuras.Estructuras.b_horarios.
                                        buscarPorParametro(codigo_horario).
                                        getAsignaciones().insertar(new NodoS(
                                        new Asignacion(carnet, codigo_horario, zona, nota_final),
                                        estructuras.Estructuras.th_estudiantes.buscar(carnet)));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "¡No se pudo asignar"
                                    + ", no existe el carnet: " + carnet + "!", 
                                    "Atencion", JOptionPane.WARNING_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "¡No se han cargado los estudiantes!", 
                                "Atencion", JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No se pudo asignar"
                            + ", no existe horario con codigo: " + codigo_horario + "!", 
                            "Atencion", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡No se han cargado los horarios!", 
                        "Atencion", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if(!estructuras.Estructuras.th_estudiantes.esVacia()){
                System.out.println("Se insertaron " + estructuras.Estructuras.
                th_estudiantes.getTamano() + ", estudiantes.");
                estructuras.Estructuras.th_estudiantes.mostrar();
//            estructuras.Estructuras.th_estudiantes.graficar("grafo");
            }else{
                System.out.println("No se insertaron estudiantes.");
            }
            if(!estructuras.Estructuras.ldo_usuarios.esVacia()){
                System.out.println("Se insertaron " + estructuras.Estructuras.
                ldo_usuarios.getTamano() + ", usuarios.");
//            estructuras.Estructuras.ldo_usuarios.graficar("grafo");
            }else{
                System.out.println("No se insertaron usuarios.");
            }
            if(!estructuras.Estructuras.avl_catedraticos.esVacio()){
                System.out.println("Se insertaron " + estructuras.Estructuras.
                avl_catedraticos.getTamano() + ", catedraticos.");
//            estructuras.Estructuras.avl_catedraticos.graficar("grafo");
            }else{
                System.out.println("No se insertaron catedraticos.");
            }
            if(!estructuras.Estructuras.ldc_edificios.esVacia()){
                System.out.println("Se insertaron " + estructuras.Estructuras.
                ldc_edificios.getTamano() + ", edificios.");
//            estructuras.Estructuras.ldc_edificios.graficar("grafo");
            }else{
                System.out.println("No se insertaron edificios.");
            }
            if(!estructuras.Estructuras.lso_cursos.esVacia()){
                System.out.println("Se insertaron " + estructuras.Estructuras.
                lso_cursos.getTamano() + ", cursos.");
//            estructuras.Estructuras.lso_cursos.graficar("grafo");
            }else{
                System.out.println("No se insertaron cursos.");
            }
            if(!estructuras.Estructuras.b_horarios.esVacio()){
//            System.out.println("Se insertaron " + estructuras.Estructuras.
//            b_horarios.getTamano() + ", cursos.");
//            estructuras.Estructuras.b_horarios.graficar("grafo");
            }

// ..................... Fin contenido archivo ..................... 
            
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
