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

    private static int employeeNumber;


    private static Name name = NameFactory.createName("Mary", "", "Anne");

    private static Employee employee = EmployeeFactory.createEmployee(name, "john@gmail.com", "P@ssword123");

    private static RegisterRequest employeeRegisterRequest = new RegisterRequest(name, employee.getEmailAddress(), employee.getPassword());

    @Order(1)
    @Test
    void create() {
        Employee createdEmployee = authenticationService.registerEmployee(employeeRegisterRequest);
        assertNotNull(createdEmployee);
        System.out.println("Create: " + createdEmployee);
        employeeNumber = createdEmployee.getEmployeeNumber();
    }

    @Order(2)
    @Test
    void read() {
        Employee readEmployee = employeeService.read(employeeNumber);

        assertNotNull(readEmployee);
        System.out.println("Read: " + readEmployee);
    }



    @Order(3)
    @Test
    void update() {
        Name middleName = NameFactory.createName("Michael");

        Employee updatedEmployee = new Employee.Builder()
                .copy(employee)
                .setName(middleName)
                .build();

        updatedEmployee.setEmployeeNumber(employeeNumber);
        System.out.println("Update: " + updatedEmployee);
        assertNotNull(employeeService.update(updatedEmployee));

    }


    @Order(5)
    @Test
    void delete() {
        boolean success = employeeService.delete(employeeNumber);

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(employeeService.getAll());
    }
}