//package za.ac.cput.vehicledealership.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import za.ac.cput.vehicledealership.domain.Employee;
//import za.ac.cput.vehicledealership.domain.Location;
//import za.ac.cput.vehicledealership.domain.Post;
//import za.ac.cput.vehicledealership.domain.Vehicle;
//import za.ac.cput.vehicledealership.service.LocationService;
//
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/location")
//public class LocationController {
//
//    @Autowired
//    private LocationService locationService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody Location location) {
//        Location createdLocation = locationService.update(location);
//        if(createdLocation == null) {
//            return ResponseEntity.badRequest().body("Error creating record.. Please try again later");
//        }
//        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
//    }
//
//    @GetMapping("read/{id}")
//    public ResponseEntity<?> get(@PathVariable String id) {
//        Location location = locationService.read(id);
//
//        if(location == null) {
//            return ResponseEntity.badRequest().body("Location with id " + id + " not found.");
//        }
//        return ResponseEntity.ok(location);
//    }
//
//    @GetMapping("/all")
//    public Set<Location> getAll() {
//        return locationService.getAll();
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<?> update(@RequestBody Location location) {
//        Location updatedLocation = locationService.update(location);
//        if(updatedLocation == null) {
//            return ResponseEntity.badRequest().body("Error updating record.. Please try again later");
//        }
//        return ResponseEntity.ok(updatedLocation);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable String id) {
//        boolean status = locationService.delete(id);
//
//        if(!status) {
//            return ResponseEntity.badRequest().body("Location " + id + " deleted successfully.");
//        }
//        return ResponseEntity.badRequest().body("Location deleted successfully.");
//    }
//}