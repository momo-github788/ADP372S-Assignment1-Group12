/*  TruckFactoryTest.java
    Factory Test for Truck Entity
    Author: Alan Chapman (220092362)
    Date: 4 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Truck;
import za.ac.cput.domain.VehicleCondition;

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