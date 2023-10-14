package za.ac.cput.vehicledealership.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.InventoryFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.service.impl.InventoryServiceImpl;
import za.ac.cput.vehicledealership.service.impl.VehicleServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private BranchService branchService;
    private VehicleServiceImpl vehicleService;
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
            "White", 2019, 23000);

    private static Location location = LocationFactory.createLocation(89974, "Main Road", "Paarl", 7626, "Western Cape");
    private static Branch branch  = BranchFactory.createBranch("Paar31l",2008,location);
    private static  Inventory inventory= InventoryFactory.createInventoryFactory("My i1nvent3ory", 43, InventoryType.USED, branch);
    @Order(1)
    @Test
    void create() {
        Branch createdBranch = branchService.create(branch);

        inventory.setBranch(createdBranch);
        Inventory createdInventory= inventoryService.create(inventory);

        assertNotNull(createdInventory);
        System.out.println("Create: " + createdInventory);
    }

    @Order(2)
    @Test
    void read() {
        Inventory readVehicle = inventoryService.read(inventory.getInventoryId());
        assertNotNull(readVehicle);
        System.out.println("Read: " + readVehicle);
    }

    @Order(3)
    @Test
    void update() {
        Inventory updatedInventory= new Inventory.Builder()
                .copy(inventory)
                .setQuantity(221)
                .build();
        assertNotNull(inventoryService.update(updatedInventory));
        System.out.println("Update: " + updatedInventory);

    }

    @Order(5)
    @Test
    void delete() {
        boolean success = inventoryService.delete(inventory.getInventoryId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(inventoryService.getAll());
        assertEquals(1, inventoryService.getAll().size());
    }
}