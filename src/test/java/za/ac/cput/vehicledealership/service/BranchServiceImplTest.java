package za.ac.cput.vehicledealership.service;

/*  BranchServiceImplTest.java
    Test class for BranchServiceImpl
    Author: Simphiwe Kahlana (220162891)
    Date: 10 June 2023
*/


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.service.impl.BranchServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BranchServiceImplTest {

    @Autowired
    private BranchServiceImpl branchService;

    private static Location location = LocationFactory.createLocation(89974, "Main Road", "Paarl", 7626, "Western Cape");
    private static Branch branch  = BranchFactory.createBranch("Paarl",2008,location);

    @Test
    @Order(1)
    void a_create() {
        Branch created = branchService.create(branch);
        assertNotNull(created);
        System.out.println("Create: " +created);

    }

    @Test
    @Order(2)
    void b_read() {
        Branch read = branchService.read(branch.getBranchId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    @Order(3)
    void c_update() {

        Branch updated = new Branch.BranchBuilder()
                .copy(branch)
                .setBranchName("Drakenstein Auto")
                .build();
        assertNotNull(branchService.update(updated));
        System.out.println("Updated" + updated);
    }

    @Test
    @Order(5)
    void e_delete() {
        boolean success = branchService.delete(branch.getBranchId());
        assertTrue(success);
        System.out.printf("Deleted" + success);
    }

    @Test
    @Order(4)
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(branchService.getAll());
    }
}
