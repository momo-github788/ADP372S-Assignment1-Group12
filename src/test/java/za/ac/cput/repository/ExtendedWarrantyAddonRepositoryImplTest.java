package za.ac.cput.repository;
/*  ExtendedWarrantyAddonRepositoryImplTest.java
    Test class for  ExtendedWarrantyAddonRepositoryImpl
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ExtendedWarrantyAddon;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.domain.VehicleCondition;
import za.ac.cput.factory.ExtendedWarrantyAddonFactory;
import za.ac.cput.factory.VehicleFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ExtendedWarrantyAddonRepositoryImplTest {

    private static ExtendedWarrantyAddonRepositoryImpl extendedWarrantyAddonRepository = ExtendedWarrantyAddonRepositoryImpl.getExtendedWarrantyAddonRepository();

    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
            "White", 2019, 23000);

    private static ExtendedWarrantyAddon extendedWarrantyAddon = ExtendedWarrantyAddonFactory.createExtendedWarrantyAddon("Warranty", "5 year warranty",
            LocalDateTime.now(), vehicle, 10000, 120, 200000);
    @Test
    void a_create() {
        ExtendedWarrantyAddon created = extendedWarrantyAddonRepository.create(extendedWarrantyAddon);
        assertEquals(extendedWarrantyAddon.getAddonId(), created.getAddonId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        ExtendedWarrantyAddon read = extendedWarrantyAddonRepository.read(extendedWarrantyAddon.getAddonId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        ExtendedWarrantyAddon updated = new ExtendedWarrantyAddon.ExtendedWarrantyAddonBuilder().copy(extendedWarrantyAddon).setName("Extended Warranty").setDescription("15 year warranty")
                .setDate(LocalDateTime.now())
                .setVehicle(vehicle)
                .setPrice(10000)
                .setPeriodExpirationMonths(120)
                .setMileageLimit(200000)
                .build();
        assertNotNull(extendedWarrantyAddonRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = extendedWarrantyAddonRepository.delete(extendedWarrantyAddon.getAddonId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(extendedWarrantyAddonRepository.getAll());
    }
}