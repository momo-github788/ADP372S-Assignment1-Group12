/*
 * BranchFactory.java
 * This is the Factory for Branch
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */


package za.ac.cput.factory;

import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Location;

import java.util.HashMap;
import java.util.Map;

public class BranchFactory {
    private static Map<String, Branch> branches = new HashMap<>();

    public static Branch createBranch(String branchName, int yearOpened, Location location) {
        Branch branch = new Branch.Builder()
                .setBranchName(branchName)
                .setYearOpened(yearOpened)
                .setLocation(location)
                .build();
        if (branches.containsKey(branch.getBranchId())) {
            throw new RuntimeException("Branch ID already exists: " + branch.getBranchId());
        }
        branches.put(branch.getBranchId(), branch);
        return branch;
    }

    public static Branch getBranch(String branchId) {
        return branches.get(branchId);
    }
}
