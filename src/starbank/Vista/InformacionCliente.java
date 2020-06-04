/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank.Vista;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import starbank.Cajero;
import starbank.ClienteEmpresa;
import starbank.ClientePersona;

/**
 *
 * @author YEISON
 */
public class InformacionCliente extends javax.swing.JFrame {

    /**
     * Creates new form InformacionCliente
     */
    private static String idCliente;
    private static String tipoCliente;
    private static ClientePersona persona;
    private static ClienteEmpresa empresa;

    DefaultTableModel modelo;
    
    public InformacionCliente() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modelo = (DefaultTableModel) TablaInformacion.getModel();

        this.idCliente = MenuCliente.idCliente;
        this.tipoCliente = MenuCliente.tipoCliente;
        System.out.println("TipoCliente: "+this.tipoCliente + MenuCliente.tipoCliente);
        if (this.tipoCliente.equalsIgnoreCase("Persona")) {
            persona = Cajero.cajero.traerClientePersona(this.idCliente);
            modelo.setValueAt(persona.getId(), 0, 1);
            modelo.setValueAt(persona.getNombre(), 1, 1);
            modelo.setValueAt(persona.getTelefono(), 2, 1);
            modelo.setValueAt(persona.getDireccion(), 3, 1);
            modelo.setValueAt(persona.getOcupacion(), 4, 1);
            modelo.setValueAt(persona.getEstaSuscrito(), 5, 1);
            modelo.setValueAt(persona.getContraseña(), 6, 1);

        } else if (this.tipoCliente.equalsIgnoreCase("Empresa")) {
            empresa = Cajero.cajero.traerClienteEmpresa(this.idCliente);
            modelo.setValueAt(empresa.getId(), 0, 1);
            modelo.setValueAt(empresa.getNombre(), 1, 1);
            modelo.setValueAt(empresa.getTelefono(), 2, 1);
            modelo.setValueAt(empresa.getDireccion(), 3, 1);
            modelo.setValueAt(empresa.getOcupacion(), 4, 1);
            modelo.setValueAt(empresa.getEstaSuscrito(), 5, 1);
            modelo.setValueAt(empresa.getContraseña(), 6, 1);
            modelo.setValueAt(empresa.getNit(), 7, 1);
            modelo.setValueAt(empresa.getNombreEmpresa(), 8, 1);
            modelo.setValueAt(empresa.getSectorComercial(), 9, 1);
        } else {
            System.out.println("ClienteNoEncontrado en InformacionCliente");
        }

        //TablaInformacion.setColumnModel("hola");
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
        LabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInformacion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        LabelTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        LabelTitulo.setText("Informacion del Cliente");

        TablaInformacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TablaInformacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TablaInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ID", null},
                {"Nombre", null},
                {"Telefono", null},
                {"Direccion", null},
                {"Ocupacion", null},
                {"Esta suscrito", null},
                {"Contraseña", null},
                {"Nit", null},
                {"Nombre Empresa", null},
                {"Sector Comercial", null}
            },
            new String [] {
                "Campo", "Informacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaInformacion);
        if (TablaInformacion.getColumnModel().getColumnCount() > 0) {
            TablaInformacion.getColumnModel().getColumn(0).setResizable(false);
            TablaInformacion.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelTitulo)
                        .addGap(131, 131, 131))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LabelTitulo)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JTable TablaInformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
