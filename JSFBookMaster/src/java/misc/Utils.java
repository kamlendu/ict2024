
package misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Utils {

    private final static String hostName = "localhost";
    private final static String userName = "root";
    private final static String password = "ompandey";
    private final static String portNo = "3306";
    private final static String dbName = "workshop";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection objConnection = DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + portNo + "/" + dbName, userName, password);
        return objConnection;
    }

    public static ResultSet executeResultSet(Connection objConnection, String strQuery) throws ClassNotFoundException, SQLException {
        if(objConnection == null)
            objConnection = getConnection();
        Statement objStatement = objConnection.createStatement();
        ResultSet objResultSet = objStatement.executeQuery(strQuery);
        return objResultSet;
    }

    public static boolean executeQuery(Connection objConnection, String strQuery) {
        try {
            if(objConnection == null)
                objConnection = getConnection();
            Statement objStatement = objConnection.createStatement();
            objStatement.execute(strQuery);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


       public static PreparedStatement getPreparedStatement(Connection objConnection, String strQuery) throws SQLException {
        if (objConnection != null) {
            return objConnection.prepareStatement(strQuery);
        }
        return null;
    }

}
