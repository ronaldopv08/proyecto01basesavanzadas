/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Clients;

import Connections.ConnectionSQL;
import GUI.signIn;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Andrés Pérez Bonilla
 */
public class clientModule extends javax.swing.JFrame {
    
    private static ResultSet res;

    /**
     * Creates new form clientModule
     */
    public clientModule(int idClient) throws ClassNotFoundException {
        initComponents();
        loadOrdersTable(idClient);
    }

    private clientModule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void loadOrdersTable(int idClient) throws ClassNotFoundException{
        DefaultTableModel model = (DefaultTableModel) orderList.getModel();
        model.setRowCount(0);
        res=ConnectionSQL.createConsult("select * from pedidosTotalesTodosDatos where idContacto="+idClient+";");
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));

                model.addRow(v);
                orderList.setModel(model);
            }
        }catch(SQLException e){
    }
    }
    
    public void loadMedicinesTable(String numberOrder) throws ClassNotFoundException, IOException{
        tableMedicines.getColumn("Image").setCellRenderer(new LabelRenderer()); 
        DefaultTableModel model = (DefaultTableModel) tableMedicines.getModel();
        model.setRowCount(0);
        res=ConnectionSQL.createConsult("select * from medicamento join medicamentoPedidosTotalesTodosDatos on medicamento.idMedicamento=medicamentoPedidosTotalesTodosDatos.idMedicamento and medicamentoPedidosTotalesTodosDatos.idPedido="+numberOrder+";");
        try{
            while(res.next()){
                byte[] fotografiaVehiculo = res.getBytes(4);
                ByteArrayInputStream bis = new ByteArrayInputStream(fotografiaVehiculo);
                BufferedImage bImage2 = ImageIO.read(bis);
                Image foto = bImage2.getScaledInstance(210, 150, Image.SCALE_DEFAULT);
                ImageIcon fotoIcon = new ImageIcon(foto);
                JButton botonImagen = new JButton();
                botonImagen.setIcon(fotoIcon);
                Vector v = new Vector();
                v.add(res.getString(2));
                v.add(botonImagen);
                v.add(res.getInt(12));
                model.addRow(v);
                tableMedicines.setModel(model);
            }
        }catch(SQLException e){
    }
    }
    
    public class LabelRenderer implements TableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus, int row, int column){
            TableColumn tc = tableMedicines.getColumn("Image");
            tc.setMinWidth(210);
            table.setRowHeight(150);
            return (Component) value;
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JTable();
        clientModuleBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        orderNumber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idContact = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        province = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        employeeName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMedicines = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Consult");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        orderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Order number", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderList);

        clientModuleBack.setText("Back");
        clientModuleBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientModuleBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Order number");

        orderNumber.setText("jLabel2");

        jLabel3.setText("Date");

        date.setText("jLabel4");

        jLabel5.setText("Type");

        type.setText("jLabel6");

        jLabel7.setText("Status");

        status.setText("jLabel8");

        jLabel9.setText("Employeer name");

        idContact.setText("jLabel10");

        jLabel11.setText("Contact ID");

        province.setText("jLabel12");

        jLabel13.setText("Province");

        employeeName.setText("jLabel14");

        jLabel15.setText("Medicines");

        jLabel16.setText("Price");

        price.setText("jLabel17");

        tableMedicines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Medicine", "Image", "Unities"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMedicines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMedicinesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMedicines);

        jLabel18.setText("Consult Information About Orders");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clientModuleBack)
                        .addGap(226, 226, 226)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderNumber)
                    .addComponent(date)
                    .addComponent(type)
                    .addComponent(status)
                    .addComponent(idContact)
                    .addComponent(province)
                    .addComponent(employeeName)
                    .addComponent(price))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientModuleBack)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(orderNumber))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(type)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(status))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idContact)
                            .addComponent(jLabel11))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(province)
                    .addComponent(jLabel13))
                .addGap(4, 4, 4)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeName)
                            .addComponent(jLabel9))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(price))
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientModuleBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientModuleBackActionPerformed
        // TODO add your handling code here:
        signIn signInAccess = new signIn();
        signInAccess.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_clientModuleBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row = orderList.getSelectedRow();
        String numberOrder = orderList.getValueAt(row, 0).toString();
        try {
            res = ConnectionSQL.createConsult("select * from pedidosTotalesTodosDatos where idPedido="+numberOrder+";");
            while (res.next()) {
                orderNumber.setText(Integer.toString(res.getInt(1)));
                date.setText(res.getString(2));
                idContact.setText(res.getString(6));
            }
            res=ConnectionSQL.createConsult("select A.* from tipoPedido A inner join pedidosTotalesTodosDatos B on A.idTipoPedido=B.tipoPedido and B.idPedido="+numberOrder+";");
            while (res.next()) {
                type.setText(res.getString(2));
            }
            res=ConnectionSQL.createConsult("select A.* from estadoPedido A join pedidosTotalesTodosDatos B on A.idEstadoPedido=B.estadoPedido and B.idPedido="+numberOrder+";");
            while (res.next()) {
                status.setText(res.getString(2));
            }
            res=ConnectionSQL.createConsult("select sum(A.precio * B.cantidad) from medicamento as A join medicamentoPedidosTotalesTodosDatos as B on A.idMedicamento=B.idMedicamento join pedidosTotalesTodosDatos as C on B.idPedido=C.idPedido and C.idPedido="+numberOrder+";");
            while (res.next()) {
                price.setText("$"+Double.toString(res.getDouble(1)));
            }
            res=ConnectionSQL.createConsult("select A.nombre from empleadosTotales A join pedidosTotalesTodosDatos B on A.cedula=B.cedulaEmpleado and B.idPedido="+numberOrder+";");
            while (res.next()) {
                employeeName.setText(res.getString(1));
            }
            res=ConnectionSQL.createConsult("select C.provincia from farmaciasTotales A join pedidosTotalesTodosDatos B on A.cedulaJuridica=B.cedulaJuridica join provincia C on A.idProvincia=C.idProvincia and B.idPedido="+numberOrder+";");
            while (res.next()) {
                province.setText(res.getString(1));
            }
            loadMedicinesTable(numberOrder);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clientModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(clientModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clientModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMedicinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedicinesMouseClicked
        // TODO add your handling code here:
        int row = tableMedicines.getSelectedRow();
        String medicine = tableMedicines.getValueAt(row, 0).toString();
        try {
            res=ConnectionSQL.createConsult("select A.idMedicamento from medicamento A where A.nombre='"+medicine+"';");
            while (res.next()) {
                MedicineInformation medicineInformation = new MedicineInformation(Integer.toString(res.getInt(1)));
                medicineInformation.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clientModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(clientModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clientModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMedicinesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientModuleBack;
    private javax.swing.JLabel date;
    private javax.swing.JLabel employeeName;
    private javax.swing.JLabel idContact;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderList;
    private javax.swing.JLabel orderNumber;
    private javax.swing.JLabel price;
    private javax.swing.JLabel province;
    private javax.swing.JLabel status;
    private javax.swing.JTable tableMedicines;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}