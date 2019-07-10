/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author g
 */
public class Lectura {
      public static void leerCapas(String ruta) throws FileNotFoundException, IOException, InterruptedException{
        
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(ruta);
            sc = new Scanner(inputStream, "UTF-8");
            String id_capa_aux = "0";
// ..................... Contenido archivo ..................... 
            while (sc.hasNextLine()) {
                /*
                id_capa {
                   x, y, color;
                }
                */
                String linea = sc.nextLine();
                String x = "0";
                String y = "0";
                String color = "";
                if(linea.contains("{")){
                    // id_capa {
                    
                    id_capa_aux = linea.replace("{","");
                    // id_capa 
                    id_capa_aux = id_capa_aux.replace("\\s+","");
                    // id_capa
                    id_capa_aux = id_capa_aux.trim();
                    System.out.println("ID capa: " + id_capa_aux);
                }
                if(linea.contains(";")){
                        String[] coordenada_auxiliar = linea.split(",");
                        x = coordenada_auxiliar[0];
                        x = x.replace("\\s+", "");
                        x = x.trim();
                        y = coordenada_auxiliar[1];
                        y = y.replace("\\s+", "");
                        y = y.trim();
                        color = coordenada_auxiliar[2];
                        color = color.replace(";", "");
                        color = color.trim();
                        
//                        System.out.println("X: " + x + ", Y: " + y + ", Color: " + color);
                }
                if(linea.contains("}")){
                    
//                    capa_auxiliar.graficar("imagen", "grafo", id_capa_aux);
//                    VentanaPrincipal.arbol_binario_capas.buscarNodo(Integer.parseInt(id_capa_aux)).getCapa().graficar("imagen", "grafo", id_capa_aux);
                    id_capa_aux = "0";
//                    break;
                }
            }
// ..................... Fin contenido archivo ..................... 
//            VentanaPrincipal.arbol_binario_capas.graficar("grafo");
            
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
