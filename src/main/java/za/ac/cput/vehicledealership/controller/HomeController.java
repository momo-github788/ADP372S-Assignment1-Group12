package za.ac.cput.vehicledealership.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.ac.cput.vehicledealership.domain.Automobile;
import za.ac.cput.vehicledealership.domain.Inventory;
import za.ac.cput.vehicledealership.domain.Search;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.service.impl.InventoryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/vehicle-dealer")
public class HomeController {
    private List<Automobile> cars = new ArrayList<>();



    private  final InventoryServiceImpl inventoryService;

    public HomeController(InventoryServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
        cars.add(new Automobile("Mazder","3","zwe888888"));
        cars.add(new Automobile("Benz","C101","esd00888"));
            cars.add(new Automobile("Audi","f4","uu999988"));
    }

    @GetMapping("")
    public ModelAndView homepage(Model model ){
        Search search=new Search();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("automobile",cars);
        modelAndView.addObject("query",search);

        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchResults(@ModelAttribute Search query) {
        List<Automobile> carsFound=cars.stream().filter(car->car.getName().toLowerCase().contains(query.getSearch().toLowerCase()))
             .collect(Collectors.toList());
        System.out.println("----->"+query);
        System.out.println(carsFound);

        ModelAndView modelAndView=new ModelAndView("search");
        modelAndView.addObject("carsFound",carsFound);
        return modelAndView;

//        inventoryService.searchByType(query);
//        return inventoryService.searchByType(query);
    }
    public static void main(String[] args) {
        List <Vehicle> list=new ArrayList<>();

    }

}
