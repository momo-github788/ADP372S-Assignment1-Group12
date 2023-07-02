package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Post;
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
    public ResponseEntity<?> create(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.update(vehicle);
        if(createdVehicle == null) {
            return ResponseEntity.badRequest().body("Error creating record.. Please try again later");
        }
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Vehicle vehicle = vehicleService.read(id);

        if(vehicle == null) {
            return ResponseEntity.badRequest().body("Vehicle with id " + id + " not found.");
        }
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/all")
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.update(vehicle);
        if(updatedVehicle == null) {
            return ResponseEntity.badRequest().body("Error updating record.. Please try again later");
        }
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        boolean status = vehicleService.delete(id);

        if(!status) {
            return ResponseEntity.badRequest().body("Vehicle " + id + " deleted successfully.");
        }
        return ResponseEntity.badRequest().body("Vehicle deleted successfully.");
    }
}