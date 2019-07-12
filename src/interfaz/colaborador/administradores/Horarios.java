/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.colaborador.administradores;

import estructuras.arboles.avl.subestructura.cola.ColaAVL;
import estructuras.listas.dobles.circular.NodoDC_E;
import estructuras.listas.simples.ordenada.NodoSO_C;
import estructuras.listas.simples.ordenada.NodoSO_S;
import interfaz.colaborador.AreaColaborador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.Horario;

/**
 *
 * @author g
 */
public class Horarios extends javax.swing.JFrame {

    /**
     * Creates new form Horarios
     */
    public Horarios() {
        initComponents();
        llenarCBs();
    }
    
    public void llenarCBs(){
        if(!estructuras.Estructuras.lso_cursos.esVacia()){
            NodoSO_C auxiliar = estructuras.Estructuras.lso_cursos.getInicio();
            while(auxiliar != null){
                codigo_curso_cb.addItem(String.valueOf(auxiliar.getCurso().getCodigo()));
                auxiliar = auxiliar.getSiguiente();
            }
        }
        if(!estructuras.Estructuras.ldc_edificios.esVacia()){
            codigo_edificio_cb.addItem(String.valueOf(estructuras.Estructuras.
            ldc_edificios.getInicio().getEdificio().getNombre()));
            NodoDC_E auxiliar = estructuras.Estructuras.ldc_edificios.getInicio().getSiguiente();
            while(auxiliar != estructuras.Estructuras.ldc_edificios.getInicio()){
                codigo_edificio_cb.addItem(String.valueOf(auxiliar.getEdificio().getNombre()));
                auxiliar = auxiliar.getSiguiente();
            }
        }
        if(!estructuras.Estructuras.avl_catedraticos.esVacio()){
            ColaAVL cola_auxiliar = estructuras.Estructuras.avl_catedraticos.listar();
            int tamano_cola = estructuras.Estructuras.avl_catedraticos.listar().getTamano();
            for(int i = 0; i < tamano_cola; i++){
                id_catedratico_cb.addItem(String.valueOf(cola_auxiliar.desencolar()
                .getCatedratico().getId()));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        horario_titulo_lb = new javax.swing.JLabel();
        horario_info_lb = new javax.swing.JLabel();
        graficar_bt = new javax.swing.JButton();
        codigo_curso_lb = new javax.swing.JLabel();
        codigo_txt = new javax.swing.JTextField();
        periodo_lb = new javax.swing.JLabel();
        dia_lb = new javax.swing.JLabel();
        periodo_txt = new javax.swing.JTextField();
        dia_cb = new javax.swing.JComboBox<>();
        codigo_curso_cb = new javax.swing.JComboBox<>();
        id_catedratico_cb = new javax.swing.JComboBox<>();
        codigo_edificio_cb = new javax.swing.JComboBox<>();
        codigo_salon_cb = new javax.swing.JComboBox<>();
        codigo_lb1 = new javax.swing.JLabel();
        codigo_salon_lb = new javax.swing.JLabel();
        id_catedratico_lb = new javax.swing.JLabel();
        codigo_edificio_lb = new javax.swing.JLabel();
        agregar_bt = new javax.swing.JButton();
        volver_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Horarios");

        horario_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        horario_titulo_lb.setText("Administracion de horarios");

        horario_info_lb.setText("Elige la accion que deseas realizar");

        graficar_bt.setText("Graficar");
        graficar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficar_btActionPerformed(evt);
            }
        });

        codigo_curso_lb.setText("Codigo curso");

        periodo_lb.setText("Periodo");

        dia_lb.setText("Dia");

        dia_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" }));

        codigo_salon_cb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codigo_salon_cbMouseClicked(evt);
            }
        });

        codigo_lb1.setText("Codigo");

        codigo_salon_lb.setText("Codigo salon");

        id_catedratico_lb.setText("ID catedratico");

        codigo_edificio_lb.setText("Codigo edificio");

        agregar_bt.setText("Agregar");
        agregar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_btActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(horario_info_lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(graficar_bt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregar_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codigo_lb1)
                                    .addComponent(dia_lb)
                                    .addComponent(periodo_lb))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_catedratico_lb)
                            .addComponent(id_catedratico_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigo_curso_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigo_curso_lb)
                            .addComponent(codigo_salon_lb)
                            .addComponent(codigo_edificio_lb)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volver_bt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(horario_titulo_lb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dia_cb, javax.swing.GroupLayout.Alignment.LEADING, 0, 205, Short.MAX_VALUE)
                            .addComponent(periodo_txt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigo_salon_cb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigo_edificio_cb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(horario_titulo_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horario_info_lb)
                    .addComponent(graficar_bt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_curso_lb)
                    .addComponent(codigo_lb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_curso_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodo_lb)
                    .addComponent(codigo_edificio_lb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_edificio_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dia_lb)
                    .addComponent(codigo_salon_lb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dia_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_salon_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_catedratico_lb)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_catedratico_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar_bt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(volver_bt)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigo_salon_cbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codigo_salon_cbMouseClicked
        // TODO add your handling code here:
        codigo_salon_cb.removeAllItems();
        String nombre_seleccionado = codigo_edificio_cb.getSelectedItem().toString();
        
        try {
            if(!estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_seleccionado).
            getSalones().esVacia() 
            || estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_seleccionado).
            getSalones() != null){
                NodoSO_S auxiliar = estructuras.Estructuras.ldc_edificios.
                buscarNodo(nombre_seleccionado).getSalones().getInicio();
                while(auxiliar != null){
                    codigo_salon_cb.addItem(String.valueOf(auxiliar.getSalon().getNumero()));
                    auxiliar = auxiliar.getSiguiente();
                }
            }
            codigo_salon_cb.updateUI();
        } catch (Exception e) {
            System.out.println("No tiene salones");
        }
    }//GEN-LAST:event_codigo_salon_cbMouseClicked

    private void agregar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_btActionPerformed
        // TODO add your handling code here:
        if(!codigo_txt.getText().isEmpty() || !periodo_txt.getText().isEmpty()){
            
            int codigo = Integer.parseInt(codigo_txt.getText());
            String periodo = periodo_txt.getText();
            String dia = dia_cb.getSelectedItem().toString();
            int codigo_curso = Integer.parseInt(codigo_curso_cb.getSelectedItem().toString());
            int codigo_salon = Integer.parseInt(codigo_salon_cb.getSelectedItem().toString());
            String nombre_edificio = codigo_edificio_cb.getSelectedItem().toString();
            int id_catedratico = Integer.parseInt(id_catedratico_cb.getSelectedItem().toString());
            
            if(estructuras.Estructuras.b_horarios.buscarPorParametro(codigo) == null){
                estructuras.Estructuras.b_horarios.Insertar(
                new Horario(codigo, periodo, dia, codigo_curso, codigo_salon, 
                nombre_edificio, id_catedratico), null);
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente el horario con codigo: "
                + codigo_txt.getText() + ".", 
                "Muy bien", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "No se ingreso el horario con codigo: "
                + codigo_txt.getText() + ", porque ya existe otro horario con este codigo.", 
                "Atencion", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "¡Hay campos vacios!",
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_agregar_btActionPerformed

    private void graficar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficar_btActionPerformed
        // TODO add your handling code here:
        if(!estructuras.Estructuras.b_horarios.esVacio()){
            try {
                estructuras.Estructuras.b_horarios.graficar("grafo");
            } catch (IOException ex) {
                Logger.getLogger(Horarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Horarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "¡No se han cargado horarios", 
            "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_graficar_btActionPerformed

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
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Horarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_bt;
    private javax.swing.JComboBox<String> codigo_curso_cb;
    private javax.swing.JLabel codigo_curso_lb;
    private javax.swing.JComboBox<String> codigo_edificio_cb;
    private javax.swing.JLabel codigo_edificio_lb;
    private javax.swing.JLabel codigo_lb1;
    private javax.swing.JComboBox<String> codigo_salon_cb;
    private javax.swing.JLabel codigo_salon_lb;
    private javax.swing.JTextField codigo_txt;
    private javax.swing.JComboBox<String> dia_cb;
    private javax.swing.JLabel dia_lb;
    private javax.swing.JButton graficar_bt;
    private javax.swing.JLabel horario_info_lb;
    private javax.swing.JLabel horario_titulo_lb;
    private javax.swing.JComboBox<String> id_catedratico_cb;
    private javax.swing.JLabel id_catedratico_lb;
    private javax.swing.JLabel periodo_lb;
    private javax.swing.JTextField periodo_txt;
    private javax.swing.JButton volver_bt;
    // End of variables declaration//GEN-END:variables
}