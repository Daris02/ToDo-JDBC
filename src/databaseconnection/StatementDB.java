package databaseconnection;

import java.sql.Statement;

public class StatementDB {
    private static Statement statement;
    
    // Public Method to create statement
    public static Statement createStatement() {
        try {
            if (statement == null) {
                statement = ConnectionDB.createConnection().createStatement();
                return statement;
            }
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return statement;
    }
}
