/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Managers;

import Connections.AddDataProcedures;
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
public class AmountOfficeTypeOrder extends javax.swing.JFrame {

    /**
     * Creates new form AmountOffice
     */
    private ResultSet resultFromQuery;
    private int count;
    public AmountOfficeTypeOrder() {
        initComponents();
    }
    public void loadDataOfficesTypeOrder(String initialDate, String finalDate, int orderType) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsHeredia = (DefaultTableModel) amountTypeTable.getModel();
        amountsHeredia.setRowCount(0);
        
        DefaultTableModel amountsCartago = (DefaultTableModel) amountTypeTable.getModel();
        amountsCartago.setRowCount(0);
        
        DefaultTableModel amountsSanJose = (DefaultTableModel) amountTypeTable.getModel();
        amountsSanJose.setRowCount(0);
        try {
            resultFromQuery = AddDataProcedures.consultAmountOfficeTypeOrderHeredia(initialDate, finalDate, orderType);
            Vector dataOfficeAmountHeredia = new Vector();
            dataOfficeAmountHeredia.add("Heredia");
            while(resultFromQuery.next()){
                dataOfficeAmountHeredia.add(resultFromQuery.getFloat(1));                
            }
            amountsHeredia.addRow(dataOfficeAmountHeredia);
            amountTypeTable.setModel(amountsHeredia);
            
            resultFromQuery = AddDataProcedures.consultAmountOfficeTypeOrderCartago(initialDate, finalDate, orderType);
            Vector dataOfficeAmountCartago = new Vector();
            dataOfficeAmountCartago.add("Cartago");
            while(resultFromQuery.next()){
            dataOfficeAmountCartago.add(resultFromQuery.getFloat(1));
            }
            amountsCartago.addRow(dataOfficeAmountCartago);
            amountTypeTable.setModel(amountsCartago);
            
            resultFromQuery = AddDataProcedures.consultAmountOfficeTypeOrderSanJose(initialDate, finalDate, orderType);
            Vector dataOfficeAmountSanJose = new Vector();
            dataOfficeAmountSanJose.add("San Jose");
            while(resultFromQuery.next()){
            dataOfficeAmountSanJose.add(resultFromQuery.getFloat(1));
            }
            amountsSanJose.addRow(dataOfficeAmountSanJose);
            amountTypeTable.setModel(amountsSanJose);
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
        amountTypeConsult = new javax.swing.JButton();
        amountTypeBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        amountTypeOrder = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        initialYear = new javax.swing.JTextField();
        initialMonth = new javax.swing.JTextField();
        initialDay = new javax.swing.JTextField();
        finalYear = new javax.swing.JTextField();
        finalMonth = new javax.swing.JTextField();
        finalDay = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        amountTypeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Amount per Office and Type of Order");

        jLabel2.setText("Date 01:");

        jLabel3.setText("Date 02:");

        amountTypeConsult.setText("Consult");
        amountTypeConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTypeConsultActionPerformed(evt);
            }
        });

        amountTypeBack.setText("Back");
        amountTypeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTypeBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Typer Order:");

        amountTypeOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Especial", "Regular" }));

        jLabel5.setText("Year");

        jLabel6.setText("Month");

        jLabel7.setText("Day");

        initialYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(amountTypeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finalYear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(initialYear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(initialMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finalMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initialDay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountTypeConsult)
                    .addComponent(amountTypeBack))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7))
                    .addComponent(jLabel1))
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(amountTypeBack)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountTypeConsult)
                            .addComponent(finalDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(initialYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(initialMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(initialDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(finalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(amountTypeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        amountTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Office", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(amountTypeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountTypeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTypeBackActionPerformed
        // TODO add your handling code here:
        ManagerModule managerModule = new ManagerModule();
        managerModule.setVisible(true);
        managerModule.setLocationRelativeTo(null);
        managerModule.setDefaultCloseOperation(ManagerModule.HIDE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_amountTypeBackActionPerformed

    private void initialYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialYearActionPerformed

    private void amountTypeConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTypeConsultActionPerformed
        if (initialYear.getText().isEmpty() || initialMonth.getText().isEmpty() || initialDay.getText().isEmpty()
                || finalYear.getText().isEmpty() || finalMonth.getText().isEmpty() || finalDay.getText().isEmpty()
                || amountTypeOrder.getItemAt(amountTypeOrder.getSelectedIndex()).isEmpty())
               {
            JOptionPane.showMessageDialog(this, "Complete all the fields please");
        } else {
            try {
                String initialDate = initialYear.getText() + "-" + initialMonth.getText() + "-" + initialDay.getText();
                String finalDate = finalYear.getText() + "-" + finalMonth.getText() + "-" + finalDay.getText();
                try {
                    int orderType = amountTypeOrder.getSelectedIndex()+1;
                    loadDataOfficesTypeOrder(initialDate, finalDate, orderType);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TopClients.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Amount in the specified period!");
            }catch (SQLException e) {
           JOptionPane.showMessageDialog(this, "Data not typed correctly");
        } 
        }        // TODO add your handling code here:
    }//GEN-LAST:event_amountTypeConsultActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amountTypeBack;
    private javax.swing.JButton amountTypeConsult;
    private javax.swing.JComboBox<String> amountTypeOrder;
    private javax.swing.JTable amountTypeTable;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
