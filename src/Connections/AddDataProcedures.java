
package Connections;
import Connections.AddDataProcedures;
import Connections.ConnectionSQL;
import  java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Andrés Pérez Bonilla
 */
public class AddDataProcedures {
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
    
}
