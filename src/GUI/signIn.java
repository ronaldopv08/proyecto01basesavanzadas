/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Administrators.AdministratorModule;
import GUI.Employees.EmployeeModule;
import GUI.Managers.ManagerModule;
import Connections.ConnectionSQL;
import GUI.Clients.clientModule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class signIn extends javax.swing.JFrame {
    private ResultSet resultFromQuery;
    private int count;

    /**
     * Creates new form signIn
     */
    public signIn() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxUserType = new javax.swing.JComboBox<>();
        logging = new javax.swing.JButton();
        signInPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Password");

        jLabel2.setText("User");

        jLabel3.setText("User type");

        comboBoxUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Client", "Administrator", "Manager", "Employee" }));
        comboBoxUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUserTypeActionPerformed(evt);
            }
        });

        logging.setText("Sign In");
        logging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loggingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 146, Short.MAX_VALUE)
                                .addComponent(logging))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(signInPassword))
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(comboBoxUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logging)
                    .addComponent(signInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loggingActionPerformed
        String typedUserName = user.getText();
        char[] typedPassword = signInPassword.getPassword();
        String typedPasswordS = new String(typedPassword);
        count = 0;
        
        if(typedUserName.length() == 0 ||  typedPasswordS.length() == 0){
            JOptionPane.showMessageDialog(this, "Complete all the fields please.", "Advice", JOptionPane.INFORMATION_MESSAGE);
            user.setText("");
            signInPassword.setText("");
            return;
        }
        
        if ("Client".equals(comboBoxUserType.getItemAt(comboBoxUserType.getSelectedIndex()))){
            int idContact = 0;
            try {
                resultFromQuery = Connections.AddDataProcedures.verifiedContact(typedUserName, typedPasswordS);
                try{
                    while(resultFromQuery.next()){
                        count += 1;
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(this, e, "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
                if (count >= 1){
                    resultFromQuery=ConnectionSQL.createConsult("select * from clientesTotalesTodosDatos A where A.usuario='"+typedUserName+"' and A.contraseña='"+typedPasswordS+"';");
                    while(resultFromQuery.next()){
                        idContact = resultFromQuery.getInt(1);
                    }
                    JOptionPane.showMessageDialog(this, "Successful logging!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                    clientModule clientAccess = new clientModule(idContact);
                    clientAccess.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "User or password not correctly typed!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (SQLException ex) {
                    Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
                }          
        }
        
        if ("Administrator".equals(comboBoxUserType.getItemAt(comboBoxUserType.getSelectedIndex()))){
            int idProvince=0;
            try {
                resultFromQuery = Connections.AddDataProcedures.verifiedEmployee(typedUserName, typedPasswordS,"2");
                try{
                    while(resultFromQuery.next()){
                        count += 1;
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(this, e, "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
                if (count >= 1){
                    resultFromQuery=ConnectionSQL.createConsult("select C.idProvincia from empleadosTotales A join farmaciasTotales B on A.cedulaJuridica=B.cedulaJuridica join provincia C on B.idProvincia=C.idProvincia and A.usuario='"+typedUserName+"' and A.contraseña='"+typedPasswordS+"';");
                    while(resultFromQuery.next()){
                        idProvince = resultFromQuery.getInt(1);
                        LoginProvince.setProvince(idProvince);
                    }
                    JOptionPane.showMessageDialog(this, "Successful logging!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                    AdministratorModule administratorAccess = new AdministratorModule();
                    administratorAccess.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "User or password not correctly typed!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        
        if ("Manager".equals(comboBoxUserType.getItemAt(comboBoxUserType.getSelectedIndex()))){ 
            try {
                resultFromQuery = Connections.AddDataProcedures.verifiedEmployee(typedUserName, typedPasswordS,"3");
                try{
                    while(resultFromQuery.next()){
                        count += 1;
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(this, e, "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
                if (count >= 1){
                    JOptionPane.showMessageDialog(this, "Successful logging!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                    ManagerModule managerAccess = new ManagerModule();
                    managerAccess.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "User or password not correctly typed!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if ("Employee".equals(comboBoxUserType.getItemAt(comboBoxUserType.getSelectedIndex()))){
            int idEmployee=0;
            int idProvince=0;
            try {
                resultFromQuery = Connections.AddDataProcedures.verifiedEmployee(typedUserName, typedPasswordS,"1");
                try{
                    while(resultFromQuery.next()){
                        count += 1;
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(this, e, "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
                if (count >= 1){
                    resultFromQuery=ConnectionSQL.createConsult("select A.cedula from empleadosTotales A where A.usuario='"+typedUserName+"' and A.contraseña='"+typedPasswordS+"';");
                    while(resultFromQuery.next()){
                        idEmployee = resultFromQuery.getInt(1);
                        LoginProvince.setEmployee(idEmployee);
                    }
                    resultFromQuery=ConnectionSQL.createConsult("select C.idProvincia from empleadosTotales A join farmaciasTotales B on A.cedulaJuridica=B.cedulaJuridica join provincia C on B.idProvincia=C.idProvincia and A.usuario='"+typedUserName+"' and A.contraseña='"+typedPasswordS+"';");
                    while(resultFromQuery.next()){
                        idProvince = resultFromQuery.getInt(1);
                        LoginProvince.setProvince(idProvince);
                    }
                    JOptionPane.showMessageDialog(this, "Successful logging!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                    EmployeeModule employeeAccess = new EmployeeModule();
                    employeeAccess.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "User or password not correctly typed!", "Advice", JOptionPane.INFORMATION_MESSAGE);
                }
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(signIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
        

           // TODO add your handling code here:
    }//GEN-LAST:event_loggingActionPerformed

    private void comboBoxUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUserTypeActionPerformed
      
    }//GEN-LAST:event_comboBoxUserTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logging;
    private javax.swing.JPasswordField signInPassword;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
