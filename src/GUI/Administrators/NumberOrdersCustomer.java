/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Administrators;

import Connections.AddDataProcedures;
import Connections.ConnectionSQL;
import GUI.LoginProvince;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class NumberOrdersCustomer extends javax.swing.JFrame {

    /**
     * Creates new form NumberOrdersCustomer
     */
    private ResultSet resultFromQuery;
    private int count;
    public NumberOrdersCustomer() {
        initComponents();
    }

    public void getClientsHeredia(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsHeredia = (DefaultTableModel) customersTable.getModel();
        amountsHeredia.setRowCount(0);

        try {
            resultFromQuery = AddDataProcedures.consultAdministratorQuantityOrdersHerediaDrugStore(initialDate, finalDate);
            Vector dataOfficeAmountHeredia = new Vector();
            while (resultFromQuery.next()) {
                dataOfficeAmountHeredia.add(resultFromQuery.getInt(1));
                dataOfficeAmountHeredia.add(resultFromQuery.getString(2));
                dataOfficeAmountHeredia.add(resultFromQuery.getInt(3));
            }
            amountsHeredia.addRow(dataOfficeAmountHeredia);
            customersTable.setModel(amountsHeredia);
        } catch (SQLException e) {
        }
    }
    
    
    public void getOrdersHeredia(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsHeredia = (DefaultTableModel) ordersTable.getModel();
        amountsHeredia.setRowCount(0);

        try {
            resultFromQuery = ConnectionSQL.
       createConsult("select A.idPedido,C.nombre,A.idContacto,A.fecha from pedidosTotalesTodosDatos "
       + "A join clientesTotalesTodosDatos C on A.idContacto=C.idContacto join farmaciasTotales B "
       + "on A.cedulaJuridica=B.cedulaJuridica and A.estadoPedido=2 and B.idProvincia=4 and A.fecha between '"+initialDate+"' and '"+finalDate+"';");
                    
            Vector dataOfficeAmountHeredia = new Vector();
            while (resultFromQuery.next()) {
                dataOfficeAmountHeredia.add(resultFromQuery.getInt(1));
                dataOfficeAmountHeredia.add(resultFromQuery.getString(2));
                dataOfficeAmountHeredia.add(resultFromQuery.getInt(3));
                dataOfficeAmountHeredia.add(resultFromQuery.getString(3));
            }
            amountsHeredia.addRow(dataOfficeAmountHeredia);
            ordersTable.setModel(amountsHeredia);
        } catch (SQLException e) {
        }
    }
    
    public void getClientsCartago(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsCartago = (DefaultTableModel) customersTable.getModel();
        amountsCartago.setRowCount(0);

        try {
            resultFromQuery = AddDataProcedures.consultAdministratorQuantityOrdersHerediaDrugStore(initialDate, finalDate);
            Vector dataOfficeAmountCartago = new Vector();
            while (resultFromQuery.next()) {
                dataOfficeAmountCartago.add(resultFromQuery.getInt(1));
                dataOfficeAmountCartago.add(resultFromQuery.getString(2));
                dataOfficeAmountCartago.add(resultFromQuery.getInt(3));
            }
            amountsCartago.addRow(dataOfficeAmountCartago);
            customersTable.setModel(amountsCartago);
        } catch (SQLException e) {
        }
    }
    
    public void getOrdersCartago(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsCartago = (DefaultTableModel) ordersTable.getModel();
        amountsCartago.setRowCount(0);

        try {
            resultFromQuery = ConnectionSQL.
       createConsult("select A.idPedido,C.nombre,A.idContacto,A.fecha from pedidosTotalesTodosDatos "
       + "A join clientesTotalesTodosDatos C on A.idContacto=C.idContacto join farmaciasTotales B "
       + "on A.cedulaJuridica=B.cedulaJuridica and A.estadoPedido=2 and B.idProvincia=3 and A.fecha between '"+initialDate+"' and '"+finalDate+"';");
                    
            Vector dataOfficeAmountCartago = new Vector();
            while (resultFromQuery.next()) {
                dataOfficeAmountCartago.add(resultFromQuery.getInt(1));
                dataOfficeAmountCartago.add(resultFromQuery.getString(2));
                dataOfficeAmountCartago.add(resultFromQuery.getInt(3));
                dataOfficeAmountCartago.add(resultFromQuery.getString(3));
            }
            amountsCartago.addRow(dataOfficeAmountCartago);
            ordersTable.setModel(amountsCartago);
        } catch (SQLException e) {
        }
    }
    
    public void getClientsSanJose(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsSanJose = (DefaultTableModel) customersTable.getModel();
        amountsSanJose.setRowCount(0);

        try {
            resultFromQuery = AddDataProcedures.consultAdministratorQuantityOrdersHerediaDrugStore(initialDate, finalDate);
            Vector dataOfficeAmountSanJose = new Vector();
            while (resultFromQuery.next()) {
                dataOfficeAmountSanJose.add(resultFromQuery.getInt(1));
                dataOfficeAmountSanJose.add(resultFromQuery.getString(2));
                dataOfficeAmountSanJose.add(resultFromQuery.getInt(3));
            }
            amountsSanJose.addRow(dataOfficeAmountSanJose);
            customersTable.setModel(amountsSanJose);
        } catch (SQLException e) {
        }
    }
    
    public void getOrdersSanJose(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsSanJose = (DefaultTableModel) ordersTable.getModel();
        amountsSanJose.setRowCount(0);

        try {
            resultFromQuery = ConnectionSQL.
       createConsult("select A.idPedido,C.nombre,A.idContacto,A.fecha from pedidosTotalesTodosDatos "
       + "A join clientesTotalesTodosDatos C on A.idContacto=C.idContacto join farmaciasTotales B "
       + "on A.cedulaJuridica=B.cedulaJuridica and A.estadoPedido=2 and B.idProvincia=1 and A.fecha between '"+initialDate+"' and '"+finalDate+"';");
                    
            Vector dataOfficeAmountSanJose = new Vector();
            while (resultFromQuery.next()) {
                dataOfficeAmountSanJose.add(resultFromQuery.getInt(1));
                dataOfficeAmountSanJose.add(resultFromQuery.getString(2));
                dataOfficeAmountSanJose.add(resultFromQuery.getInt(3));
                dataOfficeAmountSanJose.add(resultFromQuery.getString(4));
            }
            amountsSanJose.addRow(dataOfficeAmountSanJose);
            ordersTable.setModel(amountsSanJose);
        } catch (SQLException e) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        consult = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        initialYear = new javax.swing.JTextField();
        finalYear = new javax.swing.JTextField();
        initialMonth = new javax.swing.JTextField();
        finalMonth = new javax.swing.JTextField();
        initialDay = new javax.swing.JTextField();
        finalDay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Number of Orders per Customer");

        jLabel2.setText("Date 01");

        jLabel3.setText("Date 02");

        consult.setText("Consult");
        consult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultActionPerformed(evt);
            }
        });

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Customer ID", "Customer", "Quantity of Orders"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customersTable);

        jLabel4.setText("Customers");

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order Number", "Client", "Client ID", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ordersTable);
        if (ordersTable.getColumnModel().getColumnCount() > 0) {
            ordersTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setText("Orders");

        jLabel6.setText("Year");

        jLabel7.setText("Month");

        jLabel8.setText("Day");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(finalYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(initialYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(initialMonth)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(finalMonth, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(initialDay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(finalDay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(consult, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING))))))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(initialYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(initialMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(initialDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(back)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(finalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(finalMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(finalDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jLabel4))
                    .addComponent(consult))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        AdministratorModule administratorModule = new AdministratorModule();
        administratorModule.setVisible(true);
        administratorModule.setLocationRelativeTo(null);
        administratorModule.setDefaultCloseOperation(AdministratorModule.HIDE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void consultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultActionPerformed
        if (initialYear.getText().isEmpty() || initialMonth.getText().isEmpty() || initialDay.getText().isEmpty()
                || finalYear.getText().isEmpty() || finalMonth.getText().isEmpty() || finalDay.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Complete all the fields please");
        }
        String initialDate = initialYear.getText() + "-" + initialMonth.getText() + "-" + initialDay.getText();
        String finalDate = finalYear.getText() + "-" + finalMonth.getText() + "-" + finalDay.getText();
        if (LoginProvince.logInProvince == 1) {
            try {
                 getClientsSanJose(initialDate,finalDate);
                 getOrdersSanJose(initialDate,finalDate);
                 
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Validate the data");
                Logger.getLogger(AmountTypeOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (LoginProvince.logInProvince == 3) {
            try {
                getClientsCartago(initialDate,finalDate);
                getOrdersCartago(initialDate,finalDate);
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Validate the data");
                Logger.getLogger(AmountTypeOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (LoginProvince.logInProvince == 4) {
            try {
                getClientsHeredia(initialDate,finalDate);
                getOrdersHeredia(initialDate,finalDate);
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Validate the data");
                Logger.getLogger(AmountTypeOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_consultActionPerformed

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
            java.util.logging.Logger.getLogger(NumberOrdersCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberOrdersCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberOrdersCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberOrdersCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberOrdersCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton consult;
    private javax.swing.JTable customersTable;
    private javax.swing.JTextField finalDay;
    private javax.swing.JTextField finalMonth;
    private javax.swing.JTextField finalYear;
    private javax.swing.JTextField initialDay;
    private javax.swing.JTextField initialMonth;
    private javax.swing.JTextField initialYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable ordersTable;
    // End of variables declaration//GEN-END:variables
}
