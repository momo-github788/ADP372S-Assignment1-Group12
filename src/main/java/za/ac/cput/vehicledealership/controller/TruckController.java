/*  TruckController.java
    Entity for Truck controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Truck;
import za.ac.cput.vehicledealership.service.TruckService;

import java.util.List;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Truck truck) {
        Truck createdTruck = truckService.create(truck);
        if(createdTruck == null) {
            return ResponseEntity.badRequest().body("Error creating record, please try again later.");
        }
        return new ResponseEntity<>(createdTruck, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        Truck truck = truckService.read(id);
        if(truck == null) {
            return ResponseEntity.badRequest().body("Truck with id " + id + " not found.");
        }
        return ResponseEntity.ok(truck);
    }

    @GetMapping("/getAll")
    public List<Truck> getAll() { return truckService.getAll(); }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Truck truck) {
        Truck updatedTruck = truckService.update(truck);
        if(updatedTruck == null) {
            return ResponseEntity.badRequest().body("Error updating record, please try again later.");
        }
        return ResponseEntity.ok(updatedTruck);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        boolean status = truckService.delete(id);

        if(status) {
            // 204 No Content for successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // 404 Not Found for unsuccessful deletion
            return ResponseEntity.notFound().build();
        }
    }
}
