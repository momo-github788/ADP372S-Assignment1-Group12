package za.ac.cput.vehicledealership.controller;

/* UserController.java
   Controller class for User Domain
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.UserService;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("read/{id}")
    public User get(@PathVariable String id){return userService.read(id);}

    @GetMapping("/all")
    public Set<User> getAll() {return userService.getAll();}

    @PostMapping("/update")
    public User update(@RequestBody User user){return userService.update(user);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {return userService.delete(id);}
}
