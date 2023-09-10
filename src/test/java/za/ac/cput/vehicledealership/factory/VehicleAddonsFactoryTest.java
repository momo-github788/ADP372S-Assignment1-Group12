package za.ac.cput.vehicledealership.factory;
/* VehicleAddonsFactoryTest.java
    Test class for VehicleAddons
    Author: Kimoki Serge Kalala (220525137)
    Date: 07/04/2023
*/


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.VehicleAddon;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class VehicleAddonsFactoryTest {

    VehicleAddon vehicleAddons;


    @Test
    void createVehicleAddonsFactory() {
        vehicleAddons  = VehicleAddonFactory.createVehicleAddonFactory(45677,97654);
          assertNotNull(vehicleAddons);
    }

}