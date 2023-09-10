/*
 * BranchFactoryTest.java
 * This is the Factory Test for Branch
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */


package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.Branch;

import za.ac.cput.vehicledealership.domain.Location;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BranchFactoryTest {
    @Test
    public void testCreateBranch() {

        Location location = LocationFactory.createLocation(89974, "Main Road", "Cape Town", 7626, "Western Cape");

        Branch branch = BranchFactory.createBranch("Paarl Auto",2008,location);


        System.out.println(branch);
        assertNotNull(branch);

    }

}

