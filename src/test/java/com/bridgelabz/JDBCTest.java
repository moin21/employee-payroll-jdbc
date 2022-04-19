package com.bridgelabz;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class JDBCTest {
    Connection connection;
    Configuration config;
    Statements statements;

    @Before
    public void initialization() {
        Configuration configuration = new Configuration();
        statements = new Statements(configuration.establishConnection());
    }

    /**
     * Test method to check if update by statement is successful.
     */
    @Test
    public void whenUpdatedUsingStatement_shouldReturnTrue() {
        statements.retrievePayroll();
        statements.updatePayroll();

        assertEquals(statements.updatePayroll(), true);
    }

    /**
     * Test method to check if update by prepared statement is successful.
     */
    @Test
    public void whenUpdatedUsingPreparedStatement_shouldReturnTrue() {
        statements.retrievePayroll();
        statements.updateByPreparedStatement();

        assertEquals(statements.updateByPreparedStatement(), true);
    }
    /**
     * Test method to check if update by prepared statement is successful.
     */
    @Test
    public void whenRetrievedUsingStatement_shouldReturnTrue() {
        statements.retrievePayroll();
        statements.retrieveEmployeeByStartDate("2022-01-01", "2022-03-02");

        assertEquals(statements.retrieveEmployeeByStartDate("2022-01-01", "2022-03-02"), true);
    }
}
