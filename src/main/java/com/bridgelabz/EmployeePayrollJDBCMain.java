package com.bridgelabz;

import java.sql.SQLException;

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
     * Calling updatePayroll method to update table row.
     */
    public static void main(String[] args) throws SQLException, CustomException {
        Configuration configuration = new Configuration();
        Statements statements = new Statements(configuration.establishConnection());
        statements.retrievePayroll();
        statements.updatePayroll();
        statements.updateByPreparedStatement();
        statements.retrieveEmployeeByStartDate("2022-01-01", "2022-03-02");
    }
}
