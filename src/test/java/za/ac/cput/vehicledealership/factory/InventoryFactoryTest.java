package za.ac.cput.vehicledealership.factory;
/* InventoryFactoryTest.java
    Test class for Inventory
    Author: Kimoki Serge Kalala (220525137)
    Date: 07 April 2023
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class InventoryFactoryTest {

    @Test
    void createInventoryFactoryaSuccess() {
        Location location = LocationFactory.createLocation(89974, "Main Road", "Cape Town", 7626, "Western Cape");

        Branch branch = BranchFactory.createBranch("Paarl Auto",2008,location);

        Inventory inventory= InventoryFactory.createInventoryFactory("My Inventory", 2, InventoryType.USED,branch);
        System.out.println(inventory);
        assertNotNull(inventory);


    }

}