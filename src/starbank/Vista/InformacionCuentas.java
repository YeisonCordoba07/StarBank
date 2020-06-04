/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank.Vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import starbank.Cajero;
import starbank.CuentaCorriente;
import starbank.CuentaDeAhorros;

/**
 *
 * @author YEISON
 */
public class InformacionCuentas extends javax.swing.JFrame {

    /**
     * Creates new form InformacionCuentas
     */
    public static String idCliente;
    public static String tipoCliente;
    private ArrayList<CuentaCorriente> listaCuentaCorriente;
    private ArrayList<CuentaDeAhorros> listaCuentaDeAhorros;
    JPanel panel = new JPanel();

    public InformacionCuentas() {
        initComponents();
        this.setLayout(null);
        this.setBackground(Color.yellow);

        JScrollPane jScrollPane1 = new JScrollPane(panel);
        jScrollPane1.setBounds(50, 100, 570, 380);
        panel.setBackground(Color.gray);
        this.getContentPane().add(jScrollPane1);

        this.idCliente = MenuCliente.idCliente;
        this.tipoCliente = MenuCliente.tipoCliente;

        listaCuentaCorriente = Cajero.cajero.traerCuentasCorrientesCliente(idCliente);
        listaCuentaDeAhorros = Cajero.cajero.traerCuentasDeAhorrosCliente(idCliente);

        asignaBotonesCuentaCorriente();
        asignaBotonesCuentaDeAhorros();

    }

    public void asignaBotonesCuentaCorriente() {
        for (int i = 0; i < listaCuentaCorriente.size(); i++) {
            JButton botonCuentas = new JButton(listaCuentaCorriente.get(i).getIdCuenta());
            panel.add(botonCuentas);
        }
    }

    public void asignaBotonesCuentaDeAhorros() {
        for (int i = 0; i < listaCuentaDeAhorros.size(); i++) {
            JButton botonCuentas = new JButton(listaCuentaDeAhorros.get(i).getIdCuenta());
            panel.add(botonCuentas);
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

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setText("Informacion Cuentas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(468, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InformacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}