/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;
import Connections.ConnectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionSQL {
    public static Connection CON = null;
    public static ResultSet RESULT = null;
    

    public static Connection getConnectionSQL() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        ConnectionSQL.CON = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=basesAvanzadasCentral;user=sa;password=Abcd1234");
        return CON;
    }
    
    public static ResultSet createConsult(String query) throws ClassNotFoundException {

        try {
            Connection con = getConnectionSQL();
            RESULT = con.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(String.valueOf(ex));
        }
        return RESULT;
    }
    
}

