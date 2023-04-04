/*
 * BranchFactoryTest.java
 * This is the Factory Test for Branch
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */


package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Location;

import static org.junit.jupiter.api.Assertions.*;

public class BranchFactoryTest {
    @Test
    public void testCreateBranch() {
        String branchName = "Main Branch";
        int yearOpened = 2020;
        Location location = new Location.LocationBuilder()
                .setLocationId("WCP262")
                .setStreetNumber(8726)
                .setStreetName("Main Road")
                .setCity("Paarl")
                .setPostalCode("7626")
                .setProvince("Western Cape")
                .build();

        Branch branch = BranchFactory.createBranch(branchName, yearOpened, location);

        assertNotNull(branch);
        assertNotNull(branch.getBranchId());
        assertEquals(branchName, branch.getBranchName());
        assertEquals(yearOpened, branch.getYearOpened());
        assertEquals(location, branch.getLocation());
    }
}
