package za.ac.cput.vehicledealership.controller;
/*  Addonscontroller.java
    Controller for addons
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.VehicleAddon;
import za.ac.cput.vehicledealership.service.AddonsService;
import za.ac.cput.vehicledealership.domain.Addon;
import za.ac.cput.vehicledealership.service.impl.VehicleAddonService;

import java.util.List;

@RestController
@RequestMapping("/addons")
public class AddonController {

    @Autowired
    private AddonsService addonsService;
    private VehicleAddonService vehicleAddonService;

    public AddonController(AddonsService addonsService, VehicleAddonService vehicleAddonService) {
        this.addonsService = addonsService;
        this.vehicleAddonService = vehicleAddonService;
    }

    @PostMapping("/create")
   public Addon create(@RequestBody Addon addons) {
       return addonsService.create(addons);
   }

    @GetMapping("read/{id}")
    public Addon get(@PathVariable String id) {
        return addonsService.read(id);
    }

    @GetMapping("/all")
    public List<Addon> getAll() {
        return addonsService.getAll();
    }


    @PostMapping("/createVehicleAddon")
    public ResponseEntity<?> createVehicleAddon(@RequestBody VehicleAddon vehicleAddons) {
        VehicleAddon vehicleAddons1 = vehicleAddonService.create(vehicleAddons);

        if(vehicleAddons1 == null) {
            return ResponseEntity.badRequest().body("Vehicle or Addon with id given does not exist.");
        }
        return new ResponseEntity<>(vehicleAddons1, HttpStatus.CREATED);
    }

    @GetMapping("/allAdons/{vehicleId}")
    public ResponseEntity<?> getVehicleAddons(@PathVariable int vehicleId) {
        List<Addon> addonList =  vehicleAddonService.readAllAddonsForVehicle(vehicleId);
        if(addonList == null) {
            return ResponseEntity.badRequest().body("Vehicle has no addons");
        }
        return ResponseEntity.ok(addonList);
    }

    @PostMapping("/update")
    public Addon update(@RequestBody Addon addons) {
        return addonsService.update(addons);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return addonsService.delete(id);
    }
}
