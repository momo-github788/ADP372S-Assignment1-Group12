package za.ac.cput.vehicledealership.controller;
/*  UserContactController.java
    Entity for User Contact Controller
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.service.UserContactService;
import java.util.Set;

@RestController
@RequestMapping("/userContact")
public class UserContactController {

    @Autowired
    private UserContactService userContactService;

    @PostMapping("/create")
    public UserContact create(@RequestBody UserContact userContact) {
        return userContactService.create(userContact);
    }

    @GetMapping("read/{id}")
    public UserContact get(@PathVariable String id){return userContactService.read(id);}

    @GetMapping("/all")
    public Set<UserContact> getAll() {return userContactService.getAll();}

    @PostMapping("/update")
    public UserContact update(@RequestBody UserContact userContact){return userContactService.update(userContact);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {return userContactService.delete(id);}
}

