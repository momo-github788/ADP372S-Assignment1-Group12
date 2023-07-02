package za.ac.cput.vehicledealership.controller;

/* ContactController.java
   Controller class for Contact Domain
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.service.ContactService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact);
    }

    @GetMapping("read/{contactNumber}")
    public Contact get(@PathVariable String contactNumber){
        return contactService.read(contactNumber);
    }

    @GetMapping("/all")
    public List<Contact> getAll() {
        return contactService.getAll();
    }
    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){

        return contactService.update(contact);
    }

    @DeleteMapping("/delete/{contactNumber}")
    public boolean delete(@PathVariable String contactNumber){

        return contactService.delete(contactNumber);
    }


}
