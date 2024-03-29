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
public class AmountOffice extends javax.swing.JFrame {

    /**
     * Creates new form AmountOffice
     */
    public AmountOffice() {
        initComponents();
    }
    private ResultSet resultFromQuery;
    private int count;
    
    public void loadDataOffices(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        DefaultTableModel amountsHeredia = (DefaultTableModel) amountOfficeTable.getModel();
        amountsHeredia.setRowCount(0);
        
        DefaultTableModel amountsCartago = (DefaultTableModel) amountOfficeTable.getModel();
        amountsCartago.setRowCount(0);
        
        DefaultTableModel amountsSanJose = (DefaultTableModel) amountOfficeTable.getModel();
        amountsSanJose.setRowCount(0);
        try {
            resultFromQuery = AddDataProcedures.consultAmountOfficeHeredia(initialDate, finalDate);
            Vector dataOfficeAmountHeredia = new Vector();
            dataOfficeAmountHeredia.add("Heredia");
            while(resultFromQuery.next()){
                dataOfficeAmountHeredia.add(resultFromQuery.getFloat(1));                
            }
            amountsHeredia.addRow(dataOfficeAmountHeredia);
            amountOfficeTable.setModel(amountsHeredia);
            
            resultFromQuery = AddDataProcedures.consultAmountOfficeCartago(initialDate, finalDate);
            Vector dataOfficeAmountCartago = new Vector();
            dataOfficeAmountCartago.add("Cartago");
            while(resultFromQuery.next()){
            dataOfficeAmountCartago.add(resultFromQuery.getFloat(1));
            }
            amountsCartago.addRow(dataOfficeAmountCartago);
            amountOfficeTable.setModel(amountsCartago);
            
            resultFromQuery = AddDataProcedures.consultAmountOfficeSanJose(initialDate, finalDate);
            Vector dataOfficeAmountSanJose = new Vector();
            dataOfficeAmountSanJose.add("San Jose");
            while(resultFromQuery.next()){
            dataOfficeAmountSanJose.add(resultFromQuery.getFloat(1));
            }
            amountsSanJose.addRow(dataOfficeAmountSanJose);
            amountOfficeTable.setModel(amountsSanJose);
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
        amountOfficeBack = new javax.swing.JButton();
        initialYear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        initialMonth = new javax.swing.JTextField();
        finalYear = new javax.swing.JTextField();
        finalMonth = new javax.swing.JTextField();
        initialDay = new javax.swing.JTextField();
        finalDay = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        amountOfficeTable = new javax.swing.JTable();
        amountOfficeConsult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Amount per Office");

        jLabel2.setText("Date 01:");

        jLabel3.setText("Date 02:");

        amountOfficeBack.setText("Back");
        amountOfficeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountOfficeBackActionPerformed(evt);
            }
        });

        initialYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialYearActionPerformed(evt);
            }
        });

        jLabel4.setText("Year");

        jLabel5.setText("Month");

        jLabel6.setText("Day");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(initialYear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(finalYear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(amountOfficeBack))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(initialMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(2, 2, 2)))
                                    .addComponent(finalMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(initialDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel6))
                                    .addComponent(finalDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(initialYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initialMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initialDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(finalYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountOfficeBack)
                    .addComponent(finalDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        amountOfficeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(amountOfficeTable);
        if (amountOfficeTable.getColumnModel().getColumnCount() > 0) {
            amountOfficeTable.getColumnModel().getColumn(1).setHeaderValue("Amount");
        }

        amountOfficeConsult.setText("Consult");
        amountOfficeConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountOfficeConsultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(amountOfficeConsult))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(amountOfficeConsult)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountOfficeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountOfficeBackActionPerformed
        // TODO add your handling code here:
        ManagerModule managerModule = new ManagerModule();
        managerModule.setVisible(true);
        managerModule.setLocationRelativeTo(null);
        managerModule.setDefaultCloseOperation(ManagerModule.HIDE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_amountOfficeBackActionPerformed

    private void initialYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialYearActionPerformed

    private void amountOfficeConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountOfficeConsultActionPerformed
 
        if (initialYear.getText().isEmpty() || initialMonth.getText().isEmpty() || initialDay.getText().isEmpty()
                || finalYear.getText().isEmpty() || finalMonth.getText().isEmpty() || finalDay.getText().isEmpty())
               {
            
            JOptionPane.showMessageDialog(this, "Complete all the fields please");
        } else {
            try {
                String initialDate = initialYear.getText() + "-" + initialMonth.getText() + "-" + initialDay.getText();
                String finalDate = finalYear.getText() + "-" + finalMonth.getText() + "-" + finalDay.getText();
                try {
                    loadDataOffices(initialDate, finalDate);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TopClients.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Amount in the specified period!");
            }catch (SQLException e) {
           JOptionPane.showMessageDialog(this, "Data not typed correctly");
        } 
        }        // TODO add your handling code here:
    }//GEN-LAST:event_amountOfficeConsultActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amountOfficeBack;
    private javax.swing.JButton amountOfficeConsult;
    private javax.swing.JTable amountOfficeTable;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
