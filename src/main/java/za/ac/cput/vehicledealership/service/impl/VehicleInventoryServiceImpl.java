/*  WatchListPostServiceImpl.java
    Implementation of the WatchListPostService
    Author: Muhammed Luqmaan Hoosain (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.VehicleInventoryFactory;
import za.ac.cput.vehicledealership.factory.WatchListPostFactory;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.repository.VehicleInventoryRepository;
import za.ac.cput.vehicledealership.repository.VehicleRepository;
import za.ac.cput.vehicledealership.repository.WatchListPostRepository;
import za.ac.cput.vehicledealership.service.InventoryService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VehicleInventoryServiceImpl {

    private final VehicleInventoryRepository vehicleInventoryRepository;
    private final VehicleRepository vehicleRepository;
    private final InventoryService inventoryService;

    public VehicleInventory create(int vehicleId, int inventoryId) {
        Inventory inventory = inventoryService.read(inventoryId);
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

        if(inventory == null) throw new RuntimeException("Inventory with id " + inventory.getInventoryId() + " does not exist");
        if(vehicle == null) throw new RuntimeException("Vehicle with id " + vehicle.getVehicleId() + " does not exist");

        VehicleInventory vehicleInventory = VehicleInventoryFactory.createVehicleInventory(vehicle.getVehicleId(), inventory.getInventoryId());
        inventory.setQuantity(inventory.getQuantity()+1);
        return vehicleInventoryRepository.save(vehicleInventory);
    }

    public boolean delete(int vehicleId, int inventoryId) {
        Inventory inventory = inventoryService.read(inventoryId);
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

        if(inventory == null) throw new RuntimeException("Inventory with id " + inventory.getInventoryId() + " does not exist");
        if(vehicle == null) throw new RuntimeException("Vehicle with id " + vehicle.getVehicleId() + " does not exist");

        inventory.setQuantity(inventory.getQuantity()-1);

        VehicleInventory vehicleInventory = vehicleInventoryRepository.findFirstByVehicleIdAndInventoryId(vehicle.getVehicleId(), inventory.getInventoryId());

        if (vehicleInventory == null) return false;

        vehicleInventoryRepository.delete(vehicleInventory);
        return true;
    }

    public List<Vehicle> getAllVehiclesByInventoryId(int inventoryId) {

        Inventory inventory = inventoryService.read(inventoryId);

        List<VehicleInventory> vehicleInventoryIdList = vehicleInventoryRepository.findAllByInventoryId(inventory.getInventoryId());
        List<Vehicle> vehicles = vehicleRepository.findAllByVehicleIdIn(vehicleInventoryIdList.stream().map(v -> v.getVehicleId()).collect(Collectors.toList()));

        if (vehicles.isEmpty()) return Collections.EMPTY_LIST;

        return vehicles;
    }
}
