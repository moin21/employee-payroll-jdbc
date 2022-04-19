package com.bridgelabz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Statements {
    final static String query = "SELECT * from employee_payroll";
    Connection connection;
    ArrayList<EmployeePayroll> db;

    public Statements(Connection connection) {
        // TODO Auto-generated constructor stub
        this.connection = connection;
    }

    /**
     * Method to read the database and display in console.
     * 1. We create a connection and then create a statement and store the result in ResultSet.
     * We use while next to iterate through the database.
     * We are also adding this to the ArrayList
     */
    public void read() {

        db = EmployeeDatabase.getEmployeeDB();
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                EmployeePayroll employeePayroll = new EmployeePayroll(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8), resultSet.getDouble(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13));
                db.add(employeePayroll);
                System.out.println(employeePayroll);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
