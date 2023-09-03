/*  MotorcycleController.java
    Entity for Motorcycle controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.service.MotorcycleService;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Motorcycle motorcycle) {
        Motorcycle createdMotorcycle = motorcycleService.create(motorcycle);
        if(createdMotorcycle == null) {
            return ResponseEntity.badRequest().body("Error creating record, please try again later.");
        }
        return new ResponseEntity<>(createdMotorcycle, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Motorcycle motorcycle =motorcycleService.read(id);
        if(motorcycle == null) {
            return ResponseEntity.badRequest().body("Motorcycle with id " + id + " not found.");
        }
        return ResponseEntity.ok(motorcycle);
    }

    @GetMapping("/getAll")
    public List<Motorcycle> getAll() { return motorcycleService.getAll(); }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Motorcycle motorcycle) {
        Motorcycle updatedMotorcycle = motorcycleService.update(motorcycle);
        if(updatedMotorcycle == null) {
            return ResponseEntity.badRequest().body("Error updating record, please try again later.");
        }
        return ResponseEntity.ok(updatedMotorcycle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean status = motorcycleService.delete(id);

        if(status) {
            // 204 No Content for successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // 404 Not Found for unsuccessful deletion
            return ResponseEntity.notFound().build();
        }
    }
}
