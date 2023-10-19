//package za.ac.cput.vehicledealership.service;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.vehicledealership.domain.*;
//import za.ac.cput.vehicledealership.factory.AddonsFactory;
//import za.ac.cput.vehicledealership.factory.BranchFactory;
//import za.ac.cput.vehicledealership.factory.VehicleAddonFactory;
//import za.ac.cput.vehicledealership.factory.VehicleFactory;
//import za.ac.cput.vehicledealership.service.impl.AddonsServiceImpl;
//import za.ac.cput.vehicledealership.service.impl.VehicleAddonService;
//import za.ac.cput.vehicledealership.service.impl.VehicleServiceImpl;
//
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class VehicleServiceAddonsTest {
//
//    @Autowired
//    private VehicleAddonService serviceVehicleAddons;
//
//    @Autowired
//    private AddonsServiceImpl addonsService;
//
//    @Autowired
//    private VehicleServiceImpl vehicleService;
//
//    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
//            "White", 2019, 23000);
//
//    private static Addon addons = AddonsFactory.createAddons("Audi", "A4",
//            LocalDateTime.now(), AddonType.DETAILING, 15000, 12, 12);
//
//    @Order(1)
//    @Test
//    void create() {
//        Vehicle v = vehicleService.create(vehicle);
//        Addon a = addonsService.create(addons);
//        VehicleAddon  vehicleAddons1= serviceVehicleAddons
//                .create(VehicleAddonFactory.createVehicleAddonFactory(v.getVehicleId(), a.getAddonId()));
//        assertNotNull(vehicleAddons1);
//        System.out.println("Create: " + vehicleAddons1);
//    }
////    @Order(2)
////    @Test
////    void read() {
////        VehicleAddon vehicleAddons1= serviceVehicleAddons.(String.valueOf(vehicleAddons.getVehicleId()));
////        assertNotNull(vehicleAddons1);
////        System.out.println("Read: " + vehicleAddons1);
////    }
////    @Order(4)
////    @Test
////    void delete() {
////        boolean success = serviceVehicleAddons.delete(vehicle.getVehicleId());
////
////        assertTrue(success);
////        System.out.println("Delete: " + success);
////    }
////    @Order(5)
////    @Test
////    void getAll() {
////        System.out.println("Get all: ");
////        System.out.println(serviceVehicleAddons.getAll());
////        assertEquals(1, serviceVehicleAddons.getAll().size());
////    }
//}