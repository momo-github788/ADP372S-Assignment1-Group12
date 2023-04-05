package za.ac.cput.factory;
/*  ExtendedWarrantyAddonsFactoryTest.java
    Test class for Extended Warranty AddonsFactory
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedWarrantyAddonFactoryTest {

    private String vehicleId;
    private String make;
    private String model;
    private VehicleCondition condition;
    private FuelType fuelType;
    private String colour;
    private int year;
    private int mileage;

    @Test
    public void testCreateExtendedWarrantyAddonSuccess(){
        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        ExtendedWarrantyAddon extendedWarrantyAddon = ExtendedWarrantyAddonFactory.createExtendedWarrantyAddon("Warranty", "1 year warranty", LocalDateTime.now(), vehicle, 15000, 12, 210000);

        System.out.println(extendedWarrantyAddon);
        assertNotNull(extendedWarrantyAddon);
    }
}