package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import model.Settings;

public class ConnectionDB {
    private static String databaseName = "jdbc:postgresql://localhost/" + Settings.DATABASE_NAME;
    private static String user = Settings.USER;
    private static String password = Settings.PASSWORD;
    private static Connection connection;

    // Public Method to create connection
    public static Connection createConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                    databaseName, user, password);
                return connection;
            }
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
