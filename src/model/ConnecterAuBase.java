package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecterAuBase {
    private String url;
    private String user;
    private String password;

    public ConnecterAuBase(){
        this.url = "jdbc:postgresql://localhost:5432/"+Settings.DATABASE_NAME;
        this.user = Settings.USER;
        this.password = Settings.PASSWORD;
    }

    public Connection createConnection(){
        try{
            Connection connection = DriverManager.getConnection(
                    this.url, this.user, this.password
            );
            return connection;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
