/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank.Vista;

import java.awt.Color;
import starbank.Cajero;

/**
 *
 * @author YEISON
 */
public class Retirar extends javax.swing.JFrame {

    /**
     * Creates new form Retirar
     */
    double saldo;
    double porcentajeCobro;
    double cobroRetiro;

    public Retirar() {
        initComponents();
        if (InformacionCuenta.tipoCuenta.equalsIgnoreCase("Corriente"))
        {
            TextFieldSaldo.setText("" + InformacionCuenta.cuentaCorriente.getSaldo());
            this.saldo = InformacionCuenta.cuentaCorriente.getSaldo();
            this.porcentajeCobro = 0.17;
            Cajero.cajero.actulizarCuentaCorriente(InformacionCuenta.cuentaCorriente);
            this.dispose();

        } else if (InformacionCuenta.tipoCuenta.equalsIgnoreCase("DeAhorros")) 
        {
            TextFieldSaldo.setText("" + InformacionCuenta.cuentaDeAhorros.getSaldo());
            this.saldo = InformacionCuenta.cuentaDeAhorros.getSaldo();
            this.porcentajeCobro = 0.2;
            Cajero.cajero.actulizarCuentaDeAhorros(InformacionCuenta.cuentaDeAhorros);
            this.dispose();
        }

        TextFieldSaldo.setText(("" + saldo));
        TextFieldSaldo.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextFieldValorARetirar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BotonVerificar = new javax.swing.JButton();
        LabelVerificar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextFieldCobroRetiro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TextFieldSaldoDespuesDeRetirar = new javax.swing.JTextField();
        BotonRetirar = new javax.swing.JButton();
        LabelError = new javax.swing.JLabel();
        TextFieldSaldo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setText("RETIRAR");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setText("Solo puede retirar mas de 20000 pero el valor tiene que ser multiplo de 10000.");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setText(" La cuenta siempre debe tener minimo 10000.");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel5.setText("La cuenta estará activa cuando reciba una consignacion inicial de 20000.");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel6.setText("Cuenta de ahorro 2%.");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setText("Cuenta corriente 1.7%");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setText("Valor");

        BotonVerificar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        BotonVerificar.setText("Verificar valor");
        BotonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerificarActionPerformed(evt);
            }
        });

        LabelVerificar.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Cobro por retirar");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setText("Saldo despues de retirar");

        BotonRetirar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        BotonRetirar.setText("Retirar");
        BotonRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRetirarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setText("Saldo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addGap(93, 93, 93)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TextFieldValorARetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(BotonVerificar))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(LabelVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(TextFieldCobroRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(25, 25, 25)
                                    .addComponent(TextFieldSaldoDespuesDeRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotonRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(296, 296, 296))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonVerificar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldValorARetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TextFieldCobroRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(TextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(TextFieldSaldoDespuesDeRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(BotonRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Verificar valor
    private void BotonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerificarActionPerformed
        LabelVerificar.setText("");
        LabelError.setText("");
        if (TextFieldValorARetirar.getText().length() > 0)
        {
            if (Cajero.cajero.verificar(Double.parseDouble(TextFieldValorARetirar.getText()), this.saldo, porcentajeCobro)) 
            {
                TextFieldCobroRetiro.setText("" + Double.parseDouble(TextFieldValorARetirar.getText()) * porcentajeCobro);
                TextFieldCobroRetiro.setEnabled(false);

                TextFieldSaldoDespuesDeRetirar.setText("" + (saldo - (Double.parseDouble(TextFieldValorARetirar.getText())
                        + Double.parseDouble(TextFieldCobroRetiro.getText()))));
                TextFieldSaldoDespuesDeRetirar.setEnabled(false);

                LabelVerificar.setForeground(Color.green);
                LabelVerificar.setText("Valor a retirar exitoso");

            } else {
                LabelError.setForeground(Color.red);
                LabelError.setText("Valor a retirar no valido");
            }
        } else {
            LabelError.setForeground(Color.red);
            LabelError.setText("Ingrese valor a retirar");
        }
    }//GEN-LAST:event_BotonVerificarActionPerformed

    private void BotonRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRetirarActionPerformed
        // TODO add your handling code here:
        //LabelVerificar.setText("");
        LabelError.setText("");
        if (TextFieldValorARetirar.getText().length() > 0) 
        {
            if (Cajero.cajero.verificar(Double.parseDouble(TextFieldValorARetirar.getText()), this.saldo, porcentajeCobro)) 
            {
                if (InformacionCuenta.tipoCuenta.equalsIgnoreCase("Corriente"))
                {
                    InformacionCuenta.cuentaCorriente.retirar(Double.parseDouble(TextFieldValorARetirar.getText()));
                    Cajero.cajero.actulizarCuentaCorriente(InformacionCuenta.cuentaCorriente);
                    Cajero.cajero.consigarASucursal(Double.parseDouble(TextFieldValorARetirar.getText())*porcentajeCobro);
                    this.dispose();

                } else if (InformacionCuenta.tipoCuenta.equalsIgnoreCase("DeAhorros"))
                {
                    InformacionCuenta.cuentaDeAhorros.retirar(Double.parseDouble(TextFieldValorARetirar.getText()));
                    Cajero.cajero.actulizarCuentaDeAhorros(InformacionCuenta.cuentaDeAhorros);
                    Cajero.cajero.consigarASucursal(Double.parseDouble(TextFieldValorARetirar.getText())*porcentajeCobro);
                    this.dispose();
                }

                LabelVerificar.setForeground(Color.green);
                LabelVerificar.setText("Valor a retirar exitoso");

            } else {
                LabelError.setForeground(Color.red);
                LabelError.setText("Valor a retirar no valido");
            }
        } else {
            LabelError.setForeground(Color.red);
            LabelError.setText("Ingrese valor a retirar");
        }

    }//GEN-LAST:event_BotonRetirarActionPerformed

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
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retirar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRetirar;
    private javax.swing.JButton BotonVerificar;
    private javax.swing.JLabel LabelError;
    private javax.swing.JLabel LabelVerificar;
    private javax.swing.JTextField TextFieldCobroRetiro;
    private javax.swing.JTextField TextFieldSaldo;
    private javax.swing.JTextField TextFieldSaldoDespuesDeRetirar;
    private javax.swing.JTextField TextFieldValorARetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
