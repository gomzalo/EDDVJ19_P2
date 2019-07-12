/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.colaborador.administradores;

import estructuras.listas.simples.ordenada.NodoSO_C;
import interfaz.colaborador.AreaColaborador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pojos.Curso;

/**
 *
 * @author g
 */
public class Cursos extends javax.swing.JFrame {

    public DefaultListModel<String> listModel;
    
    /**
     * Creates new form Cursos
     */
    public Cursos() {
        // Inicializando el modelo de la JList
        listModel = new DefaultListModel<String>();
        // Llenando el modelo
        if(!estructuras.Estructuras.lso_cursos.esVacia()){
            NodoSO_C auxiliar = estructuras.Estructuras.lso_cursos.getInicio();
            while(auxiliar != null){
                listModel.addElement(String.valueOf(auxiliar.getCurso().getCodigo()));
                auxiliar = auxiliar.getSiguiente();
            }
        }
        initComponents();
        //Agregandolo a la JList
        cursos_list.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cursos_titulo_lb = new javax.swing.JLabel();
        cursos_info_lb = new javax.swing.JLabel();
        graficar_bt = new javax.swing.JButton();
        codigo_lb = new javax.swing.JLabel();
        codigo_txt = new javax.swing.JTextField();
        nombre_lb = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JTextField();
        semestre_lb = new javax.swing.JLabel();
        semestre_txt = new javax.swing.JTextField();
        creditos_lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cursos_list = new javax.swing.JList<>();
        crear_bt = new javax.swing.JButton();
        limpiar_bt = new javax.swing.JButton();
        modificar_bt = new javax.swing.JButton();
        eliminar_bt = new javax.swing.JButton();
        volver_bt = new javax.swing.JButton();
        creditos_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cursos");

        cursos_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        cursos_titulo_lb.setText("Administracion de cursos");

        cursos_info_lb.setText("Elige la accion que deseas realizar");

        graficar_bt.setText("Graficar");
        graficar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficar_btActionPerformed(evt);
            }
        });

        codigo_lb.setText("Codigo");

        codigo_txt.setEditable(false);
        codigo_txt.setToolTipText("");
        codigo_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo_txtActionPerformed(evt);
            }
        });

        nombre_lb.setText("Nombre");

        semestre_lb.setText("Semestre");

        creditos_lb.setText("Creditos");

        cursos_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursos_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cursos_list);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(creditos_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cursos_titulo_lb, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(crear_bt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(limpiar_bt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(codigo_lb)
                                                    .addComponent(semestre_lb)
                                                    .addComponent(nombre_lb)
                                                    .addComponent(nombre_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                    .addComponent(semestre_txt)
                                                    .addComponent(codigo_txt))
                                                .addComponent(creditos_lb))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(modificar_bt)
                                            .addGap(18, 18, 18)
                                            .addComponent(eliminar_bt)
                                            .addGap(32, 59, Short.MAX_VALUE)))))
                            .addGap(28, 28, 28)
                            .addComponent(volver_bt))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cursos_info_lb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(graficar_bt)
                            .addGap(9, 9, 9)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(creditos_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cursos_titulo_lb)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cursos_info_lb)
                        .addComponent(graficar_bt))
                    .addGap(8, 8, 8)
                    .addComponent(codigo_lb)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(codigo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nombre_lb)
                    .addGap(7, 7, 7)
                    .addComponent(nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(semestre_lb)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(semestre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(creditos_lb)
                    .addGap(18, 51, Short.MAX_VALUE)
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
        if(!estructuras.Estructuras.lso_cursos.esVacia()){
            NodoSO_C auxiliar = estructuras.Estructuras.lso_cursos.getInicio();
            while(auxiliar != null){
                listModel.addElement(String.valueOf(auxiliar.getCurso().getCodigo()));
                auxiliar = auxiliar.getSiguiente();
            }
        }
        cursos_list.setModel(listModel);
    }
    
    public void limpiarTexts(){
        codigo_txt.setText("");
        nombre_txt.setText("");
        semestre_txt.setText("");
        creditos_txt.setText("");
    }
    
    private void graficar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficar_btActionPerformed
        // TODO add your handling code here:
        if(!estructuras.Estructuras.lso_cursos.esVacia()){
            try {
                estructuras.Estructuras.lso_cursos.graficar("grafo");
            } catch (IOException ex) {
                Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Se grafico la lista simple ordenada de cursos.",
                "Muy bien", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "¡No se han cargado cursos",
                "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_graficar_btActionPerformed

    private void codigo_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo_txtActionPerformed

    private void cursos_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursos_listMouseClicked
        // TODO add your handling code here:
        int codigo_seleccionado = 0;
        String codigo_sel = this.cursos_list.getSelectedValue();
        //        System.out.println("ID seleccionado: " + id_sel);
        codigo_seleccionado = Integer.parseInt(codigo_sel);
        codigo_txt.setText(String.valueOf(estructuras.Estructuras.lso_cursos.
        buscarNodo(codigo_seleccionado).getCurso().getCodigo()));
        nombre_txt.setText(estructuras.Estructuras.lso_cursos.
        buscarNodo(codigo_seleccionado).getCurso().getNombre());
        semestre_txt.setText(String.valueOf(estructuras.Estructuras.lso_cursos.
        buscarNodo(codigo_seleccionado).getCurso().getSemestre()));
        creditos_txt.setText(String.valueOf(estructuras.Estructuras.lso_cursos.
        buscarNodo(codigo_seleccionado).getCurso().getCreditos()));
    }//GEN-LAST:event_cursos_listMouseClicked

    private void crear_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_btActionPerformed
        // TODO add your handling code here:
        if(!codigo_txt.getText().isEmpty() || !semestre_txt.getText().isEmpty() 
        || !nombre_txt.getText().isEmpty() || !creditos_txt.getText().isEmpty()){
            if(!estructuras.Estructuras.lso_cursos.buscar(Integer.parseInt(codigo_txt.getText()))){
                estructuras.Estructuras.lso_cursos.insertar(new NodoSO_C(
                new Curso(Integer.parseInt(codigo_txt.getText()), nombre_txt.getText()
                , Integer.parseInt(semestre_txt.getText()), Integer.parseInt(creditos_txt.getText()))));
                
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente "
                + "el curso con codigo: "
                + codigo_txt.getText() + ".",
                "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "No se ingreso el curso con codigo: "
                    + codigo_txt.getText() + ", porque ya existe otro curso con este codigo.",
                    "Atencion", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "¡Hay campos vacios",
                "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
        codigo_txt.setEditable(false);
    }//GEN-LAST:event_crear_btActionPerformed

    private void limpiar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_btActionPerformed
        // TODO add your handling code here:
        codigo_txt.setEditable(true);
        limpiarTexts();
    }//GEN-LAST:event_limpiar_btActionPerformed

    private void modificar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_btActionPerformed
        // TODO add your handling code here:
        if(estructuras.Estructuras.lso_cursos.modificar(Integer.parseInt(
        codigo_txt.getText()), nombre_txt.getText(), 
        Integer.parseInt(semestre_txt.getText()), Integer.parseInt(creditos_txt.getText()))){
            
            JOptionPane.showMessageDialog(null, "Se ha modificado el curso con codigo: "
            + codigo_txt.getText(),
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexts();
        }else{
            JOptionPane.showMessageDialog(null, "¡No se pudo modificar el curso con codigo: "
            + codigo_txt.getText() + "!",
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
    }//GEN-LAST:event_modificar_btActionPerformed

    private void eliminar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btActionPerformed
        // TODO add your handling code here:
        if(estructuras.Estructuras.lso_cursos.eliminar(Integer.parseInt(
            codigo_txt.getText()))){
            JOptionPane.showMessageDialog(null, "Se ha eliminado el curso con codigo: "
            + codigo_txt.getText(),
            "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexts();
        }else{
            JOptionPane.showMessageDialog(null, "¡No se pudo eliminar el curso con codigo: "
            + codigo_txt.getText() + "!",
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
        actualizarList();
    }//GEN-LAST:event_eliminar_btActionPerformed

    private void volver_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AreaColaborador().setVisible(true);
    }//GEN-LAST:event_volver_btActionPerformed

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
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigo_lb;
    private javax.swing.JTextField codigo_txt;
    private javax.swing.JButton crear_bt;
    private javax.swing.JLabel creditos_lb;
    private javax.swing.JTextField creditos_txt;
    private javax.swing.JLabel cursos_info_lb;
    public javax.swing.JList<String> cursos_list;
    private javax.swing.JLabel cursos_titulo_lb;
    private javax.swing.JButton eliminar_bt;
    private javax.swing.JButton graficar_bt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_bt;
    private javax.swing.JButton modificar_bt;
    private javax.swing.JLabel nombre_lb;
    private javax.swing.JTextField nombre_txt;
    private javax.swing.JLabel semestre_lb;
    private javax.swing.JTextField semestre_txt;
    private javax.swing.JButton volver_bt;
    // End of variables declaration//GEN-END:variables
}