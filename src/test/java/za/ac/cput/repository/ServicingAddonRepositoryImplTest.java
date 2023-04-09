package za.ac.cput.repository;
/*  ServicingAddonRepositoryImplTest.java
    Test class for ServicingAddonRepositoryImpl
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.ExtendedWarrantyAddonFactory;
import za.ac.cput.factory.ServicingAddonFactory;
import za.ac.cput.factory.VehicleFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ServicingAddonRepositoryImplTest {

    private static ServicingAddonRepositoryImpl servicingAddonRepository = ServicingAddonRepositoryImpl.getServicingAddonRepository();
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
            "White", 2019, 23000);

    private static ServicingAddon servicingAddon = ServicingAddonFactory.createServicingAddon("Full service", "Major car service", LocalDateTime.now(),
            vehicle, 15000, 24, 2, 50000);
    @Test
    void a_create() {
        ServicingAddon created = servicingAddonRepository.create(servicingAddon);
        assertEquals(servicingAddon.getAddonId(), created.getAddonId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        ServicingAddon read = servicingAddonRepository.read(servicingAddon.getAddonId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        ServicingAddon updated = new ServicingAddon.ServicingAddonBuilder().copy(servicingAddon).setName("Mini service")
                .setDescription("Minor car service").setDate(LocalDateTime.now()).setVehicle(vehicle)
                .setPrice(2000).setPeriodExpirationMonths(6).setServiceCount(2).setMileageLimit(20000).build();

        assertNotNull(servicingAddonRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = servicingAddonRepository.delete(servicingAddon.getAddonId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(servicingAddonRepository.getAll());
    }
}