/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.colaborador.administradores;

import estructuras.listas.simples.ordenada.ListaSO_S;
import estructuras.listas.simples.ordenada.NodoSO_S;
import javax.swing.JOptionPane;
import pojos.Salon;

/**
 *
 * @author g
 */
public class Salones extends javax.swing.JFrame {

    public String tipo;
    /**
     * Creates new form Salones
     */
    public Salones(String edificio, int salon, String tipo) {
        initComponents();
        this.tipo = tipo;
        if(!edificio.isEmpty() && salon != 0 && tipo.equalsIgnoreCase("modificar")){
            numero_txt.setText(String.valueOf(estructuras.Estructuras.ldc_edificios.
            buscarNodo(edificio).getSalones().buscarNodo(salon).getSalon().getNumero()));
            nombre_edificio_txt.setText(String.valueOf(estructuras.Estructuras.ldc_edificios.
            buscarNodo(edificio).getSalones().buscarNodo(salon).getSalon().getNombre_edificio()));
            capacidad_txt.setText(String.valueOf(estructuras.Estructuras.ldc_edificios.
            buscarNodo(edificio).getSalones().buscarNodo(salon).getSalon().getCapacidad()));
        }else{
            numero_txt.setEditable(true);
            nombre_edificio_txt.setText(edificio);
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

        salone_titulo_lb = new javax.swing.JLabel();
        salon_info_lb = new javax.swing.JLabel();
        numero_txt = new javax.swing.JTextField();
        numero_lb = new javax.swing.JLabel();
        nombre_edificio_lb = new javax.swing.JLabel();
        nombre_edificio_txt = new javax.swing.JTextField();
        capacidad_lb = new javax.swing.JLabel();
        capacidad_txt = new javax.swing.JTextField();
        listo_bt = new javax.swing.JButton();
        volver_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salones");

        salone_titulo_lb.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        salone_titulo_lb.setText("Administracion de salon");

        salon_info_lb.setText("Elige la accion que deseas realizar");

        numero_txt.setEditable(false);

        numero_lb.setText("Numero");

        nombre_edificio_lb.setText("Nombre edificio");

        nombre_edificio_txt.setEditable(false);

        capacidad_lb.setText("Capacidad");

        listo_bt.setText("Listo");
        listo_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listo_btActionPerformed(evt);
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
                    .addComponent(salone_titulo_lb)
                    .addComponent(salon_info_lb)
                    .addComponent(numero_lb)
                    .addComponent(numero_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_edificio_lb)
                    .addComponent(nombre_edificio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capacidad_lb)
                    .addComponent(capacidad_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listo_bt)
                        .addGap(117, 117, 117)
                        .addComponent(volver_bt)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salone_titulo_lb)
                .addGap(18, 18, 18)
                .addComponent(salon_info_lb)
                .addGap(24, 24, 24)
                .addComponent(numero_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numero_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_edificio_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_edificio_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capacidad_lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capacidad_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listo_bt)
                    .addComponent(volver_bt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listo_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listo_btActionPerformed
        // TODO add your handling code here:
        if(tipo.equalsIgnoreCase("modificar")){
            estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio_txt.getText()).
            getSalones().buscarNodo(Integer.parseInt(numero_txt.getText())).getSalon().
            setCapacidad(Integer.parseInt(capacidad_txt.getText()));
            JOptionPane.showMessageDialog(null, "¡Se ha modificado el salon con numero: "
            + numero_txt.getText() + ", correctamente!", 
            "Atencion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio_txt.getText()).
            getSalones() == null){
                ListaSO_S lista_salones_temp = new ListaSO_S();
                lista_salones_temp.
                insertar(new NodoSO_S(new Salon(Integer.parseInt(numero_txt.getText())
                , nombre_edificio_txt.getText(), Integer.parseInt(capacidad_txt.getText()))));

                estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio_txt.getText()).
                setSalones(lista_salones_temp);
                JOptionPane.showMessageDialog(null, "¡Se ha creado el salon con numero: "
                + numero_txt.getText() + ", correctamente!", 
                "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(!estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio_txt.getText()).
                getSalones().buscar(Integer.parseInt(numero_txt.getText()))){
                    estructuras.Estructuras.ldc_edificios.buscarNodo(nombre_edificio_txt.getText()).
                    getSalones().insertar(new NodoSO_S(new Salon(Integer.parseInt(numero_txt.getText())
                    , nombre_edificio_txt.getText(), Integer.parseInt(capacidad_txt.getText()))));
                    JOptionPane.showMessageDialog(null, "¡Se ha creado el salon con numero: "
                    + numero_txt.getText() + ", correctamente!", 
                    "Atencion", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "¡No se ha creado el salon con numero: "
                    + numero_txt.getText() + ", porque ya existe un salon con este numero!", 
                    "Atencion", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            
        }
    }//GEN-LAST:event_listo_btActionPerformed

    private void volver_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_btActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Edificios().setVisible(true);
    }//GEN-LAST:event_volver_btActionPerformed

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
//            java.util.logging.Logger.getLogger(Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Salones("").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capacidad_lb;
    private javax.swing.JTextField capacidad_txt;
    private javax.swing.JButton listo_bt;
    private javax.swing.JLabel nombre_edificio_lb;
    private javax.swing.JTextField nombre_edificio_txt;
    private javax.swing.JLabel numero_lb;
    private javax.swing.JTextField numero_txt;
    private javax.swing.JLabel salon_info_lb;
    private javax.swing.JLabel salone_titulo_lb;
    private javax.swing.JButton volver_bt;
    // End of variables declaration//GEN-END:variables
}
