package com.bridgelabz;

import java.sql.SQLException;

/**
 * Class containing logic to establish mysql database connection.
 */
public class EmployeePayrollJDBCMain {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Statements statements = new Statements(configuration.establishConnection());
        statements.read();

    }
}
