/*  CarFactoryTest.java
    Factory Test for Car Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Car;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    // Creating a successful test
    void testCreateCarSuccess() {
        Car car1 = CarFactory.createCar(true);
        System.out.println(car1);
        assertNotNull(car1);

        Car car2 = CarFactory.createCar(false);
        System.out.println(car2);
        assertNotNull(car2);
    }
}