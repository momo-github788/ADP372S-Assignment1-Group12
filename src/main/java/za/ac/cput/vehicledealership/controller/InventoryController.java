//package za.ac.cput.vehicledealership.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import za.ac.cput.vehicledealership.domain.Inventory;
//import za.ac.cput.vehicledealership.service.impl.InventoryServiceImpl;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryServiceImpl inventoryService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody Inventory inventory) {
//        Inventory inventory1 = inventoryService.create(inventory);
//        if(inventory1 == null) {
//            return ResponseEntity.badRequest().body("Error creating record. PLease try again later.");
//        }
//        return new ResponseEntity<>(inventory1, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/read/{id}")
//    public ResponseEntity<?> get(@PathVariable String id) {
//        Inventory inventory1 =  inventoryService.read(id);
//        if(inventory1 == null) {
//            return ResponseEntity.badRequest().body("Inventory with id " + id + " not found.");
//        }
//        return ResponseEntity.ok(inventory1);
//    }
//
//    @GetMapping("/all")
//    public List<Inventory> getAll() { return inventoryService.getAll(); }
//
//    @PostMapping("/update")
//    public ResponseEntity<?> update(@RequestBody Inventory inventory) {
//        Inventory inventory1 =  inventoryService.update(inventory);
//        if(inventory1 == null) {
//            return ResponseEntity.badRequest().body("Error updating record. PLease try again later.");
//        }
//        return ResponseEntity.ok(inventory1);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable String id) {
//        boolean status = inventoryService.delete(id);
//        if(!status) {
//            return ResponseEntity.badRequest().body("Inventory " + id + " deleted successfully.");
//        }
//        return ResponseEntity.badRequest().body("Inventory deleted successfully.");
//    }
//}