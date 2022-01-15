package com.przychodniamk2.business.EmployeeTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.przychodniamk2.business.Employee;
import org.junit.jupiter.api.Test;

class EmployeeTest {
    @Test
    void addition() {
        Employee employee = new Employee("John", "Watson", 4, "gueST");
        assertEquals(Employee.Position.GUEST, employee.getPosition());
    }

}

