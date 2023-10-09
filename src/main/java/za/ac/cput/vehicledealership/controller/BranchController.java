package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.service.BranchService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/branch")
@CrossOrigin
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Branch branch) {

        Branch branch1 = branchService.create(branch);

        if(branch1 !=null) {
            return ResponseEntity.ok(branch1);
        }

        return ResponseEntity.badRequest().body("Branch already exists");
    }

    @GetMapping("read/{id}")
    public Branch get(@PathVariable int id) {
        return branchService.read(id);
    }

    @GetMapping("/all")
    public List<Branch> getAll() {
        return branchService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Branch branch) {
        Branch branch1 = branchService.update(branch);

        if(branch1 !=null) {
            return ResponseEntity.ok(branch1);
        }

        return ResponseEntity.badRequest().body("Branch already exists");
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return branchService.delete(id);
    }
}
