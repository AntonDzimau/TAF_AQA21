package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBaseService {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "1863";

    Logger logger = LoggerFactory.getLogger(DataBaseService.class);
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
            logger.warn("Your connecting to database is success!");
        } else{
            logger.warn("Something wrong!");
        }
    }

    public  void closeConnection(){
        try {
            connection.close();
            logger.warn("Your connection was successfully broken");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public Statement getStatement() {
        if (statement == null){
            try {
                statement = this.connection.createStatement();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return statement;
    }

    public void executeSQL(String sql){
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            logger.warn(e.getMessage());

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
