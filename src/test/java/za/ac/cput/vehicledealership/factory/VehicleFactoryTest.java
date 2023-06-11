
package za.ac.cput.vehicledealership.factory;

/*  VehicleFactoryTest.java
    Test class for VehicleFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    @Test
    public void testCreateVehicleSuccess() {
        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        System.out.println(vehicle);
        assertNotNull(vehicle);

    }

    @Test
    public void testCreateVehicleExceptionWithInvalidYear() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 999, 23000));

        System.out.println(exception);

        assertTrue(exception.getMessage().contentEquals("Year must be minimum of 4 digits"));

    }

}