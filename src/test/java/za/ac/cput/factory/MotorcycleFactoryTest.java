/*  MotorcycleFactoryTest.java
    Factory Test for Motorcycle Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Motorcycle;
import za.ac.cput.domain.VehicleCondition;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleFactoryTest {
    @Test
    void testCreateMotorcycleSuccess() {
        Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Harley-Davidson", "Vittorio Brumotti - Sportster S", VehicleCondition.NEW,
                FuelType.PETROL,"Navy blue", 2022, 0, false);
        System.out.println(motorcycle);
        assertNotNull(motorcycle);
    }

    @Test
    void testCreateMotorcycleFail() {
        Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Harley-Davidson", null, VehicleCondition.NEW,
                FuelType.PETROL,"Navy blue", 2022, 0, false);
        System.out.println(motorcycle);
        assertNotNull(motorcycle, "Value cannot be empty");
    }

    @Test
    void testCreateMotorcycleWithNullValue() {
        Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Harley-Davidson", null, VehicleCondition.NEW,
                FuelType.PETROL,null, 2022, 0, false);
        System.out.println(motorcycle);
        assertNull(motorcycle);
    }
}