/*  MotorcycleController.java
    Entity for Motorcycle controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.service.MotorcycleService;

import java.util.Set;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @PostMapping("/create")
    public Motorcycle create(@RequestBody Motorcycle motorcycle) { return motorcycleService.create(motorcycle); }

    @GetMapping("/read/{id}")
    public Motorcycle read(@PathVariable String id) { return motorcycleService.read(id); }

    @GetMapping("/all")
    public Set<Motorcycle> getAll() { return motorcycleService.getAll(); }

    @PostMapping("/update")
    public Motorcycle update(@RequestBody Motorcycle motorcycle) { return motorcycleService.update(motorcycle); }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) { return motorcycleService.delete(id); }
}
