/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import estructuras.listas.dobles.ordenada.NodoDO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import pojos.Usuario;

/**
 *
 * @author g
 */
public class Lectura {
    
    public static void Leer(String ruta) throws FileNotFoundException, IOException, InterruptedException{
        
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(ruta);
            sc = new Scanner(inputStream, "UTF-8");
// ..................... Contenido archivo ..................... 
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
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
                    
                    String[] usuario = linea.split(",");
                    id = Integer.valueOf(usuario[0]);
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
                    estructuras.Estructuras.ldo_usuarios.insertar(new NodoDO(new Usuario(id, nombre, contrasena, tipo)));
                }
            }
            estructuras.Estructuras.ldo_usuarios.graficar("grafo");
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
