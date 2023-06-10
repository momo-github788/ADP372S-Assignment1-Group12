package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {


    @Test
    void testCreateEmployeeSuccess() {
        Name name = NameFactory.createName("Mary", "", "Anne");
        Employee employee = EmployeeFactory.createEmployee(name, "Password123");

        assertNotNull(employee);
    }
    @Test
    void testCreateEmployeeWithInvalidPassword() {
        Name name = NameFactory.createName("Mary", "", "Anne");

        // This is an invalid password being used
        Exception exception = assertThrows(RuntimeException.class,
                () ->  EmployeeFactory.createEmployee(name, "password"));
        System.out.println(exception);

        assertTrue(exception.getMessage().contentEquals(
                "Password must contain atleast one uppercase letter, one lowercase letter and one digit."
        ));

    }

}