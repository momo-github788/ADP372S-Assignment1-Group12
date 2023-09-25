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

//        List<Vehicle> vehicleList = new ArrayList<>();
        Branch branch = branchService.read(inventory.getBranch().getBranchId());
        if (branch == null) {
            throw new IllegalArgumentException("BRANCH DOES NOT EXIST");
        }

        if(inventoryRepository.existsByName(inventory.getName())) {
            throw new RuntimeException("Inventory with name " + inventory.getName() + " exists");
        }
//
//        System.out.println("inventory vehicles " + inventory.getVehicles().size());
//
//        if (inventory.getVehicles().size() < 1) {
//            throw new IllegalArgumentException("VEHICLE DOES NOT EXIST");
//        }
//
//        for(int i = 0; i < inventory.getVehicles().size(); i++) {
//            System.out.println("inside inventory vehicle loop");
//            Vehicle vehicle = vehicleService.read(inventory.getVehicles().get(i).getVehicleId());
//
//            if(inventory.getInventoryType().equals(InventoryType.NEW)) {
//                System.out.println("inventory only allows for new vehicles");
//            } else if(inventory.getInventoryType().equals(InventoryType.USED)){
//                System.out.println("inventory only allows for used vehicles");
//
//            } else {
//                System.out.println("inventory only allows for demo vehicles");
//
//            }
//            vehicleList.add(vehicle);
//            vehicle.setInventory(inventory);
//
//        }
//        System.out.println("vehicle list");
//        System.out.println(vehicleList);
//
//
        inventory.setBranch(branch);
//        inventory.setVehicles(vehicleList);
//        //inventory.setQuantity(inventory.getQuantity()+1);

        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory read(Integer inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElse(null);
    }

    @Override
    public Inventory update(Inventory inventory) {
//        Vehicle vehicle=vehicleService.read(inventory.getVehicle().getVehicleId());
//        Inventory tinventory= InventoryFactory.updateInventoryFactorywithid(inventory.getInventoryId(),inventory.getQuantity(),inventory.getInventoryType(),vehicle);
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
