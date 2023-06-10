package za.ac.cput.vehicledealership.repository;
/*  AddonsRepositoryImplTest.java
    Test class for ServicingAddonImplRepositoryImpl
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.AddonsFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.repository.impl.AddonsRepositoryImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AddonsRepositoryImplTest {

    private static AddonsRepositoryImpl addonsRepository = AddonsRepositoryImpl.getAddonsRepository();

    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
            "White", 2019, 23000);
    private static Addons addons = AddonsFactory.createAddons("Comfort", "Heated seats", LocalDateTime.now(), vehicle, 5000, 60);
    @Test
    void a_create() {
        Addons created = addonsRepository.create(addons);
        assertEquals(addons.getAddonId(), created.getAddonId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Addons read = addonsRepository.read(addons.getAddonId());
        assertNotNull(read);
        System.out.println("Read: " + read);

    }

    @Test
    void c_update() {
        Addons updated = new Addons.AddonsBuilder().copy(addons).setName("Comfort line").setDescription("Massaging seats")
                .build();
        assertNotNull(addonsRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = addonsRepository.delete(addons.getAddonId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(addonsRepository.getAll());
    }
}