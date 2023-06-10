/*  TruckFactoryTest.java
    Factory Test for Truck Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Truck;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.TruckFactory;

import static org.junit.jupiter.api.Assertions.*;

class TruckFactoryTest {
    @Test
    void testCreateTruckSuccess() {
        Truck truck = TruckFactory.createTruck("Mercedes Benz", "Actros", VehicleCondition.USED, FuelType.DIESEL,"red",
                2023, 1006, 6, 13607.8);
        System.out.println(truck);
        assertNotNull(truck);
    }
}