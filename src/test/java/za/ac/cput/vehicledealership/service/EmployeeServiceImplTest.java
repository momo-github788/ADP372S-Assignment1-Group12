package za.ac.cput.vehicledealership.service;

/*  EmployeeServiceImplTest.java
    Test class for EmployeeServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;
    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static Employee employee = EmployeeFactory.createEmployee(name, "Password123");


    @Order(1)
    @Test
    void create() {
        Employee createdEmployee = employeeService.create(employee);
        assertNotNull(createdEmployee);
        System.out.println("Create: " + createdEmployee);
    }

    @Order(2)
    @Test
    void read() {
        Employee readEmployee = employeeService.read(employee.getEmployeeNumber());
        assertNotNull(readEmployee);
        System.out.println("Read: " + readEmployee);
    }

    @Order(3)
    @Test
    void update() {
        Employee updatedEmployee = new Employee.Builder()
                .copy(employee)
                .setPassword("updatedpassword123")
                .build();

        assertNotNull(employeeService.update(updatedEmployee));
        System.out.println("Update: " + updatedEmployee);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = employeeService.delete(employee.getEmployeeNumber());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(employeeService.getAll());
        assertEquals(1, employeeService.getAll().size());
    }
}