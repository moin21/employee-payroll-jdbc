package com.bridgelabz;

import java.util.ArrayList;

public class EmployeeDatabase {
    static ArrayList<EmployeePayroll> employeeDB = new ArrayList<>();

    public static ArrayList<EmployeePayroll> getEmployeeDB() {
        return employeeDB;
    }
}
