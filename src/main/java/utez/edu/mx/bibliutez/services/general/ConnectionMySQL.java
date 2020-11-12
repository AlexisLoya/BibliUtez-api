package utez.edu.mx.bibliutez.services.general;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
    //Lugar de conexión Local
    private static String ipAddress = "localhost";
    //Base de datos
    private static String dbName = "tienda";
    //Usuario en Mysql
    private static String user = "root";
    //Contraseña en Mysql
    private static String password = "root";
    //Puerto
    private static String service = "3306";

    public static Connection getConexion() throws Exception {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        con = DriverManager.getConnection("jdbc:mysql://" + ipAddress + "/" + dbName +
                "?user=" + user + "&password=" + password + "&useSSL=false");
        return con;
    }

    public static void main(String[] args) {
        try {
            ConnectionMySQL c = new ConnectionMySQL();
            Connection con = c.getConexion();
            System.out.println("(^_^) Connection successful ... ");
        } catch (Exception e) {
            System.out.println("(o_O) Conection error ... " + e);
        }
    }

}
