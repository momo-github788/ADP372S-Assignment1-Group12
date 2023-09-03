package za.ac.cput.vehicledealership.service;

/*  EmployeeServiceImplTest.java
    Test class for EmployeeServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.EmployeeRegisterDTO;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {



    @Autowired
    private EmployeeServiceImpl employeeService;


    private static Name name = NameFactory.createName("Mary", "", "Anne");

    private static Employee employee = EmployeeFactory.createEmployee(name, "john@gmail.com", "P@ssword123");
    private EmployeeRegisterDTO request = new EmployeeRegisterDTO(name, employee.getPassword(), employee.getEmailAddress());



    @Order(1)
    @Test
    void create() {
        Employee createdEmployee = employeeService.register(request);
        assertNotNull(createdEmployee);
        employeeService.delete(createdEmployee.getEmployeeNumber());
        System.out.println("Create: " + createdEmployee);
    }

    @Order(3)
    @Test
    void read() {
        Employee createdEmployee = employeeService.register(request);
        Employee readEmployee = employeeService.read(createdEmployee.getEmployeeNumber());

        assertNotNull(readEmployee);
        System.out.println("Read: " + readEmployee);
        employeeService.delete(createdEmployee.getEmployeeNumber());

    }



    @Order(4)
    @Test
    void update() {
        Employee createdEmployee = employeeService.register(request);
        Employee updatedEmployee = new Employee.Builder()
                .copy(createdEmployee)
                .setPassword("updatedpassword123")
                .build();
        System.out.println("Update: " + updatedEmployee);
        assertNotNull(employeeService.update(updatedEmployee));

    }

    @Order(7)
    @Test
    void deleteAll() {
        employeeService.deleteAll();
    }

    @Order(6)
    @Test
    void delete() {
        Employee createdEmployee = employeeService.register(request);
        boolean success = employeeService.delete(createdEmployee.getEmployeeNumber());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(5)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(employeeService.getAll());
    }
}