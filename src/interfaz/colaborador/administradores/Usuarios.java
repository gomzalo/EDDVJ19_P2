/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.colaborador.administradores;


import estructuras.Estructuras;
import estructuras.listas.dobles.ordenada.NodoDO_U;
import interfaz.colaborador.AreaColaborador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import pojos.Usuario;

/**
 *
 * @author g
 */
public class Usuarios extends javax.swing.JFrame {

    public DefaultListModel<String> listModel;
    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        
        // Inicializando el modelo de la JList
        listModel = new DefaultListModel<String>();
        // Llenando el modelo
        if(!estructuras.Estructuras.ldo_usuarios.esVacia()){
            NodoDO_U auxiliar = estructuras.Estructuras.ldo_usuarios.getInicio();
            while(auxiliar != null){
                listModel.addElement(String.valueOf(auxiliar.getUsuario().getId()));
                auxiliar = auxiliar.getSiguiente();
            }
        }
        initComponents();
        //Agregandolo a la JList
        usuarios_list.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        usuarios_list = new javax.swing.JList<>();
        crear_bt = new javax.swing.JButton();
        modificar_bt = new javax.swing.JButton();
        eliminar_bt = new javax.swing.JButton();
        volver_bt = new javax.swing.JButton();
        usuarios_titulo_lb = new javax.swing.JLabel();
        info_usuarios_lb = new javax.swing.JLabel();
        id_txt = new javax.swing.JTextField();
        nombre_txt = new javax.swing.JTextField();
        contrasena_txt = new javax.swing.JTextField();
        tipo_cb = new javax.swing.JComboBox<>();
        id_lb = new javax.swing.JLabel();
        nombre_lb = new javax.swing.JLabel();
        contrasena_lb = new javax.swing.JLabel();
        tipo_lb = new javax.swing.JLabel();
        graficar_bt = new javax.swing.JButton();
        limpiar_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");

        usuarios_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarios_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usuarios_list);

        crear_bt.setText("Crear");
        crear_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_btActionPerformed(evt);
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

        usuarios_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        usuarios_titulo_lb.setText("Administracion de usuarios");

        info_usuarios_lb.setText("Elige la accion que deseas realizar");

        id_txt.setEditable(false);
        id_txt.setToolTipText("");
        id_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_txtActionPerformed(evt);
            }
        });

        tipo_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "estudiante", "colaborador" }));

        id_lb.setText("ID");

        nombre_lb.setText("Nombre");

        contrasena_lb.setText("Contraseña");

        tipo_lb.setText("Tipo");

        graficar_bt.setText("Graficar");
        graficar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficar_btActionPerformed(evt);
            }
        });

        limpiar_bt.setText("Limpiar");
        limpiar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usuarios_titulo_lb, javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(id_lb)
                                                .addComponent(nombre_lb)
                                                .addComponent(contrasena_lb)
                                                .addComponent(tipo_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(contrasena_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                .addComponent(nombre_txt)
                                                .addComponent(id_txt))
                                            .addComponent(tipo_lb))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(modificar_bt)
                                        .addGap(18, 18, 18)
                                        .addComponent(eliminar_bt)
                                        .addGap(32, 59, Short.MAX_VALUE)))))
                        .addGap(28, 28, 28)
                        .addComponent(volver_bt)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(info_usuarios_lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(graficar_bt)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usuarios_titulo_lb)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info_usuarios_lb)
                    .addComponent(graficar_bt))
                .addGap(8, 8, 8)
                .addComponent(id_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contrasena_lb)
                        .addGap(7, 7, 7)
                        .addComponent(contrasena_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipo_lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipo_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar_bt)
                    .addComponent(eliminar_bt)
                    .addComponent(crear_bt)
                    .addComponent(volver_bt)
                    .addComponent(limpiar_bt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarList(){
        listModel.clear();
        if(!estructuras.Estructuras.ldo_usuarios.esVacia()){
            NodoDO_U auxiliar = estructuras.Estructuras.ldo_usuarios.getInicio();
            while(auxiliar != null){
                listModel.addElement(String.valueOf(auxiliar.getUsuario().getId()));
                auxiliar = auxiliar.getSiguiente();
            }
        }
        usuarios_list.setModel(listModel);
    }
    
    private void volver_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AreaColaborador().setVisible(true);
    }//GEN-LAST:event_volver_btActionPerformed

    private void id_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_txtActionPerformed

    private void usuarios_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarios_listMouseClicked
        // TODO add your handling code here:
        int id_seleccionado = 0;
        String id_sel = this.usuarios_list.getSelectedValue();
//        System.out.println("ID seleccionado: " + id_sel);
        id_seleccionado = Integer.parseInt(id_sel);
        id_txt.setText(String.valueOf(estructuras.Estructuras.ldo_usuarios.
        buscarNodo(id_seleccionado).getUsuario().getId()));
        nombre_txt.setText(estructuras.Estructuras.ldo_usuarios.
        buscarNodo(id_seleccionado).getUsuario().getNombre());
        contrasena_txt.setText(estructuras.Estructuras.ldo_usuarios.
        buscarNodo(id_seleccionado).getUsuario().getContrasena());
        tipo_cb.setSelectedItem(estructuras.Estructuras.ldo_usuarios.
        buscarNodo(id_seleccionado).getUsuario().getTipo());
    }//GEN-LAST:event_usuarios_listMouseClicked

    public void limpiarTexts(){
        id_txt.setText("");
        nombre_txt.setText("");
        contrasena_txt.setText("");
    }
    
    private void modificar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_btActionPerformed
        // TODO add your handling code here:        
        if(estructuras.Estructuras.ldo_usuarios.modificar(Integer.parseInt(
        id_txt.getText()), nombre_txt.getText(), contrasena_txt.getText())){
            if(tipo_cb.getSelectedItem().equals(toString().equalsIgnoreCase("estudiante"))){
                Estructuras.th_estudiantes.buscar(Integer.parseInt(
                id_txt.getText())).setNombre(nombre_txt.getText());
            }
            JOptionPane.showMessageDialog(null, "Se ha modificado el usuario con ID: "
            + id_txt.getText(), 
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexts();
        }else{
            JOptionPane.showMessageDialog(null, "¡No se pudo modificar el usuario con ID: "
            + id_txt.getText() + "!", 
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
    }//GEN-LAST:event_modificar_btActionPerformed

    private void eliminar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btActionPerformed
        // TODO add your handling code here:
        if(estructuras.Estructuras.ldo_usuarios.eliminar(Integer.parseInt(
        id_txt.getText()))){
            JOptionPane.showMessageDialog(null, "Se ha eliminado el usuario con ID: "
            + id_txt.getText(), 
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexts();
        }else{
            JOptionPane.showMessageDialog(null, "¡No se pudo eliminar el usuario con ID: "
            + id_txt.getText() + "!", 
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
    }//GEN-LAST:event_eliminar_btActionPerformed

    private void graficar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficar_btActionPerformed
        // TODO add your handling code here:
        if(!estructuras.Estructuras.ldo_usuarios.esVacia()){
            try {
                estructuras.Estructuras.ldo_usuarios.graficar("grafo");
            } catch (IOException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Se grafico la lista doble de usuarios.", 
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "¡No se han cargado usuarios", 
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_graficar_btActionPerformed

    private void crear_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btActionPerformed
        // TODO add your handling code here:
        if(!id_txt.getText().isEmpty() || !nombre_txt.getText().isEmpty() || !contrasena_txt.getText().isEmpty()){
            if(!estructuras.Estructuras.ldo_usuarios.buscar(Integer.parseInt(id_txt.getText()))){
                if(tipo_cb.getSelectedItem().toString().equalsIgnoreCase("estudiante")){
                    if(Estructuras.th_estudiantes.buscar(Integer.parseInt(id_txt.getText())) != null){
                            estructuras.Estructuras.ldo_usuarios.insertar(new NodoDO_U(new Usuario
                            (Integer.parseInt(id_txt.getText()), nombre_txt.getText(),
                            contrasena_txt.getText(), tipo_cb.getSelectedItem().toString())));
                            JOptionPane.showMessageDialog(null, "Se ingreso correctamente el usuario estudiante con ID: "
                            + id_txt.getText() + ".", 
                            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ingreso el usuario estudiante con ID: "
                        + id_txt.getText() + ", porque no existe en el sistema.", 
                        "Atencion", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    estructuras.Estructuras.ldo_usuarios.insertar(new NodoDO_U(new Usuario
                    (Integer.parseInt(id_txt.getText()), nombre_txt.getText(),
                    contrasena_txt.getText(), tipo_cb.getSelectedItem().toString())));
                    JOptionPane.showMessageDialog(null, "Se ingreso correctamente el usuario colaborador con ID: "
                    + id_txt.getText() + ".", 
                    "Muy bien", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ingreso el usuario con ID: "
                + id_txt.getText() + ", porque ya existe otro usuario con este ID.", 
                "Atencion", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "¡Hay campos vacios", 
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
        id_txt.setEditable(false);
    }//GEN-LAST:event_crear_btActionPerformed

    private void limpiar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_btActionPerformed
        // TODO add your handling code here:
        id_txt.setEditable(true);
        limpiarTexts();
    }//GEN-LAST:event_limpiar_btActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contrasena_lb;
    private javax.swing.JTextField contrasena_txt;
    private javax.swing.JButton crear_bt;
    private javax.swing.JButton eliminar_bt;
    private javax.swing.JButton graficar_bt;
    private javax.swing.JLabel id_lb;
    private javax.swing.JTextField id_txt;
    private javax.swing.JLabel info_usuarios_lb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_bt;
    private javax.swing.JButton modificar_bt;
    private javax.swing.JLabel nombre_lb;
    private javax.swing.JTextField nombre_txt;
    private javax.swing.JComboBox<String> tipo_cb;
    private javax.swing.JLabel tipo_lb;
    public javax.swing.JList<String> usuarios_list;
    private javax.swing.JLabel usuarios_titulo_lb;
    private javax.swing.JButton volver_bt;
    // End of variables declaration//GEN-END:variables
}