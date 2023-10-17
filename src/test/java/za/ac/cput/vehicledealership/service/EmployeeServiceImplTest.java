package za.ac.cput.vehicledealership.service;

/*  EmployeeServiceImplTest.java
    Test class for EmployeeServiceImpl
    Author:George Tapiwa Charimba (220073465)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.service.impl.AuthenticationService;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private ModelMapper modelMapper;


    private static Name name = NameFactory.createName("Mary", "", "Anne");

    private static Employee employee = EmployeeFactory.createEmployee(name, "john@gmail.com", "P@ssword123");

    private static RegisterRequest employeeRegisterRequest = new RegisterRequest(name, employee.getEmailAddress(), employee.getPassword());

    @Order(1)
    @Test
    void create() {
        Employee createdEmployee = authenticationService.registerEmployee(employeeRegisterRequest);
        assertNotNull(createdEmployee);
        System.out.println("Create: " + createdEmployee);
    }

    @Order(3)
    @Test
    void read() {
        Employee createdEmployee = authenticationService.registerEmployee(employeeRegisterRequest);

        Employee mapped = modelMapper.map(createdEmployee, Employee.class);
        //Employee readEmployee = employeeService.read(mapped.getEmployeeNumber());

        assertNotNull(mapped);
        System.out.println("Read: " + mapped);
        employeeService.delete(employee.getEmployeeNumber());

    }



    @Order(4)
    @Test
    void update() {
        Employee createdEmployee = authenticationService.registerEmployee(employeeRegisterRequest);
        Employee mapped = modelMapper.map(createdEmployee, Employee.class);

        Employee updatedEmployee = new Employee.Builder()
                .copy(mapped)
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
        Employee createdEmployee = authenticationService.registerEmployee(employeeRegisterRequest);

        Employee mapped = modelMapper.map(createdEmployee, Employee.class);

        boolean success = employeeService.delete(mapped.getEmployeeNumber());

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