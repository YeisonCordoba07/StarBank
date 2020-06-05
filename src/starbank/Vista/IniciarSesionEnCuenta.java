/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank.Vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import starbank.Cajero;
import starbank.Cuenta;
import starbank.CuentaCorriente;
import starbank.CuentaDeAhorros;

/**
 *
 * @author YEISON
 */
public class IniciarSesionEnCuenta extends javax.swing.JFrame {

    /**
     * Creates new form IniciarSesionEnCuenta
     */
    public static String idCliente;
    public static String tipoCliente;
    public static String idCuenta;
    public static String tipoCuenta;
    private ArrayList<CuentaCorriente> listaCuentaCorriente;
    private ArrayList<CuentaDeAhorros> listaCuentaDeAhorros;
    public static CuentaCorriente cuentaCorriente;
    public static CuentaDeAhorros cuentaDeAhorros;

    DefaultTableModel modelo;

    public IniciarSesionEnCuenta() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setBackground(Color.yellow);

        this.idCliente = MenuCliente.idCliente;
        this.tipoCliente = MenuCliente.tipoCliente;
        listaCuentaCorriente = Cajero.cajero.traerCuentasCorrientesCliente(idCliente);
        listaCuentaDeAhorros = Cajero.cajero.traerCuentasDeAhorrosCliente(idCliente);

        ComboBoxCuentas.addItem("");//Agrega un primer item nulo
        ComboBoxCuentas.setSelectedIndex(0); //selecciona ese primer item nulo
        
        modelo = (DefaultTableModel) TablaCuentas.getModel();
        for (int i = 0; i < listaCuentaCorriente.size(); i++) 
        {
            modelo.addRow(new Object[]{"", ""});//Agrega una nueva fila
            modelo.setValueAt(listaCuentaCorriente.get(i).getIdCuenta(), i, 0);//Agrega el id de la cuenta a la tabla
            ComboBoxCuentas.addItem(listaCuentaCorriente.get(i).getIdCuenta());//Agrega el id de la cuenta al comboBox
        }
        for (int i = 0; i < listaCuentaDeAhorros.size(); i++)
        {
            //Si el numero de filas que hay, no va a alcanzar para agregar todas las cuentas, entonces agrega una nueva fila
            if (modelo.getRowCount() < listaCuentaDeAhorros.size()) 
            {
                modelo.addRow(new Object[]{"", ""});
            }
            modelo.setValueAt(listaCuentaDeAhorros.get(i).getIdCuenta(), i, 1);
            ComboBoxCuentas.addItem(listaCuentaDeAhorros.get(i).getIdCuenta());
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
        jPanel1 = new javax.swing.JPanel();
        ComboBoxCuentas = new javax.swing.JComboBox<>();
        TextFieldContraseña = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCuentas = new javax.swing.JTable();
        LabelError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setText("Informacion Cuentas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        ComboBoxCuentas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        ComboBoxCuentas.setSelectedItem(null);

        TextFieldContraseña.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuentas Corriente", "Cuentas de ahorros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaCuentas);
        if (TablaCuentas.getColumnModel().getColumnCount() > 0) {
            TablaCuentas.getColumnModel().getColumn(0).setResizable(false);
            TablaCuentas.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Selecciones cuenta e ingrese la contraseña de la cuenta");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("La tabla contiene el id de todas sus cuentas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboBoxCuentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldContraseña)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(LabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(126, 126, 126))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(TextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(LabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 272, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 272, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimirListaCorriente();
        boolean esCuentaDeAhorros = false;
        if (ComboBoxCuentas.getSelectedIndex() == 0)
        {
            LabelError.setForeground(Color.red);
            LabelError.setText("Seleccione una cuenta");
        } else {
            if (TextFieldContraseña.getText().length() > 0)
            {
                for (int i = 0; i < listaCuentaCorriente.size(); i++) 
                {
                    if (listaCuentaCorriente.get(i).getIdCuenta().equals(ComboBoxCuentas.getSelectedItem().toString())) 
                    {
                        if (listaCuentaCorriente.get(i).getContraseñaCuenta().equals(TextFieldContraseña.getText())) 
                        {
                            LabelError.setForeground(Color.green);
                            LabelError.setText("Exito corriente");

                            this.idCuenta = ComboBoxCuentas.getSelectedItem().toString();
                            this.tipoCuenta = "Corriente";
                            this.cuentaCorriente = listaCuentaCorriente.get(i);

                            InformacionCuenta informacionCuenta = new InformacionCuenta();
                            informacionCuenta.setVisible(true);
                            this.dispose();


                        } else {
                            LabelError.setForeground(Color.orange);
                            LabelError.setText("Contraseña Incorrecta");
                        }
                        break;
                    } else if (i + 1 == listaCuentaCorriente.size()) {
                        esCuentaDeAhorros = true;
                    }
                }

                if (esCuentaDeAhorros) 
                {
                    for (int i = 0; i < listaCuentaDeAhorros.size(); i++) 
                    {
                        if (this.listaCuentaDeAhorros.get(i).getIdCuenta().equals(ComboBoxCuentas.getSelectedItem().toString()) == true)
                        {
                            if (listaCuentaDeAhorros.get(i).getContraseñaCuenta().equals(TextFieldContraseña.getText())) 
                            {
                                LabelError.setForeground(Color.green);
                                LabelError.setText("Exito de ahorros");

                                this.idCuenta = ComboBoxCuentas.getSelectedItem().toString();
                                this.tipoCuenta = "DeAhorros";
                                cuentaDeAhorros = listaCuentaDeAhorros.get(i);
                                InformacionCuenta informacionCuenta = new InformacionCuenta();
                                informacionCuenta.setVisible(true);
                                this.dispose();

                            } else {
                                LabelError.setForeground(Color.orange);
                                LabelError.setText("Contraseña Incorrecta");
                            }
                            break;
                        } else {
                            if (i + 1 == listaCuentaDeAhorros.size()) {
                                LabelError.setForeground(Color.blue);
                                LabelError.setText("La cuenta no se encuentra");
                            }
                        }
                    }
                }
            } else {
                LabelError.setForeground(Color.red);
                LabelError.setText("Ingrese contraseña");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void imprimirListaCorriente() 
    {
        System.out.println("LISTA CUENTA CORRIENTE");
        for (int i = 0; i < listaCuentaCorriente.size(); i++) 
        {
            System.out.println(listaCuentaCorriente.get(i).getIdCuenta());
        }
        System.out.println("LISTA CUENTA DE AHORROS");
        for (int i = 0; i < listaCuentaDeAhorros.size(); i++) 
        {
            System.out.println(listaCuentaDeAhorros.get(i).getIdCuenta());
        }
        System.out.println("");
        System.out.println("");

    }

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
            java.util.logging.Logger.getLogger(IniciarSesionEnCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionEnCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionEnCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionEnCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesionEnCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCuentas;
    private javax.swing.JLabel LabelError;
    private javax.swing.JTable TablaCuentas;
    private javax.swing.JTextField TextFieldContraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
