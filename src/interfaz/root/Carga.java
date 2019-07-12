/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.root;

import archivos.Lectura;
import interfaz.Login;
import interfaz.colaborador.AreaColaborador;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author g
 */
public class Carga extends javax.swing.JFrame {

    /**
     * Creates new form Carga
     */
    public Carga() {
        initComponents();
    }

     // File Chooser
    String directorio_archivos = "/home/g/Escritorio/Archivos de entrada";
    final JFileChooser fc = new JFileChooser(directorio_archivos);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carga_titulo_lb = new javax.swing.JLabel();
        info_carga_lb = new javax.swing.JLabel();
        cargar_bt = new javax.swing.JButton();
        graficas_cb = new javax.swing.JComboBox<>();
        graficar_bt = new javax.swing.JButton();
        info_grafica_lb = new javax.swing.JLabel();
        cerrar_sesion_bt = new javax.swing.JButton();
        ir_area_colaborador_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Carga");

        carga_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        carga_titulo_lb.setText("Carga de archivos");

        info_carga_lb.setText("Selecciona el archivo que contiene los datos necesarios");

        cargar_bt.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        cargar_bt.setText("Cargar");
        cargar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_btActionPerformed(evt);
            }
        });

        graficas_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiantes", "Usuarios", "Catedraticos", "Edificios", "Cursos", "Horarios" }));

        graficar_bt.setText("Graficar");
        graficar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficar_btActionPerformed(evt);
            }
        });

        info_grafica_lb.setText("Elige la grafica que deseas visualizar");

        cerrar_sesion_bt.setText("Cerrar sesion");
        cerrar_sesion_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_sesion_btActionPerformed(evt);
            }
        });

        ir_area_colaborador_bt.setText("Ir a area de colaborador");
        ir_area_colaborador_bt.setToolTipText("");
        ir_area_colaborador_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_area_colaborador_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ir_area_colaborador_bt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrar_sesion_bt)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(info_grafica_lb)
                            .addComponent(cargar_bt)
                            .addComponent(info_carga_lb)
                            .addComponent(carga_titulo_lb)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(graficas_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(graficar_bt)))
                        .addContainerGap(61, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carga_titulo_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(info_carga_lb)
                .addGap(29, 29, 29)
                .addComponent(cargar_bt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(info_grafica_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graficas_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(graficar_bt))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar_sesion_bt)
                    .addComponent(ir_area_colaborador_bt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_btActionPerformed
        // TODO add your handling code here:
            fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt", "texto"));
            int valor = fc.showOpenDialog(null);
            if(valor == JFileChooser.APPROVE_OPTION){
                File archivo = fc.getSelectedFile();
                String ruta = archivo.getAbsolutePath();
//                System.out.println(ruta);
                try {
                    Lectura.Leer(ruta);
                    JOptionPane.showMessageDialog(null, "Se ha terminado de leer el archivo.", 
                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            JOptionPane.showMessageDialog(null, "Ya se han cargado las capas", 
//            "Atencion", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_cargar_btActionPerformed

    private void graficar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficar_btActionPerformed
        // TODO add your handling code here:
        String grafica_elegida = graficas_cb.getSelectedItem().toString();
        // Estudiantes, Usuarios, Catedraticos, Edificios, Cursos, Horarios
        switch(grafica_elegida){
            case("Estudiantes"):
                if(!estructuras.Estructuras.th_estudiantes.esVacia()){
                    try {
                        estructuras.Estructuras.th_estudiantes.graficar("grafo");
                        JOptionPane.showMessageDialog(null, "Se grafico la tabla hash, de estudiantes.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se han cargado los estudiantes", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case("Usuarios"):
                if(!estructuras.Estructuras.ldo_usuarios.esVacia()){
                    try {
                        estructuras.Estructuras.ldo_usuarios.graficar("grafo");
                        JOptionPane.showMessageDialog(null, "Se grafico la lista doble ordenada, de usuarios.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se han cargado los usuarios", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case("Catedraticos"):
                if(!estructuras.Estructuras.avl_catedraticos.esVacio()){
                    try {
                        estructuras.Estructuras.avl_catedraticos.graficar("grafo");
                        JOptionPane.showMessageDialog(null, "Se grafico el arbol avl, de catedraticos.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se han cargado los catedraticos", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case("Edificios"):
                if(!estructuras.Estructuras.ldc_edificios.esVacia()){
                    try {
                        estructuras.Estructuras.ldc_edificios.graficar("grafo");
                        JOptionPane.showMessageDialog(null, "Se grafico la lista doble circular, de edificios.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se han cargado los edificios", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case("Cursos"):
                if(!estructuras.Estructuras.lso_cursos.esVacia()){
                    try {
                        estructuras.Estructuras.lso_cursos.graficar("grafo");
                        JOptionPane.showMessageDialog(null, "Se grafico la lista simple ordenada, de cursos.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se han cargado los cursos", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case("Horarios"):
                if(!estructuras.Estructuras.b_horarios.esVacio()){
                    try {
                        estructuras.Estructuras.b_horarios.graficar("grafo");
                        JOptionPane.showMessageDialog(null, "Se grafico el arbol b, de horarios.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se han cargado los horarios", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }//GEN-LAST:event_graficar_btActionPerformed

    private void cerrar_sesion_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_sesion_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_cerrar_sesion_btActionPerformed

    private void ir_area_colaborador_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_area_colaborador_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AreaColaborador().setVisible(true);
    }//GEN-LAST:event_ir_area_colaborador_btActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carga_titulo_lb;
    private javax.swing.JButton cargar_bt;
    private javax.swing.JButton cerrar_sesion_bt;
    private javax.swing.JButton graficar_bt;
    private javax.swing.JComboBox<String> graficas_cb;
    private javax.swing.JLabel info_carga_lb;
    private javax.swing.JLabel info_grafica_lb;
    private javax.swing.JButton ir_area_colaborador_bt;
    // End of variables declaration//GEN-END:variables
}
