/*  BranchServiceImpl.java
    Implementation of the BranchService
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Branch;

import za.ac.cput.vehicledealership.repository.BranchRepository;
import za.ac.cput.vehicledealership.service.BranchService;

import java.util.List;
import java.util.Set;

@Service
public class BranchServiceImpl implements BranchService {

    private static BranchServiceImpl branchService = null;

    private BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    @Override
    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }


    @Override
    public Branch read(String branchId) {
        return branchRepository.findById(branchId).orElse(null);
    }

    @Override
    public Branch update(Branch branch) {
        if(this.branchRepository.existsById(branch.getBranchId())) {
            return this.branchRepository.save(branch);
        }
        return null;
    }


    @Override
    public boolean delete(String branchId) {
        if(branchRepository.existsById(branchId)) {
            this.branchRepository.deleteById(branchId);
        }
        return false;
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }
}
