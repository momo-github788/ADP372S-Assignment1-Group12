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
    public ResponseEntity<?> create(@RequestBody ContactDetail contact){
       ContactDetail createdContactDetail = contactService.create(contact);
       if (createdContactDetail == null){
           return ResponseEntity.badRequest().body("Error creating record. Please try again");
       }
       return new ResponseEntity<>(createdContactDetail, HttpStatus.CREATED);
    }

    @GetMapping("read/{contactDetailId}")
    public ResponseEntity<?> get(@PathVariable int contactDetailId){
        ContactDetail contactDetail = contactService.read(contactDetailId);
        if (contactDetail == null){
            return ResponseEntity.badRequest().body("Use with contact id" + contactDetailId + "not found");
        }
        return ResponseEntity.ok(contactDetail);
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
    public ResponseEntity<?> update(@RequestBody ContactDetail contact){

     ContactDetail updatedContactDetail = contactService.update(contact);
     if (updatedContactDetail == null) {
         return ResponseEntity.badRequest().body("Error updating record. Please try again");
     }
     return ResponseEntity.ok(updatedContactDetail);
    }

    @DeleteMapping("/delete/{contactDetailId}")
    public ResponseEntity<String> delete(@PathVariable int contactDetailId){
        boolean status = contactService.delete(contactDetailId);
        if (status){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
