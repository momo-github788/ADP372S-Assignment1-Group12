package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeFactoryTest {


    @Test
    void testCreateEmployeeSuccess() {
        Name name = NameFactory.createName("Mary", "", "Anne");
        Employee employee = EmployeeFactory.createEmployee(name, "Password123");
        Contact contact = ContactFactory.createContact(ContactType.MOBILE, "+27732889902");

        EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(employee.getEmployeeNumber(), contact.getContactId());

        System.out.println(employeeContact);
        System.out.println(employee);
        System.out.println(contact);
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