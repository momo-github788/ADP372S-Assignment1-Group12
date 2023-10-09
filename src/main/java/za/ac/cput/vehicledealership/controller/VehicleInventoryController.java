package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleInventory;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.service.WatchListPostService;
import za.ac.cput.vehicledealership.service.impl.VehicleInventoryServiceImpl;
import za.ac.cput.vehicledealership.service.impl.WatchListPostServiceImpl;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/vehicleInventory")
@CrossOrigin
public class VehicleInventoryController {

    @Autowired
    private VehicleInventoryServiceImpl vehicleInventoryService;

    @PostMapping("/create")
    public VehicleInventory create(@RequestBody VehicleInventory vehicleInventory) {
        return vehicleInventoryService.create(vehicleInventory.getVehicleId(), vehicleInventory.getInventoryId());
    }

    @GetMapping("/all/{inventoryId}")
    public List<Vehicle> getAll(@PathVariable int inventoryId) {
        return vehicleInventoryService.getAllVehiclesByInventoryId(inventoryId);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody VehicleInventory vehicleInventory) {
        System.out.println(vehicleInventory + " to delete");
        return vehicleInventoryService.delete(vehicleInventory.getVehicleId(), vehicleInventory.getInventoryId());
    }
}
