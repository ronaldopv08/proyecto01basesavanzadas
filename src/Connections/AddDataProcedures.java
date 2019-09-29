
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
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarMedicamentoPedidoSanJose(?,?)}");
        entry.setInt(1, medicineID);
        entry.setInt(2, quantity);
        entry.execute();    
    }
    public static void registerMedicineOrderCartago(int medicineID, int quantity) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarMedicamentoPedidoCartago(?,?)}");
        entry.setInt(1, medicineID);
        entry.setInt(2, quantity);
        entry.execute();    
    }
    public static void registerMedicineOrderHeredia(int medicineID, int quantity) throws SQLException, ClassNotFoundException {
        CallableStatement entry = ConnectionSQL.getConnectionSQL().prepareCall("{call ingresarMedicamentoPedidoHeredia(?,?)}");
        entry.setInt(1, medicineID);
        entry.setInt(2, quantity);
        entry.execute();    
    }
    
    //Methods to call procedure associated with administrator consults
    //Procedure one
    public static double consultAmountSanJoseDrugStore() throws SQLException, ClassNotFoundException {
        ResultSet result = ConnectionSQL.createConsult("exec consultaAdministradorMontoSucursalSanJose;");
        result.next();
        double amount = result.getDouble(1);
        return amount;
    }
    public static double consultAmountCartagoDrugStore() throws SQLException, ClassNotFoundException {
        ResultSet result = ConnectionSQL.createConsult("exec consultaAdministradorMontoSucursalCartago;");
        result.next();
        double amount = result.getDouble(1);
        return amount;
    }
    public static double consultAmountHerediaDrugStore() throws SQLException, ClassNotFoundException {
        ResultSet result = ConnectionSQL.createConsult("exec consultaAdministradorMontoSucursalHeredia;");
        result.next();
        double amount = result.getDouble(1);
        return amount;
    }
    
    //Procedure two
    public static ResultSet consultAdministratorQuantityOrdersCartagoDrugStore(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaAdministradorCantidadPedidosCartago '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;       
    }
    public static ResultSet consultAdministratorQuantityOrdersHerediaDrugStore(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaAdministradorCantidadPedidosHeredia '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;       
    }
    public static ResultSet consultAdministratorQuantityOrdersSanJoseDrugStore(String initialDate, String finalDate)
       throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaAdministradorCantidadPedidosSanJose '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;       
    }
    
    //Procedure three  montoPedidoPorTipoYMesCartago(@mes int, @tipoPedido int)
    public static String consultAdministratorAmountPerTypeMonthSanJose(String month, String orderType)
       throws SQLException, ClassNotFoundException {
        ResultSet result = ConnectionSQL.createConsult("exec montoPedidoPorTipoYMesSanJose "+month+","+orderType);
        result.next();
        String amount = result.getString(1);
        if (amount==null){
            return "0";
        }
        return amount;
    }
    public static String consultAdministratorAmountPerTypeMonthCartago(String month, String orderType)
       throws SQLException, ClassNotFoundException {
        ResultSet result = ConnectionSQL.createConsult("exec montoPedidoPorTipoYMesCartago "+month+","+orderType);
        result.next();
        String amount = result.getString(1);
        if (amount==null){
            return "0";
        }
        return amount;
    }
    public static String consultAdministratorAmountPerTypeMonthHeredia(String month, String orderType)
       throws SQLException, ClassNotFoundException {
        ResultSet result = ConnectionSQL.createConsult("exec montoPedidoPorTipoYMesHeredia "+month+","+orderType);
        result.next();
        String amount = result.getString(1);
        if (amount==null){
            return "0";
        }
        return amount;
    }
    
    public static ResultSet consultAverageAmountOrdersSanJose(String beginDate, String endDate) throws ClassNotFoundException{
        ResultSet result = ConnectionSQL.createConsult("exec consultarMontoPedidosPromedioSanJose '"+beginDate+"','"+endDate+"';");
        return result;
    }
    
    public static ResultSet consultAverageAmountOrdersCartago(String beginDate, String endDate) throws ClassNotFoundException{
        ResultSet result = ConnectionSQL.createConsult("exec consultarMontoPedidosPromedioCartago '"+beginDate+"','"+endDate+"';");
        return result;
    }

    public static ResultSet consultAverageAmountOrdersHeredia(String beginDate, String endDate) throws ClassNotFoundException{
        ResultSet result = ConnectionSQL.createConsult("exec consultarMontoPedidosPromedioHeredia '"+beginDate+"','"+endDate+"';");
        return result;
    }
//Methods to call procedure associated with Manager consults
    //Procedure one
    public static ResultSet consultAmountOfficeHeredia(String initialDate, String finalDate) 
        throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaMontoGerentePeriodoHeredia '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;
    }
    
    public static ResultSet consultAmountOfficeCartago(String initialDate, String finalDate) 
        throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaMontoGerentePeriodoCartago '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;
    }
    
    public static ResultSet consultAmountOfficeSanJose(String initialDate, String finalDate) 
        throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaMontoGerentePeriodoSanJose '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;
    }
    
    //Procedure two   
        public static ResultSet consultAmountOfficeTypeOrderHeredia(String initialDate, String finalDate, int orderType) 
        throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaGerenteMontoSucursalTipoPedidoHeredia '"+initialDate+"','"+finalDate+"','"+orderType+"';");
        return resultFromQuery;
    }
        
        public static ResultSet consultAmountOfficeTypeOrderSanJose(String initialDate, String finalDate, int orderType) 
        throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaGerenteMontoSucursalTipoPedidoSanJose '"+initialDate+"','"+finalDate+"','"+orderType+"';");
        return resultFromQuery;
    }
        
        public static ResultSet consultAmountOfficeTypeOrderCartago(String initialDate, String finalDate, int orderType) 
        throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec consultaGerenteMontoSucursalTipoPedidoCartago '"+initialDate+"','"+finalDate+"','"+orderType+"';");
        return resultFromQuery;
    }
        
    
    //Procedure Three
    public static ResultSet bestClients(String initialDate, String finalDate) throws SQLException, ClassNotFoundException {
        resultFromQuery=ConnectionSQL.createConsult("exec mejoresTresClientes '"+initialDate+"','"+finalDate+"';");
        return resultFromQuery;
    }
    
}
