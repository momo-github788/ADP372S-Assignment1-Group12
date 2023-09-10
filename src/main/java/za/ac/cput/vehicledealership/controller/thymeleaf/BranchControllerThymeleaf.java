package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.service.impl.BranchServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BranchControllerThymeleaf {

    private BranchServiceImpl branchService;

    @Autowired
    public BranchControllerThymeleaf(BranchServiceImpl branchService) {
        this.branchService = branchService;
    }

    @GetMapping(value = "/create-branch")
    public String showCreateBranchForm(Model model) {
        //List<Branch> branches = branchService.getAll();

        //model.addAttribute("branches", branches);
        model.addAttribute("branch", new Branch());
        return "create-branch";
    }

    @PostMapping(value = "/create-branch")
    public String submitCreateBranchForm(@ModelAttribute Branch branch) {


        System.out.println("created branch");
        System.out.println(branch);
        branchService.create(branch);
        return "redirect:/";
    }

    @GetMapping(value = "/branches/{branchId}")
    public String showEditBranchForm(@PathVariable int branchId, Model model) {
        Branch branch = branchService.read(branchId);

        if(branch==null){
            return "not-found";
        }

        model.addAttribute("branch", branch);

        return "edit-branch";
    }

    @PostMapping(value = "/edit-branch")
    public String submitEditBranchForm(@ModelAttribute Branch branch) {


        System.out.println("edited branch");
        System.out.println(branch);
        branchService.update(branch);
        return "redirect:/branches";
    }

    @PostMapping(value = "branches/{branchId}")
    public String deleteBranch(@PathVariable int branchId) {

        boolean result = branchService.delete(branchId);

        if(result) {
            return "redirect:/branches";
        }

        return "not-found";

    }

    @GetMapping(value = "/branches")
    public String showAllBranches(Model model) {
        List<Branch> branchList = branchService.getAll();

        model.addAttribute("branchList", branchList);
        return "branch-list";
    }




//    @PostMapping(value = "/save")
//    public String save(@ModelAttribute ("branch") Branch branch, Model model) {
//        model.addAttribute("getdata", branch.toString());
//        return "display";
//    }
}
