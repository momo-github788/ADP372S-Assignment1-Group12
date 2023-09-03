/*  CarController.java
    Entity for Car controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Car car) {
        Car createdCar = carService.create(car);
        if(createdCar == null) {
            return ResponseEntity.badRequest().body("Error creating record. PLease try again later.");
        }
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Car car = carService.read(id);
        if(car == null) {
            return ResponseEntity.badRequest().body("Car with id " + id + " not found.");
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping("/getAll")
    public List<Car> getAll() { return carService.getAll(); }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Car car) {
        Car updatedCar = carService.update(car);
        if(updatedCar == null) {
            return ResponseEntity.badRequest().body("Error updating record. PLease try again later.");
        }
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean status = carService.delete(id);
        if(status) {
            // 204 No Content for successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // 404 Not Found for unsuccessful deletion
            return ResponseEntity.notFound().build();
        }
    }
}

