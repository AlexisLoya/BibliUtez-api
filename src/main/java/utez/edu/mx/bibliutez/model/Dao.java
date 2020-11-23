package utez.edu.mx.bibliutez.model;

import utez.edu.mx.bibliutez.services.general.ConnectionMySQL;

import java.sql.*;
import java.util.ResourceBundle;

public abstract class Dao {

    protected ResourceBundle sqlSentences;
    protected Connection connection;
    protected ResultSet resultSet;
    protected PreparedStatement preparedStatement;
    protected boolean status;

    protected Dao() {
        this.status = false;
    }

    /*
     * Inicia los recursos necesarios para realizar una actividad en base de datos
     *
     * @param databaseActivity sentencia sql guardada en el archivo MySQLRepository.properties
     */
    protected void mySQLRepository(String query) {
        try {
            this.connection = ConnectionMySQL.getConnection();
            this.preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        } catch (Exception e) {
            System.err.println("No se pudieron iniciar los recursos: " + e.getMessage());
        }
    }

    /**
     * Cierra todas las conexiones abiertas
     */
    protected void closeAllConnections() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
            if (this.resultSet != null) {
                this.resultSet.close();
            }
            if (this.preparedStatement != null) {
                this.preparedStatement.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexiones: " + e.getMessage());
        }
    }


}
