package utez.edu.mx.bibliutez.services.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    //Lugar de conexión Local
    private static String ipAddress = "localhost";
    //Base de datos
    private static String dbName = "Bibliutez";
    //Usuario en Mysql
    private static String user = "root";
    //Contraseña en Mysql
    private static String password = "";
    //Puerto
    private static String service = "3306";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(
                "jdbc:mysql://" + ipAddress + ":" + service + "/" + dbName, user, password
        );
    }

    public static void main(String[] args) {
        try {
            Connection con = ConnectionMySQL.getConnection();
            if (con != null) {
                System.out.println("(^_^) Connection successful ...");
            } else {
                System.err.println("(o_O) Connection error ...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
