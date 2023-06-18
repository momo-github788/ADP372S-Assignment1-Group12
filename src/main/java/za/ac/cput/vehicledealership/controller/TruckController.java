/*  TruckController.java
    Entity for Truck controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Truck;
import za.ac.cput.vehicledealership.service.TruckService;

import java.util.Set;

@RestController
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @PostMapping("/create")
    public Truck create(@RequestBody Truck truck) { return truckService.create(truck); }

    @GetMapping("/read/{id}")
    public Truck read(@PathVariable String id) { return truckService.read(id); }

    @GetMapping("/all")
    public Set<Truck> getAll() { return truckService.getAll(); }

    @PostMapping("/update")
    public Truck update(@RequestBody Truck truck) { return truckService.update(truck); }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {return truckService.delete(id); }
}
