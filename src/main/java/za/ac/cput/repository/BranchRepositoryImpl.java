/*  BranchRepository.java
    Implementation of IBranchRepository
    Author: Simphiwe Kahlana (220162891)
    Date: 5 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Branch;


import java.util.HashSet;
import java.util.Set;


public class BranchRepositoryImpl implements IBranchRepository{


    private static BranchRepositoryImpl branchRepositoryImpl = null;
    private Set<Branch> branchDB = null;

    private BranchRepositoryImpl() {
        this.branchDB = new HashSet<Branch>();
    }

    public static BranchRepositoryImpl getBranchRepository() {
        if(branchRepositoryImpl == null) {
            branchRepositoryImpl = new BranchRepositoryImpl();
        }
        return branchRepositoryImpl;
    }

    @Override
    public Branch create(Branch branch) {
        boolean success = branchDB.add(branch);

        if(!success) {
            return null;
        }
        return branch;

    }

    @Override
    public Branch read(String branchId) {
        return branchDB
                .stream()
                .filter(location -> location.getBranchId().equals(branchId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Branch update(Branch branch) {

        Branch oldBranch = read(branch.getBranchId());

        if(oldBranch != null) {
            branchDB.remove(oldBranch);
            branchDB.add(branch);
            return branch;

        }
        return null;

    }

    @Override
    public boolean delete(String branchId) {
        Branch branch = read(branchId);

        if(branch == null) {
            return false;
        }

        branchDB.remove(branch);
        return true;
    }

    @Override
    public Set<Branch> getAll() {
        return branchDB;
    }
}
