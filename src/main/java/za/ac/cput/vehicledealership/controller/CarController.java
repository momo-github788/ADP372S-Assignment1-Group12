/*  CarController.java
    Entity for Car controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.service.CarService;

import java.util.Set;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public Car create(@RequestBody Car car) { return carService.create(car); }

    @GetMapping("/read/{id}")
    public Car read(@PathVariable String id) { return carService.read(id); }

    @GetMapping("/all")
    public Set<Car> getAll() { return carService.getAll(); }

    @PostMapping("/update")
    public Car update(@RequestBody Car car) { return carService.update(car); }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {return carService.delete(id); }
}

