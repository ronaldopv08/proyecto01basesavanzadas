
package Connections;
import Connections.AddDataProcedures;
import Connections.ConnectionSQL;
import  java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Andrés Pérez Bonilla
 */
public class AddDataProcedures {
    
    private static ResultSet resultFromQuery;
    
    public static ResultSet verifiedEmployee(String userEmployee, String passwordEmployee, String typeEmployee) throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec verifyUserEmployee "+userEmployee+","+passwordEmployee+","+typeEmployee+";");
        return resultFromQuery;
    }
    
    public static ResultSet verifiedContact(String userEmployee, String passwordEmployee) throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec verifyUserContact "+userEmployee+","+passwordEmployee+";");
        return resultFromQuery;
    }
    
    public static void registerOrderSanJose(int orderType, int employeeID, int clientID) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarPedidoSanJose(?,?,?)}");
        entry.setInt(1, orderType);
        entry.setInt(2, employeeID);
        entry.setInt(3, clientID);
        entry.execute();    
    }
    
    public static void registerOrderCartago(int orderType, int employeeID, int clientID) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarPedidoCartago(?,?,?)}");
        entry.setInt(1, orderType);
        entry.setInt(2, employeeID);
        entry.setInt(3, clientID);
        entry.execute();    
    }
    public static void registerOrderHeredia(int orderType, int employeeID, int clientID) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarPedidoHeredia(?,?,?)}");
        entry.setInt(1, orderType);
        entry.setInt(2, employeeID);
        entry.setInt(3, clientID);
        entry.execute();    
    }
    public static void registerMedicineOrderSanJose(int medicineID, int quantity) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarPedidoSanJose(?,?)}");
        entry.setInt(1, medicineID);
        entry.setInt(2, quantity);
        entry.execute();    
    }
    public static void registerMedicineOrderCartago(int medicineID, int quantity) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarPedidoCartago(?,?)}");
        entry.setInt(1, medicineID);
        entry.setInt(2, quantity);
        entry.execute();    
    }
    public static void registerMedicineOrderHeredia(int medicineID, int quantity) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarPedidoHeredia(?,?)}");
        entry.setInt(1, medicineID);
        entry.setInt(2, quantity);
        entry.execute();    
    }
    
    //Methods to call procedure associated with administrator consults
    //Procedure one
    public static void consultAmountCartagoDrugStore() throws SQLException, ClassNotFoundException {
        CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaAdministradorMontoSucursalCartago()}");
        entry.execute();    
    }
    public static void consultAmountSanJoseDrugStore() throws SQLException, ClassNotFoundException {
        CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaAdministradorMontoSucursalSanJose()}");
        entry.execute();    
    }
    
    //Procedure two
    public static void consultAdministratorQuantityOrdersCartagoDrugStore(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaAdministradorCantidadPedidosCartago(?,?)}");
        entry.setString(1, initialDate);
        entry.setString(2, finalDate);
        entry.execute();    
    }
    public static void consultAdministratorQuantityOrdersSanJoseDrugStore(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaAdministradorCantidadPedidosSanJose(?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.execute();    
    }
    
    //Procedure three  montoPedidoPorTipoYMesCartago(@mes int, @tipoPedido int)
    public static void consultAdministratorAmountPerTypeMonthSanJose(int month, int orderType)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaAdministradorCantidadPedidosSanJose(?,?)}");
       entry.setInt(1, month);
       entry.setInt(2, orderType);
       entry.execute();    
    }
    public static void consultAdministratorAmountPerTypeMonthCartago(int month, int orderType)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaAdministradorCantidadPedidosCartago(?,?)}");
       entry.setInt(1, month);
       entry.setInt(2, orderType);
       entry.execute();    
    }
    
//Methods to call procedure associated with Manager consults
    //Procedure one
    public static void consultAmountOfficeHeredia(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaMontoGerentePeriodoHeredia(?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.execute();    
    }
    public static void consultAmountOfficeCartago(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaMontoGerentePeriodoCartago(?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.execute();    
    }
    public static void consultAmountOfficeSanJose(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaMontoGerentePeriodoSanJose(?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.execute();    
    }
    //Procedure two
    public static void consultAmountOfficeTypeOrderHeredia(String initialDate, String finalDate, int orderType)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaGerenteMontoSucursalTipoPedidoHeredia(?,?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.setInt(3, orderType);
       entry.execute();    
    }
    public static void consultAmountOfficeTypeOrderCartago(String initialDate, String finalDate, int orderType)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaGerenteMontoSucursalTipoPedidoCartago(?,?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.setInt(3, orderType);
       entry.execute();    
    }
    public static void consultAmountOfficeTypeOrderSanJose(String initialDate, String finalDate, int orderType)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call consultaGerenteMontoSucursalTipoPedidoSanJose(?,?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.setInt(3, orderType);
       entry.execute();    
    }
    
    //Procedure Three
    public static void consultTopClients(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
       CallableStatement entry = 
       ConnectionSQL.getConnectionSQL().prepareCall("{call mejoresTresClientes(?,?)}");
       entry.setString(1, initialDate);
       entry.setString(2, finalDate);
       entry.execute();    
    }
    
}
