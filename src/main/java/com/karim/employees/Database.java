package com.karim.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    static String user = "root";
    static String password = "admin";
    static String url = "jdbc:mysql://localhost/employees";
    static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
