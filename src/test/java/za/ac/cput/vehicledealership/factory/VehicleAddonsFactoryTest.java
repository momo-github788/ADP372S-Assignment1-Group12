//package za.ac.cput.vehicledealership.factory;
///* VehicleAddonsFactoryTest.java
//    Test class for VehicleAddons
//    Author: Kimoki Serge Kalala (220525137)
//    Date: 07/04/2023
//*/
//
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.vehicledealership.domain.VehicleAddons;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//class VehicleAddonsFactoryTest {
//
//    VehicleAddons vehicleAddons;
//
//
//    @Test
//    void createVehicleAddonsFactory() {
//        vehicleAddons  = VehicleAddonsFactory.createVehicleAddonsFactory("45677","97654");
//          assertNotNull(vehicleAddons);
//    }
//
//    @Test
//    void createVehicleAddonsFails() {
//        vehicleAddons  =VehicleAddonsFactory.createVehicleAddonsFactory("289273","");
//        assertNull(vehicleAddons);
//    }
//}