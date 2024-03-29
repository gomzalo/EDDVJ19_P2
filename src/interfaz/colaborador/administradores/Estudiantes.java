/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.colaborador.administradores;

import interfaz.colaborador.AreaColaborador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pojos.Estudiante;

/**
 *
 * @author g
 */
public class Estudiantes extends javax.swing.JFrame {

    public DefaultListModel<String> listModel;
    
    /**
     * Creates new form Estudiantes
     */
    public Estudiantes() {
        // Inicializando el modelo de la JList
        listModel = new DefaultListModel<String>();
        // Llenando el modelo
        if(!estructuras.Estructuras.th_estudiantes.esVacia()){
            for (Estudiante e : estructuras.Estructuras.th_estudiantes.tabla) {
                if(e != null){
                    listModel.addElement(String.valueOf(e.getCarnet()));
                }
            }
        }
        initComponents();
        //Agregandolo a la JList
        estudiantes_list.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estudiantes_titulo_lb = new javax.swing.JLabel();
        estudiantes_info_lb = new javax.swing.JLabel();
        graficar_bt = new javax.swing.JButton();
        crear_bt = new javax.swing.JButton();
        limpiar_bt = new javax.swing.JButton();
        modificar_bt = new javax.swing.JButton();
        eliminar_bt = new javax.swing.JButton();
        volver_bt = new javax.swing.JButton();
        direccion_txt = new javax.swing.JTextField();
        direccion_lb = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JTextField();
        nombre_lb = new javax.swing.JLabel();
        carnet_txt = new javax.swing.JTextField();
        carnet_lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estudiantes_list = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estudiantes");

        estudiantes_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        estudiantes_titulo_lb.setText("Administracion de estudiantes");

        estudiantes_info_lb.setText("Elige la accion que deseas realizar");

        graficar_bt.setText("Graficar");
        graficar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficar_btActionPerformed(evt);
            }
        });

        crear_bt.setText("Crear");
        crear_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btActionPerformed(evt);
            }
        });

        limpiar_bt.setText("Limpiar");
        limpiar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_btActionPerformed(evt);
            }
        });

        modificar_bt.setText("Modificar");
        modificar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_btActionPerformed(evt);
            }
        });

        eliminar_bt.setText("Eliminar");
        eliminar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_btActionPerformed(evt);
            }
        });

        volver_bt.setText("Volver");
        volver_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver_btActionPerformed(evt);
            }
        });

        direccion_lb.setText("Direccion");

        nombre_lb.setText("Nombre");

        carnet_txt.setEditable(false);
        carnet_txt.setToolTipText("");
        carnet_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnet_txtActionPerformed(evt);
            }
        });

        carnet_lb.setText("Carnet");

        estudiantes_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estudiantes_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(estudiantes_list);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(estudiantes_titulo_lb, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(crear_bt)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(limpiar_bt)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(carnet_lb)
                                                .addComponent(direccion_lb)
                                                .addComponent(nombre_lb)
                                                .addComponent(nombre_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                .addComponent(direccion_txt)
                                                .addComponent(carnet_txt))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(modificar_bt)
                                            .addGap(18, 18, 18)
                                            .addComponent(eliminar_bt)
                                            .addGap(32, 59, Short.MAX_VALUE)))))
                            .addGap(28, 28, 28)
                            .addComponent(volver_bt))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(estudiantes_info_lb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(graficar_bt)
                            .addGap(9, 9, 9)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(estudiantes_titulo_lb)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(estudiantes_info_lb)
                        .addComponent(graficar_bt))
                    .addGap(8, 8, 8)
                    .addComponent(carnet_lb)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(carnet_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombre_lb)
                            .addGap(7, 7, 7)
                            .addComponent(nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(direccion_lb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(direccion_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modificar_bt)
                        .addComponent(eliminar_bt)
                        .addComponent(crear_bt)
                        .addComponent(volver_bt)
                        .addComponent(limpiar_bt))
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarList(){
        listModel.clear();
        if(!estructuras.Estructuras.th_estudiantes.esVacia()){
            for (Estudiante e : estructuras.Estructuras.th_estudiantes.tabla) {
                if(e != null){
                    listModel.addElement(String.valueOf(e.getCarnet()));
                }
            }
        }
        estudiantes_list.setModel(listModel);
    }
    
    public void limpiarTexts(){
        carnet_txt.setText("");
        nombre_txt.setText("");
        direccion_txt.setText("");
    }
    
    private void graficar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficar_btActionPerformed
        // TODO add your handling code here:
        if(!estructuras.Estructuras.th_estudiantes.esVacia()){
            
            try {
                estructuras.Estructuras.th_estudiantes.graficar("grafo");
            } catch (IOException ex) {
                Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "Se grafico la tabla hash de estudiantes.",
                "Muy bien", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "¡No se han cargado estudiantes!",
                "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_graficar_btActionPerformed

    private void crear_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btActionPerformed
        // TODO add your handling code here:
        if(!carnet_txt.getText().isEmpty() || !direccion_txt.getText().isEmpty() || !nombre_txt.getText().isEmpty()){
            if(estructuras.Estructuras.th_estudiantes.
            buscar(Integer.parseInt(carnet_txt.getText())) == null){
                
                estructuras.Estructuras.th_estudiantes.insertar(
                new Estudiante(Integer.parseInt(carnet_txt.getText()),
                nombre_txt.getText(), direccion_txt.getText()));
                
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente el "
                + " estudiante con carnet: " + carnet_txt.getText() + ".",
                "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "No se ingreso el estudiante con carnet: "
                + carnet_txt.getText() + ", porque ya existe otro estudiante con este carnet.",
                "Atencion", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "¡Hay campos vacios!",
                "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
        carnet_txt.setEditable(false);
    }//GEN-LAST:event_crear_btActionPerformed

    private void limpiar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_btActionPerformed
        // TODO add your handling code here:
        carnet_txt.setEditable(true);
        limpiarTexts();
    }//GEN-LAST:event_limpiar_btActionPerformed

    private void modificar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_btActionPerformed
        // TODO add your handling code here:
        if(estructuras.Estructuras.th_estudiantes.modificar(Integer.parseInt(
        carnet_txt.getText()), nombre_txt.getText(), direccion_txt.getText())){
            
//            if(estructuras.Estructuras.ldo_usuarios.buscar(Integer.parseInt(
//            carnet_txt.getText()))){
//                estructuras.Estructuras.ldo_usuarios.buscarNodo(Integer.parseInt(
//                carnet_txt.getText())).getUsuario().setNombre(nombre_txt.getText());
//            }
            
            JOptionPane.showMessageDialog(null, "Se ha modificado el estudiante con carnet: "
            + carnet_txt.getText(),
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexts();
        }else{
            JOptionPane.showMessageDialog(null, "¡No se pudo modificar el estudiante con carnet: "
            + carnet_txt.getText() + "!",
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
    }//GEN-LAST:event_modificar_btActionPerformed

    private void eliminar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btActionPerformed
        // TODO add your handling code here:
        if(estructuras.Estructuras.th_estudiantes.eliminar(Integer.parseInt(
        carnet_txt.getText()))){
            
            if(estructuras.Estructuras.ldo_usuarios.buscar(Integer.parseInt(
            carnet_txt.getText()))){
                estructuras.Estructuras.ldo_usuarios.eliminar(Integer.parseInt(
                carnet_txt.getText()));
            }
            
            JOptionPane.showMessageDialog(null, "Se ha eliminado el estudiante con carnet: "
            + carnet_txt.getText(),
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexts();
        }else{
            JOptionPane.showMessageDialog(null, "¡No se pudo eliminar el estudiante con carnet: "
            + carnet_txt.getText() + "!",
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
    }//GEN-LAST:event_eliminar_btActionPerformed

    private void volver_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AreaColaborador().setVisible(true);
    }//GEN-LAST:event_volver_btActionPerformed

    private void carnet_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnet_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carnet_txtActionPerformed

    private void estudiantes_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estudiantes_listMouseClicked
        // TODO add your handling code here:
        int id_seleccionado = 0;
        String id_sel = this.estudiantes_list.getSelectedValue();
        //        System.out.println("ID seleccionado: " + id_sel);
        id_seleccionado = Integer.parseInt(id_sel);
        carnet_txt.setText(String.valueOf(estructuras.Estructuras.th_estudiantes.
        buscar(id_seleccionado).getCarnet()));
        nombre_txt.setText(estructuras.Estructuras.th_estudiantes.
        buscar(id_seleccionado).getNombre());
        direccion_txt.setText(estructuras.Estructuras.th_estudiantes.
        buscar(id_seleccionado).getDireccion());
    }//GEN-LAST:event_estudiantes_listMouseClicked

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
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carnet_lb;
    private javax.swing.JTextField carnet_txt;
    private javax.swing.JButton crear_bt;
    private javax.swing.JLabel direccion_lb;
    private javax.swing.JTextField direccion_txt;
    private javax.swing.JButton eliminar_bt;
    private javax.swing.JLabel estudiantes_info_lb;
    public javax.swing.JList<String> estudiantes_list;
    private javax.swing.JLabel estudiantes_titulo_lb;
    private javax.swing.JButton graficar_bt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_bt;
    private javax.swing.JButton modificar_bt;
    private javax.swing.JLabel nombre_lb;
    private javax.swing.JTextField nombre_txt;
    private javax.swing.JButton volver_bt;
    // End of variables declaration//GEN-END:variables
}
