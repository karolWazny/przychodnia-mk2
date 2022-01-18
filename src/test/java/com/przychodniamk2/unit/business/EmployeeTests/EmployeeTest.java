package com.przychodniamk2.unit.business.EmployeeTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.przychodniamk2.unit.business.Employee;
import org.junit.Test;

public class EmployeeTest {
    @Test
    public void testMethod() {
        Employee employee = new Employee("John", "Watson", 4, "gueST");
        assertEquals(Employee.Position.GUEST, employee.getPosition());
    }
}

