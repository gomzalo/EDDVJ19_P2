/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.estudiante;

import interfaz.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g
 */
public class AreaEstudiante extends javax.swing.JFrame {

    public static int carnet_estudiante;
    /**
     * Creates new form AreaEstudiante
     */
    public AreaEstudiante(String carnet_estudiante) {
        this.carnet_estudiante = Integer.parseInt(carnet_estudiante);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estudiante_titulo_lb = new javax.swing.JLabel();
        estudiante_info_lb = new javax.swing.JLabel();
        ver_cb = new javax.swing.JComboBox<>();
        ver_bt = new javax.swing.JButton();
        ver_lb = new javax.swing.JLabel();
        cerrar_sesion_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        estudiante_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        estudiante_titulo_lb.setText("Bienvenido al area del estudiante");

        estudiante_info_lb.setText("Elige la accion que deseas realizar");

        ver_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clases", "Notas" }));

        ver_bt.setText("Ver");
        ver_bt.setToolTipText("");
        ver_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_btActionPerformed(evt);
            }
        });

        ver_lb.setText("Selecciona la grafica que desees ver");

        cerrar_sesion_bt.setText("Cerrar sesion");
        cerrar_sesion_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_sesion_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrar_sesion_bt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ver_lb)
                                    .addComponent(estudiante_info_lb)
                                    .addComponent(estudiante_titulo_lb))
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ver_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ver_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(estudiante_titulo_lb)
                .addGap(18, 18, 18)
                .addComponent(estudiante_info_lb)
                .addGap(30, 30, 30)
                .addComponent(ver_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ver_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ver_bt))
                .addGap(29, 29, 29)
                .addComponent(cerrar_sesion_bt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrar_sesion_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_sesion_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_cerrar_sesion_btActionPerformed

    private void ver_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_btActionPerformed
        // TODO add your handling code here:
        String grafica_elegida = ver_cb.getSelectedItem().toString();
        
        switch(grafica_elegida){
            case "Clases":
            {
                try {
                    estructuras.Estructuras.graficar("cursos", carnet_estudiante);
                } catch (IOException ex) {
                    Logger.getLogger(AreaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AreaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            case "Notas":
            {
                try {
                    estructuras.Estructuras.graficar("notas",carnet_estudiante);
                } catch (IOException ex) {
                    Logger.getLogger(AreaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AreaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
        }
    }//GEN-LAST:event_ver_btActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AreaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AreaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AreaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AreaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AreaEstudiante().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar_sesion_bt;
    private javax.swing.JLabel estudiante_info_lb;
    private javax.swing.JLabel estudiante_titulo_lb;
    private javax.swing.JButton ver_bt;
    private javax.swing.JComboBox<String> ver_cb;
    private javax.swing.JLabel ver_lb;
    // End of variables declaration//GEN-END:variables
}
