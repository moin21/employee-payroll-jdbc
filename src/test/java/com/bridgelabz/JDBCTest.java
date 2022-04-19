package com.bridgelabz;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class JDBCTest {
    Connection connection;
    Configuration config;
    Statements statement;

    @Before
    public void initialization() {
        Configuration configuration = new Configuration();
        Statements statements = new Statements(configuration.establishConnection());
    }

    /**
     * Test method to check if update by statement is successful.
     */
    @Test
    public void whenUpdatedUsingStatement_shouldReturnTrue() {
        statement.retrievePayroll();
        statement.updatePayroll();

        assertEquals(statement.updatePayroll(), true);
    }

    /**
     * Test method to check if update by prepared statement is successful.
     */
    @Test
    public void whenUpdatedUsingPreparedStatement_shouldReturnTrue() {
        statement.retrievePayroll();
        statement.updatePayroll();

        assertEquals(statement.updateByPreparedStatement(), true);
    }
}
