package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    String url = "jdbc:mysql://localhost:3306/payroll_service";

    public Connection establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, "root", "alpha");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
