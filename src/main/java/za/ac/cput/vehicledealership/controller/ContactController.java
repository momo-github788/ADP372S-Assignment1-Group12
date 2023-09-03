package za.ac.cput.vehicledealership.controller;

/* ContactController.java
   Controller class for Contact Domain
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.service.impl.ContactDetailServiceImpl;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactDetailServiceImpl contactService;
    private UserServiceImpl userService;

    public ContactController(ContactDetailServiceImpl contactService, UserServiceImpl userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ContactDetail create(@RequestBody ContactDetail contact){
        return contactService.create(contact.getContactType(), contact.getValue());
    }

    @GetMapping("read/{contactDetailId}")
    public ContactDetail get(@PathVariable int contactDetailId){
        return contactService.read(contactDetailId);
    }

    @GetMapping("/all")
    public List<ContactDetail> getAll() {
        return contactService.getAll();
    }


//    @GetMapping("/allContacts/{userId}")
//    public ResponseEntity<?> getUserContacts(@PathVariable int userId) {
//        List<ContactDetail> contactList =  contactService.readAllContactsForUser(userId);
//        if(contactList == null) {
//            return ResponseEntity.badRequest().body("User has no contacts");
//        }
//        return ResponseEntity.ok(contactList);
//    }


    @PostMapping("/update")
    public ContactDetail update(@RequestBody ContactDetail contact){

        return contactService.update(contact);
    }

    @DeleteMapping("/delete/{contactDetailId}")
    public boolean delete(@PathVariable int contactDetailId){

        return contactService.delete(contactDetailId);
    }


}
