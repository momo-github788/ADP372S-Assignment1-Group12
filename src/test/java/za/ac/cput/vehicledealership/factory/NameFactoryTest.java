package za.ac.cput.vehicledealership.factory;

/*  NameFactoryTest.java
    Test class for NameFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.Name;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@Disabled
class NameFactoryTest {

    @Test
    void testCreateNameSuccess() {
        Name name = NameFactory.createName("John", "Jones", "Doe");
        assertNotNull(name);
    }

}