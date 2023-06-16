package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.service.LocationService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public Location create(@RequestBody Location location) {
        return locationService.create(location);
    }

    @GetMapping("read/{id}")
    public Location get(@PathVariable String id) {
        return locationService.read(id);
    }

    @GetMapping("/all")
    public Set<Location> getAll() {
        return locationService.getAll();
    }

    @PostMapping("/update")
    public Location update(@RequestBody Location location) {
        return locationService.update(location);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return locationService.delete(id);
    }
}