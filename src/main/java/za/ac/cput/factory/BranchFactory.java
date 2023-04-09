/*
 * BranchFactory.java
 * This is the Factory for Branch
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */


package za.ac.cput.factory;

import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Location;
import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class BranchFactory {
    public static Branch createBranch(String branchName, int yearOpened, Location location) {

        if (isNullOrEmpty(branchName) || yearOpened <= 0 || location == null) {
            return null;
        }

        return new Branch.BranchBuilder()
                .setBranchId(generateId())
                .setBranchName(branchName)
                .setYearOpened(yearOpened)
                .setLocation(location)
                .build();

    }
}
