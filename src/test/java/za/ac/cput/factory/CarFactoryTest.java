/*  CarFactoryTest.java
    Factory Test for Car Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Car;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.VehicleCondition;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    void testCreateCarSuccess() {
        Car car = CarFactory.createCar("Ford", "Fiesta", VehicleCondition.DEMO,
                FuelType.ELECTRIC,"White", 2021, 150, true);
        System.out.println(car);
        assertNotNull(car);
    }

    @Test
    void testCreateCarFail() {
        Car car = CarFactory.createCar(null, "Fiesta", VehicleCondition.DEMO,
                FuelType.ELECTRIC,"White", 2021, 150, true);
        System.out.println(car);
        assertNotNull(car, "Value cannot be empty");
    }

    @Test
    void testCreateMotorcycleWithNullValue() {
        Car car = CarFactory.createCar(null, "Fiesta", VehicleCondition.DEMO,
                FuelType.ELECTRIC,"White", 2021, 150, true);
        System.out.println(car);
        assertNull(car);
    }
}