package services;

import java.sql.*;

public class DataBaseService {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "1863";

    Connection connection;
    Statement statement;

    public DataBaseService()  {
        //место для пояснения
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        //место для пояснения
        try {
           connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        if (connection != null){
            System.out.println("Your connecting to database is success!");
        } else{
            System.out.println("Something wrong!");
        }
    }

    public  void closeConnection(){
        try {
            connection.close();
            System.out.println("Your connection was successfully broken");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        if (statement == null){
            try {
                statement = this.connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }

    public void executeSQL(String sql){
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public ResultSet executeQuery(String sql){
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
