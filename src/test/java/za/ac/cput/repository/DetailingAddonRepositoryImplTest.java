package za.ac.cput.repository;
/*  DetailingAddonRepositoryImplTest.java
    Test class for DetailingAddonRepositoryImpl
    Author: Junaid Cedrass (219090912)
    Date: 8 April 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.DetailingAddonFactory;
import za.ac.cput.factory.ExtendedWarrantyAddonFactory;
import za.ac.cput.factory.ServicingAddonFactory;
import za.ac.cput.factory.VehicleFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DetailingAddonRepositoryImplTest {

    private static DetailingAddonRepositoryImpl detailingAddonRepository = DetailingAddonRepositoryImpl.getDetailingAddonRepository();
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
            "White", 2019, 23000);

    private static DetailingAddon detailingAddon = DetailingAddonFactory.createDetailingAddon("Full service", "Major car service", LocalDateTime.now(),
            vehicle, 15000, 24,LocalDateTime.now() ,LocalDateTime.now());
    @Test
    void a_create() {
        DetailingAddon created = detailingAddonRepository.create(detailingAddon);
        assertEquals(detailingAddon.getAddonId(), created.getAddonId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        DetailingAddon read = detailingAddonRepository.read(detailingAddon.getAddonId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        DetailingAddon updated = new DetailingAddon.DetailingAddOnBuilder().copy(detailingAddon)
                .setName("Mini service")
                .setDescription("Minor car service").setDate(LocalDateTime.now()).setVehicle(vehicle)
                .setPrice(2000).setPeriodExpirationMonths(6).build();

        assertNotNull(detailingAddonRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = detailingAddonRepository.delete(detailingAddon.getAddonId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(detailingAddonRepository.getAll());
    }
}