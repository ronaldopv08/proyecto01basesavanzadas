
package Connections;
import Connections.AddDataProcedures;
import  java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Andrés Pérez Bonilla
 */
public class AddDataProcedures {
    public static void registerOrder(String a) throws SQLException, ClassNotFoundException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ingresarVehiculoEstilo(?)}");
        entrada.setString(1, a);
        entrada.execute();      
    }
    
}
