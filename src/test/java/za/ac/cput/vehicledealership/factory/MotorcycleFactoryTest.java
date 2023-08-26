/*  MotorcycleFactoryTest.java
    Factory Test for Motorcycle Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@Disabled
class MotorcycleFactoryTest {
    @Test
    void testCreateMotorcycleSuccess() {
        Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Harley-Davidson", "Vittorio Brumotti - Sportster S", VehicleCondition.NEW,
                FuelType.PETROL,"Navy blue", 2022, 0, false);
        System.out.println(motorcycle);
        assertNotNull(motorcycle);
    }
}