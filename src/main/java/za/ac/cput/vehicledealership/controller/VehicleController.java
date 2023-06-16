package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.service.VehicleService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/create")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }

    @GetMapping("read/{id}")
    public Vehicle get(@PathVariable String id) {
        return vehicleService.read(id);
    }

    @GetMapping("/all")
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }

    @PostMapping("/update")
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return vehicleService.delete(id);
    }
}