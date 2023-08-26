//package za.ac.cput.vehicledealership.factory;
///*  EmployeeContactFactoryTest.java
//    Test class for EmployeeContactFactory
//    Author: George Tapiwa Charimba (220073465)
//    Date: 22 June 2023
//*/
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.vehicledealership.domain.Contact;
//import za.ac.cput.vehicledealership.domain.EmployeeContact;
//import za.ac.cput.vehicledealership.domain.Name;
//import za.ac.cput.vehicledealership.domain.UserContact;
//
//import static org.junit.jupiter.api.Assertions.*;
//@Disabled
//class EmployeeContactFactoryTest {
//    @Test
//    public void testCreateEmployeeContactSuccess(){
//        Contact contact = ContactFactory.createContact("0629390280", "geocharimba@gmail.com");
//        EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(contact);
//        System.out.println(employeeContact);
//        assertNotNull(employeeContact);
//    }
//}