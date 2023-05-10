package za.ac.cput.factory;

/*  NameFactoryTest.java
    Test class for NameFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;
import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    void testCreateNameSuccess() {
        Name name = NameFactory.createNameFactory("John", "Jones", "Doe");
        assertNotNull(name);
    }


    @Test
    void testCreateNameWithNoMiddleName() {
        Name name = NameFactory.createNameFactory("John", "", "Doe");
        assertNull(name);
    }
}