package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.vehicledealership.domain.Branch;
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
        List<Branch> branches = branchService.getAll();

        model.addAttribute("branches", branches);
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


//    @PostMapping(value = "/save")
//    public String save(@ModelAttribute ("branch") Branch branch, Model model) {
//        model.addAttribute("getdata", branch.toString());
//        return "display";
//    }
}
