package com.bridgelabz;

/**
 * Class containing main method.
 *
 * @author - Moinuddin.
 */
public class EmployeePayrollJDBCMain {

    /**
     * Main method.
     * Created Configuration object - configuration.
     * Created Statements object using configuration.establishConnection method(returns connection) - statements
     * Calling retrievePayroll method for statements object. To print Table rows to console.
     */
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Statements statements = new Statements(configuration.establishConnection());
        statements.retrievePayroll();

    }
}
