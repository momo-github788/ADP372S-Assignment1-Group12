package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeFactoryTest {


    @Test
    void testCreateEmployeeSuccess() {
        Name name = NameFactory.createName("Mary", "", "Anne");
        Employee employee = EmployeeFactory.createEmployee(name, "john@gmail.com", "PasswOrd123");
        ContactDetail contact = ContactDetailFactory.createContact(ContactType.MOBILE, "+27732889902");
        System.out.println(employee);
        System.out.println(contact);
        assertNotNull(employee);
    }

    @Test
    void testCreateEmployeeWithInvalidPassword() {
        Name name = NameFactory.createName("Mary", "", "Anne");

        // This is an invalid password being used
        Exception exception = assertThrows(RuntimeException.class,
                () ->  EmployeeFactory.createEmployee(name, "john@gmail.com", "password"));
        System.out.println(exception);

        assertTrue(exception.getMessage().contentEquals(
                "Password must contain at least one uppercase letter, one lowercase letter and one digit."
        ));

    }

}