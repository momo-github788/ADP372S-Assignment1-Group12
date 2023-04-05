package za.ac.cput.factory;
/*  ServicingAddonsFactoryTest.java
    Test class for Servicing AddonsFactory
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.ServicingAddon;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.domain.VehicleCondition;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServicingAddonFactoryTest {
    private String vehicleId;
    private String make;
    private String model;
    private VehicleCondition condition;
    private FuelType fuelType;
    private String colour;
    private int year;
    private int mileage;
    @Test
    public void testCreateServicingAddonSuccess(){
        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        ServicingAddon servicingAddon = ServicingAddonFactory.createServicingAddon("Optional car servicing", "Mini car service", LocalDateTime.now(), vehicle,500.00, 6, 3, 10000);

        System.out.println(servicingAddon);
        assertNotNull(servicingAddon);
    }
}