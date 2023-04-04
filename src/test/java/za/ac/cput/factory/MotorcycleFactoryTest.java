/*  MotorcycleFactoryTest.java
    Factory Test for Motorcycle Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Motorcycle;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleFactoryTest {
    @Test
    void testCreateMotorcycleSuccess() {
        Motorcycle motorcycle1 = MotorcycleFactory.createMotorcycle(true);
        System.out.println(motorcycle1);
        assertNotNull(motorcycle1);

        Motorcycle motorcycle2 = MotorcycleFactory.createMotorcycle(false);
        System.out.println(motorcycle2);
        assertNotNull(motorcycle2);
    }
}