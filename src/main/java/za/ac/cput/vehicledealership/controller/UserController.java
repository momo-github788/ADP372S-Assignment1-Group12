package za.ac.cput.vehicledealership.controller;

/* UserController.java
   Controller class for User Domain
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.UserService;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        User user = userService.read(id);
        if (user == null){
            return ResponseEntity.badRequest().body("User with id" + id + "not found");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public List<User> getAll() {return userService.getAll();}

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
        User updatedUser = userService.update(user);
        if (updatedUser == null){
            return ResponseEntity.badRequest().body("Error updating record. Please try again");
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean status = userService.delete(id);
        if (status) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
