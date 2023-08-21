/*  BranchServiceImpl.java
    Implementation of the BranchService
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.Branch;

import za.ac.cput.vehicledealership.service.BranchService;

import java.util.Set;

public class BranchServiceImpl implements BranchService {
    private static BranchServiceImpl branchService = null;
    private BranchRepositoryImpl branchRepository = null;

    public BranchServiceImpl() {
        this.branchRepository = BranchRepositoryImpl.getBranchRepository();
    }

    public static BranchServiceImpl getBranchService() {
        if(branchService == null) {
            branchService = new BranchServiceImpl();
        }
        return branchService;
    }


    @Override
    public Branch create(Branch branch) {
        return branchRepository.create(branch);
    }


    @Override
    public Branch read(String branchId) {
        return branchRepository.read(branchId);
    }

    @Override
    public Branch update(Branch branch) {
        return branchRepository.update(branch);
    }


    @Override
    public boolean delete(String branchId) {
        return branchRepository.delete(branchId);
    }

    @Override
    public Set<Branch> getAll() {
        return branchRepository.getAll();
    }
}
