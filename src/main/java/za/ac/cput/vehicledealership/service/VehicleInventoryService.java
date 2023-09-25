package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.VehicleInventory;
import za.ac.cput.vehicledealership.domain.VehicleInventoryId;
import za.ac.cput.vehicledealership.domain.WatchListPost;

import java.util.List;
import java.util.Set;

public interface VehicleInventoryService  extends IService<VehicleInventory, VehicleInventoryId> {
    List<VehicleInventory> getAll();
}
