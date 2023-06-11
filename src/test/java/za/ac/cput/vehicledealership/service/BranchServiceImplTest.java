package za.ac.cput.vehicledealership.service;

/*  BranchServiceImplTest.java
    Test class for BranchServiceImpl
    Author: Simphiwe Kahlana (220162891)
    Date: 10 June 2023
*/


import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.repository.impl.BranchRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class BranchServiceImplTest {
    private static BranchRepositoryImpl repository = BranchRepositoryImpl.getBranchRepository();

    private static Location location = LocationFactory.createLocation(89974, "Main Road", "Paarl", "7626", "Western Cape");

    private static Branch branch  = BranchFactory.createBranch("Paarl",2008,location);

    @Test
    void a_create() {
        Branch created = repository.create(branch);
        assertEquals(branch.getBranchId(), created.getBranchId());
        System.out.println("Create: " +created);

    }

    @Test
    void b_read() {
        Branch read = repository.read(branch.getBranchId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Branch updated = new Branch.BranchBuilder().copy(branch).setBranchName("Drakenstein Auto")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(branch.getBranchId());
        assertTrue(success);
        System.out.printf("Deleted" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repository.getAll());
    }
}
