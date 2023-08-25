package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.service.BranchService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public Branch create(@RequestBody Branch branch) {
        return branchService.create(branch);
    }

    @GetMapping("read/{id}")
    public Branch get(@PathVariable String id) {
        return branchService.read(id);
    }

    @GetMapping("/all")
    public List<Branch> getAll() {
        return branchService.getAll();
    }

    @PostMapping("/update")
    public Branch update(@RequestBody Branch branch) {
        return branchService.update(branch);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return branchService.delete(id);
    }
}
