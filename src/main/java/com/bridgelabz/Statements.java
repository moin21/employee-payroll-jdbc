package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class containing methods to run specific statements.
 *
 * @author - Moinuddin.
 */
public class Statements {
    /**
     * RETRIEVE_QUERY - String containing query  to retrieve table rows.
     * UPDATE_QUERY - String containing query to update salary.
     * connection - Instance of Connection Interface.
     * payrollArrayList - ArrayList of EmployeePayroll Type.
     */
    public final static String RETRIEVE_QUERY = "SELECT * from employee_payroll";
    public final static String UPDATE_QUERY = "UPDATE employee_payroll SET Salary = 3000000 WHERE name = 'Moinuddin'";
    public final static String PREPARED_UPDATE_QUERY = "UPDATE employee_payroll SET Salary = ? WHERE name = ?;";
    public final static String PREPARED_RETRIEVE_QUERY = "SELECT Name, Start_Date FROM employee_payroll WHERE Start_Date Between CAST(? AS DATE) AND CAST(? AS DATE));";
    Connection connection;
    ArrayList<EmployeePayroll> payrollArrayList;

    /**
     * Constructor
     *
     * @param connection - connection object.
     */
    public Statements(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method to read the database and display in console.
     * Initialized payrollArrayList using getEmployeeDB method from EmployeeDatabase Class.
     * created a Statement object and initialized in try block using createStatement method - statement.
     * Defined ResultSet object using executeQuery on statement.
     * While resultSet.next has value. employeePayroll object will have all column values for each row.
     * Adding the employeePayroll object to payrollArrayList.
     * Printing the arrayList.
     */
    public void retrievePayroll() {

        payrollArrayList = EmployeeDatabase.getEmployeeDB();
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(RETRIEVE_QUERY);

            while (resultSet.next()) {
                EmployeePayroll employeePayroll = new EmployeePayroll(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8), resultSet.getDouble(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13));
                payrollArrayList.add(employeePayroll);
                System.out.println(employeePayroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to update the database using Statement.
     * Initialized payrollArrayList using getEmployeeDB method from EmployeeDatabase Class.
     * created a Statement object and initialized in try block using createStatement method - statement.
     * executing statement using execute method with UPDATE_QUERY as param.
     *
     * @return - boolean value for Test Cases. True when updated value matched.
     */
    public boolean updatePayroll() {

        payrollArrayList = EmployeeDatabase.getEmployeeDB();
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(UPDATE_QUERY);
            for (EmployeePayroll employeePayroll : payrollArrayList) {
                if (employeePayroll.getName().equals("Moinuddin")) {
                    employeePayroll.setSalary(3000000);
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to update the database using Prepared Statement.
     * Initialized payrollArrayList using getEmployeeDB method from EmployeeDatabase Class.
     * created a Prepared Statement object and initialized in try block using prepareStatement method - preparedStatement.
     * Setting expected values using setInt and setString method by passing index and value as arguments.
     * executing prepared statement using execute method.
     * Using for loop to transverse through payrollArrayList. If name matches to passed argument at index 1, set salary to passed argument.
     *
     * @return - boolean value for Test Cases. True when updated value matched.
     */
    public boolean updateByPreparedStatement() {

        payrollArrayList = EmployeeDatabase.getEmployeeDB();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(PREPARED_UPDATE_QUERY);
            preparedStatement.setInt(1, 50000);
            preparedStatement.setString(2, "Moinuddin");
            preparedStatement.execute();

            for (EmployeePayroll employeePayroll : payrollArrayList) {
                if (employeePayroll.getName().equals("Moinuddin")) {
                    employeePayroll.setSalary(50000);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * Method to read the database and display in console.
     * Defined and Initialized String query to get rows with StartDate in specific date range.
     * Initialized payrollArrayList using getEmployeeDB method from EmployeeDatabase Class.
     * created a Statement object and initialized in try block using createStatement method - statement.
     * Defined ResultSet object using executeQuery on statement.
     * While resultSet.next has value. employeePayroll object will have all column values for each row.
     * Adding the employeePayroll object to payrollArrayList.
     * Printing the arrayList.
     *
     * @param date1
     * @param date2
     * @return
     */
    public boolean retrieveEmployeeByStartDate(String date1, String date2) {

        String query = String.format("SELECT * FROM employee_payroll where Start_Date between '%s' AND '%s';", date1, date2);
        payrollArrayList = EmployeeDatabase.getEmployeeDB();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                EmployeePayroll employeePayroll = new EmployeePayroll(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8), resultSet.getDouble(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13));
                payrollArrayList.add(employeePayroll);
                System.out.println(employeePayroll);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}

