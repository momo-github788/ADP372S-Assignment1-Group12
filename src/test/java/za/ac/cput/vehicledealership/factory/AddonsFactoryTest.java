package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.AddonsFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
/*  AddonsFactoryTest.java
    Test class for AddonsFactory
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
class AddonsFactoryTest {

    private String vehicleId;
    private String make;
    private String model;
    private VehicleCondition condition;
    private FuelType fuelType;
    private String colour;
    private int year;
    private int mileage;
    @Test
    public void testCreateAddonSuccess(){
        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        Addons addons = AddonsFactory.createAddons("Sunroof", "Panoramic", LocalDateTime.now(), vehicle,5000.00, 12);

        System.out.println(addons);
        assertNotNull(addons);
    }
}