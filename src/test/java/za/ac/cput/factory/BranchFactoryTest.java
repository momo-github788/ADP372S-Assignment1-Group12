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
        Location location = LocationFactory.createLocation(89974, "Main Road", "Paarl", "7626", "Western Cape");

        Branch branch = BranchFactory.createBranch("Paarl Auto",2008,location);


        System.out.println(branch);
        assertNotNull(branch);

    }

    @Test
    void testCreateBranchWithNullValue() {

        Branch branch = BranchFactory.createBranch("Paarl Auto", 20087, null);

        System.out.println(branch.toString());
        assertNull(branch.toString());
    }
}

