/*  BranchServiceImpl.java
    Implementation of the BranchService
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Branch;

import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.repository.BranchRepository;
import za.ac.cput.vehicledealership.service.BranchService;

import java.util.List;
import java.util.Set;

@Service
public class BranchServiceImpl implements BranchService {

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
    public Branch read(Integer branchId) {
        return branchRepository.findById(branchId).orElse(null);
    }

    @Override
    public Branch update(Branch branch) {
        if(this.branchRepository.existsById(branch.getBranchId())) {
            Location updatedLocation = LocationFactory.createLocation(branch.getLocation().getStreetNumber(), branch.getLocation().getStreetName(),
                    branch.getLocation().getCity(), branch.getLocation().getPostalCode(), branch.getLocation().getProvince());

            branch.setLocation(updatedLocation);
            return this.branchRepository.save(branch);
        }
        return null;
    }

    public void deleteAll() {
        branchRepository.deleteAll();
    }

    @Override
    public boolean delete(Integer branchId) {
        if(branchRepository.existsById(branchId)) {
            this.branchRepository.deleteById(branchId);
            return true;
        }
        return false;
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }
}
