/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank.Vista;

import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import starbank.Cajero;
import starbank.ClienteEmpresa;
import starbank.ClientePersona;

/**
 *
 * @author YEISON
 */
public class MenuCliente extends javax.swing.JFrame {

    /**
     * Creates new form InformacionCliente
     */
    public static String idCliente;
    public static String tipoCliente;
    private ClientePersona clientePersona;
    private ClienteEmpresa clienteEmpresa;

    public MenuCliente() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        

        //Comprueba si tiene que ir a MenuStarBank o a CrearCliente por los datos de idCliente y tipoCliente
        if (MenuStarBank.iniciarSesion) 
        {
            this.idCliente = MenuStarBank.idCliente;
            this.tipoCliente = MenuStarBank.tipoCliente;
        } else {
            this.idCliente = CrearCliente.idCliente;
            this.tipoCliente = CrearCliente.tipoCliente;
        }
        traerInformacionCliente();

    }

    
    
    public void traerInformacionCliente() 
    {
        try 
        {
            if (this.tipoCliente.equalsIgnoreCase("Persona"))
            {
                //Busca el cliente en las listas de clientes y trae sus datos
                clientePersona = Cajero.cajero.traerClientePersona(this.idCliente);

                LabelNombreCliente.setText(clientePersona.getNombre());
                LabelIdCliente.setText(clientePersona.getId());

            } else if (tipoCliente.equalsIgnoreCase("Empresa")) {

                clienteEmpresa = Cajero.cajero.traerClienteEmpresa(idCliente);

                LabelNombreCliente.setText(clienteEmpresa.getNombre());
                LabelIdCliente.setText(clienteEmpresa.getId());

            }
        } catch (NullPointerException e) {
            System.out.println("Error en MenuCliente, cliente nullo: " + e);
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

        jPanel1 = new javax.swing.JPanel();
        LabelNombreCliente = new javax.swing.JLabel();
        LabelIdCliente = new javax.swing.JLabel();
        BotonVerInformacionCuentas = new javax.swing.JButton();
        BotonVerInformacionCliente = new javax.swing.JButton();
        BotonCrearCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelNombreCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        LabelNombreCliente.setText("Nombre Cliente");

        LabelIdCliente.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        LabelIdCliente.setText("Id Cliente");

        BotonVerInformacionCuentas.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        BotonVerInformacionCuentas.setText("Ver Informacion Cuentas");
        BotonVerInformacionCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerInformacionCuentasActionPerformed(evt);
            }
        });

        BotonVerInformacionCliente.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        BotonVerInformacionCliente.setText("Ver Informacion Cliente");
        BotonVerInformacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerInformacionClienteActionPerformed(evt);
            }
        });

        BotonCrearCuenta.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        BotonCrearCuenta.setText("Crear Cuenta");
        BotonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(LabelIdCliente)
                            .addGap(321, 321, 321))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelNombreCliente)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotonVerInformacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonVerInformacionCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(145, 145, 145)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LabelNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelIdCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(BotonVerInformacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(BotonVerInformacionCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BotonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
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

    //Mostrar informacion detallada del Cliente
    private void BotonVerInformacionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerInformacionClienteActionPerformed
        // TODO add your handling code here:
        InformacionCliente informacionCliente = new InformacionCliente();
        informacionCliente.setVisible(true);
    }//GEN-LAST:event_BotonVerInformacionClienteActionPerformed

    private void BotonVerInformacionCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerInformacionCuentasActionPerformed
        // TODO add your handling code here:
        IniciarSesionEnCuenta informacionCuentas = new IniciarSesionEnCuenta();
        informacionCuentas.setVisible(true);
        
    }//GEN-LAST:event_BotonVerInformacionCuentasActionPerformed

    private void BotonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearCuentaActionPerformed
        // TODO add your handling code here:
        CrearCuenta crearCuenta = new CrearCuenta();
        crearCuenta.setVisible(true);
    }//GEN-LAST:event_BotonCrearCuentaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrearCuenta;
    private javax.swing.JButton BotonVerInformacionCliente;
    private javax.swing.JButton BotonVerInformacionCuentas;
    private javax.swing.JLabel LabelIdCliente;
    private javax.swing.JLabel LabelNombreCliente;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
