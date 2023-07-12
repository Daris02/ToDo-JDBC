package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import databaseconnection.ConnectionDB;
import databaseconnection.StatementDB;
import model.Todo;

public class TodoCRUD {
    // Find all task
    public static List<Todo> findAllTasks() {
        String sql = "SELECT * FROM \"todo\";";

        List<Todo> allTasks = new ArrayList<>(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            ResultSet resultSet = StatementDB.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                String str = resultSet.getDate("deadline").toString() + " " + resultSet.getTime("deadline").toString();

                allTasks.add(new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        LocalDateTime.parse(str, formatter),
                        resultSet.getInt("priority"),
                        resultSet.getBoolean("done")));
            }
            return allTasks;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Add new task
    public static void addTask(String title, String description, String deadline, int priority) {
        try {
            String sql = "INSERT INTO \"todo\" (title,description,deadline,priority) VALUES ('" + title + "', '"
                    + description + "', '" + deadline + "', " + priority + " );";

            ConnectionDB.createConnection().createStatement().executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Find task by id
    public static Todo findTaskById(int id) {
        String sql = "SELECT * FROM \"todo\" WHERE id = " + id + ";";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            ResultSet resultSet = StatementDB.createStatement().executeQuery(sql);

            if (resultSet.next()) {
                String str = resultSet.getDate("deadline").toString() + " " + resultSet.getTime("deadline").toString();

                return new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        LocalDateTime.parse(str, formatter),
                        resultSet.getInt("priority"),
                        resultSet.getBoolean("done"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update task by id
    public static void updateTaskById(int id, String title, String description, String deadline, int priority, boolean done) {
        try {
            String sql = "UPDATE \"todo\" set title = '" + title.replace("'", "''") 
                    + "', description = '" + description.replace("'", "''") 
                    + "', deadline = '" + deadline
                    + "', priority = " + priority
                    + ", done = " + done
                    + " WHERE id = " + id + ";";

            ConnectionDB.createConnection().createStatement().executeUpdate(sql);

            System.out.println("Update task!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete task by id
    public static void deleteTaskById(int id) {
        String sql = "DELETE FROM \"todo\" WHERE id = " + id + ";";
        try {
            ConnectionDB.createConnection().createStatement().executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
