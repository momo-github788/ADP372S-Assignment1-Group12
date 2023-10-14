package za.ac.cput.vehicledealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.InventoryFactory;
import za.ac.cput.vehicledealership.repository.InventoryRepository;
import za.ac.cput.vehicledealership.repository.VehicleInventoryRepository;
import za.ac.cput.vehicledealership.repository.VehicleRepository;
import za.ac.cput.vehicledealership.service.InventoryService;


import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {


    private final InventoryRepository inventoryRepository;
    private final VehicleInventoryRepository vehicleInventoryRepository;
    private final BranchServiceImpl branchService;


    @Override
    public Inventory create(Inventory inventory) {

        Branch branch = branchService.read(inventory.getBranch().getBranchId());
        if (branch == null) {
            throw new IllegalArgumentException("BRANCH DOES NOT EXIST");
        }

        if(inventoryRepository.existsByName(inventory.getName())) {
            throw new RuntimeException("Inventory with name " + inventory.getName() + " exists");
        }

        inventory.setBranch(branch);

        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory read(Integer inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElse(null);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return  inventoryRepository.save(inventory);
    }

    @Override
    public boolean delete(Integer inventoryId) {

        List<VehicleInventory> vehicleInventories = new ArrayList<>();

        if (this.inventoryRepository.existsById(inventoryId)){
            this.inventoryRepository.deleteById(inventoryId);

            vehicleInventories.addAll(vehicleInventoryRepository.findAllByInventoryId(inventoryId));
            vehicleInventoryRepository.deleteAll(vehicleInventories);
            return true;
        }
        return false;
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> getAll=inventoryRepository.findAll();
        return getAll;
    }
}
