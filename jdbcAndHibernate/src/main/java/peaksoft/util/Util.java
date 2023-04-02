package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String userName = "postgres";
    public static final String password = "nur0880";

    public static Connection connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,userName,password);
            System.out.println("PostgresSQL connected!");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
