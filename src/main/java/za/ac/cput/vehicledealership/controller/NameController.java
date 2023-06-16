package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.service.NameService;


import java.util.List;

@RestController
@RequestMapping("/name")
public class NameController {

    @Autowired
    private NameService nameService;

    @PostMapping("/create")
    public Name create(@RequestBody Name name) {
        return nameService.create(name);
    }

    @GetMapping("read/{id}")
    public Name get(@PathVariable String id) {
        return nameService.read(id);
    }

    @GetMapping("/all")
    public List<Name> getAll() {
        return nameService.getAll();
    }

    @PostMapping("/update")
    public Name update(@RequestBody Name name) {
        return nameService.update(name);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return nameService.delete(id);
    }
}