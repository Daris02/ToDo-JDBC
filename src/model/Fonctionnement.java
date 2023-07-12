package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class Fonctionnement {
    public static Todo Inseretion(int id,String title,String description, Date deadline, int priority, boolean done){
        ConnecterAuBase db = new ConnecterAuBase();
        Connection connection = db.createConnection();
        try {
            String insert = "INSERT INTO \"todo\" (id,title,description,deadline,priority,done) VALUES (?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(insert);
            stm.setInt(1,id);
            stm.setString(2,title);
            stm.setString(3,description);
            stm.setDate(4, (java.sql.Date) deadline);
            stm.setInt(5,priority);
            stm.setBoolean(6,done);
            int next = stm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Todo findTodoByid(int id){
        ConnecterAuBase db = new ConnecterAuBase();
        Connection connection = db.createConnection();

        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM \"todo\" WHERE id="+id+";";
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                return new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline"),
                        resultSet.getInt("priority"),
                        resultSet.getBoolean("done")
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
