/*  BranchRepositoryTestTest.java
    Test class for BranchRepository
    Author: Simphiwekahlana (220162891)
    Date: 6 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.BranchFactory;
import za.ac.cput.factory.LocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BranchRepositoryTest {
    private static BranchRepository repository = BranchRepository.getBranchRepository();

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