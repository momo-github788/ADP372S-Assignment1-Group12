package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {


    @Test
    void testCreateEmployeeSuccess() {
        Name name = NameFactory.createNameFactory("Mary", "", "Anne");
        Employee employee = EmployeeFactory.createEmployee(name, "password123");

        assertNotNull(employee);
    }


}