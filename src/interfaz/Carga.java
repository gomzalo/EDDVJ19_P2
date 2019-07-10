/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivos.Lectura;
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
    String directorio_archivos = "/home/g/Escritorio";
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargar_bt)
                    .addComponent(info_carga_lb)
                    .addComponent(carga_titulo_lb))
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addContainerGap(32, Short.MAX_VALUE))
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
    private javax.swing.JLabel info_carga_lb;
    // End of variables declaration//GEN-END:variables
}
