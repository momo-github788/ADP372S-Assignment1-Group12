package za.ac.cput.vehicledealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Inventory;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.factory.InventoryFactory;
import za.ac.cput.vehicledealership.repository.InventoryRepository;
import za.ac.cput.vehicledealership.repository.VehicleRepository;
import za.ac.cput.vehicledealership.service.ServiceInventory;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InventoryService implements ServiceInventory {


    private final InventoryRepository inventoryRepository;
    private final VehicleRepository vehicleRepository;
    @Override
    public Inventory create(Inventory type) {
        Vehicle vehicle=vehicleRepository.getById(type.getInventoryId());
        Inventory inventory= InventoryFactory.createInventoryFactory(type.getQuantity(),type.getInventoryType(),vehicle);

        return  inventoryRepository.save(inventory);
    }

    @Override
    public Inventory read(String s) {
        Inventory inventory=inventoryRepository.getById(s);
        return inventory;
    }

    @Override
    public Inventory update(Inventory type) {
        Vehicle vehicle=vehicleRepository.getById(type.getVehicle().getVehicleId());
        Inventory inventory= InventoryFactory.updateInventoryFactorywithid(type.getInventoryId(),type.getQuantity(),type.getInventoryType(),vehicle);
        return  inventoryRepository.save(inventory);
    }

    @Override
    public boolean delete(String s) {

        return inventoryRepository.existsById(s) ;
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> getAll=inventoryRepository.findAll();
        return getAll;
    }
}
