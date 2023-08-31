/*  CarFactoryTest.java
    Factory Test for Car Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.BodyType;
import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.VehicleCondition;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarFactoryTest {
    @Test
    void testCreateCarSuccess() {

        Car car = CarFactory.createCar("Ford", "Fiesta", VehicleCondition.DEMO,
                FuelType.ELECTRIC,"White", 2021, 150, true, BodyType.HATCHBACK);
        System.out.println(car);
        assertNotNull(car);
    }
}