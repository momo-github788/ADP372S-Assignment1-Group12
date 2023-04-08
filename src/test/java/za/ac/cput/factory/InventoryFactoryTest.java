package za.ac.cput.factory;
/* InventoryFactoryTest.java
    Test class for Inventory
    Author: Kimoki Serge Kalala (220525137)
    Date: 07 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.domain.VehicleCondition;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    void createInventoryFactoryaSuccess() {
        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        Inventory inventory=InventoryFactory.createInventoryFactory(43,"Car",vehicle);
        System.out.println(inventory);
        assertNotNull(inventory);


    }
    @Test
    void createInventoryFactoryFail() {

        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        Inventory inventory=InventoryFactory.createInventoryFactory(43,"Car",vehicle);

        assertNull(inventory);
    }
}