package za.ac.cput.vehicledealership.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.InventoryFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.repository.impl.InventoryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryRepositoryImplTest {


    private static InventoryRepositoryImpl InventoryRepository = InventoryRepositoryImpl.getRepository();
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

    private static Inventory inventory= InventoryFactory.createInventoryFactory(43, InventoryType.NEW_INVENTORY,vehicle);

    private static  Inventory inventory1= InventoryFactory.createInventoryFactory(673,InventoryType.USED_INVENTORY,vehicle);


    @Order(1)
    @Test
    void a_create() {

        Inventory createdInventory = InventoryRepository.create(inventory);
        InventoryRepository.create(inventory1);
        assertNotNull(createdInventory);
        System.out.println("Create: " + createdInventory);
    }
    @Order(2)
    @Test
    void b_read() {
        Inventory ReadInventory = InventoryRepository.read(inventory.getInventoryId());

        System.out.println("Read: " + ReadInventory);
    }
    @Order(3)
    @Test
    void c_update() {
        Inventory updatedInventory = new Inventory.Builder()
                .copy(inventory)
                .setQuantity(100)
                .build();
        assertNotNull(InventoryRepository.update(updatedInventory));
        System.out.println("Update: " + updatedInventory);
    }
    @Order(4)
    @Test
    void d_delete() {
        boolean success = InventoryRepository.delete(inventory.getInventoryId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }
    @Order(5)
    @Test
    void e_getAll() {
        System.out.println("Get all: ");
        System.out.println(InventoryRepository.getAll());
        assertEquals(1, InventoryRepository.getAll().size());
    }
}