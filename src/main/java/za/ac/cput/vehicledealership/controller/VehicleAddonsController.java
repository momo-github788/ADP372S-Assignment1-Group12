package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.service.impl.ServiceVehicleAddons;

import java.util.List;

@RestController
@RequestMapping("/VehicleAddons")
public class VehicleAddonsController {


    @Autowired
    private ServiceVehicleAddons serviceVehicleAddons;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehicleAddons vehicleAddons) {
        VehicleAddons vehicleAddons1 = serviceVehicleAddons.create(vehicleAddons);
        if(vehicleAddons1 == null) {
            return ResponseEntity.badRequest().body("Error creating record. PLease try again later.");
        }
        return new ResponseEntity<>(vehicleAddons1, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        VehicleAddons vehicleAddons1 =  serviceVehicleAddons.read(id);
        if(vehicleAddons1 == null) {
            return ResponseEntity.badRequest().body("vehicleAddons with id " + id + " not found.");
        }
        return ResponseEntity.ok(vehicleAddons1);
    }

    @GetMapping("/all")
    public List<VehicleAddons> getAll() { return serviceVehicleAddons.getAll(); }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody VehicleAddons vehicleAddons) {

        VehicleAddons vehicleAddons1 = serviceVehicleAddons.update(vehicleAddons);
        if(vehicleAddons1 == null) {
            return ResponseEntity.badRequest().body("Error updating record. PLease try again later.");
        }
        return ResponseEntity.ok(vehicleAddons1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        boolean status = serviceVehicleAddons.delete(id);
        if(!status) {
            return ResponseEntity.badRequest().body("VehicleAddons " + id + " deleted successfully.");
        }
        return ResponseEntity.badRequest().body("VehicleAddons deleted successfully.");
    }

}
