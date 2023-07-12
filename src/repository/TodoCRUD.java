package repository;

import java.sql.ResultSet;

import databaseconnection.StatementDB;
import model.Todo;

public class TodoCRUD {
    // Find all task


    // Add new task


    // Find task by id
    public static Todo findUserById(int id) {
        String sql = "SELECT * FROM \"todo\" WHERE id = " + id + ";";
        try {
            ResultSet resultSet = StatementDB.createStatement().executeQuery(sql);
        
            if(resultSet.next()) {
                return new Todo(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getDate("deadline"),
                    resultSet.getInt("priority"),
                    resultSet.getBoolean("done")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Update task by id

    
    // Delete task by id

}
