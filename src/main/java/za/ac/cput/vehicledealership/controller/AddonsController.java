package za.ac.cput.vehicledealership.controller;
/*  Addonscontroller.java
    Controller for addons
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.service.AddonsService;
import za.ac.cput.vehicledealership.domain.Addons;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/addons")
public class AddonsController {
    @Autowired
    private AddonsService addonsService;

   @PostMapping("/create")
   public Addons create(@RequestBody Addons addons) {
       return addonsService.create(addons);
   }

    @GetMapping("read/{id}")
    public Addons get(@PathVariable String id) {
        return addonsService.read(id);
    }

    @GetMapping("/all")
    public List<Addons> getAll() {
        return addonsService.getAll();
    }

    @PostMapping("/update")
    public Addons update(@RequestBody Addons addons) {
        return addonsService.update(addons);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return addonsService.delete(id);
    }
}
