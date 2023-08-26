//package za.ac.cput.vehicledealership.service;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.vehicledealership.domain.*;
//import za.ac.cput.vehicledealership.factory.AddonsFactory;
//import za.ac.cput.vehicledealership.factory.VehicleAddonFactory;
//import za.ac.cput.vehicledealership.factory.VehicleFactory;
//import za.ac.cput.vehicledealership.service.impl.VehicleServiceAddons;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class ServiceVehicleAddonsTest {
//
//    @Autowired
//    private VehicleServiceAddons serviceVehicleAddons;
//    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED,
//            FuelType.PETROL, "White", 2019, 23000);
//    private static Addon addons = AddonsFactory.createAddons("Audi", "A4", LocalDateTime.now(), AddonType.DETAILINGADDON, 15000, 12, 12);
//
//
//    private static VehicleAddons vehicleAddons=
//            VehicleAddonFactory.createVehicleAddonsFactory(vehicle,addons);
//    @Order(1)
//    @Test
//    void create() {
//        VehicleAddons  vehicleAddons1= serviceVehicleAddons.create(vehicleAddons) ;
//        assertNotNull(vehicleAddons1);
//        System.out.println("Create: " + vehicleAddons1);
//    }
//    @Order(2)
//    @Test
//    void read() {
//        VehicleAddons  vehicleAddons1= serviceVehicleAddons.read(String.valueOf(vehicleAddons.getVehicleId()));
//        assertNotNull(vehicleAddons1);
//        System.out.println("Read: " + vehicleAddons1);
//    }
//    @Order(4)
//    @Test
//    void delete() {
//        boolean success = serviceVehicleAddons.delete(vehicle.getVehicleId());
//
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//    @Order(5)
//    @Test
//    void getAll() {
//        System.out.println("Get all: ");
//        System.out.println(serviceVehicleAddons.getAll());
//        assertEquals(1, serviceVehicleAddons.getAll().size());
//    }
//}