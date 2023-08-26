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
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.service.ContactService;
import za.ac.cput.vehicledealership.service.EmployeeContactService;
import za.ac.cput.vehicledealership.service.UserContactService;
import za.ac.cput.vehicledealership.service.impl.ContactServiceImpl;
import za.ac.cput.vehicledealership.service.impl.EmployeeContactServiceImpl;
import za.ac.cput.vehicledealership.service.impl.UserContactServiceImpl;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;
    private UserContactServiceImpl userContactService;
    private EmployeeContactServiceImpl employeeContactService;

    public ContactController(ContactServiceImpl contactService, UserContactServiceImpl userContactService, EmployeeContactServiceImpl employeeContactService) {
        this.contactService = contactService;
        this.userContactService = userContactService;
        this.employeeContactService = employeeContactService;
    }

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact.getContactType(), contact.getValue());
    }

    @GetMapping("read/{contactNumber}")
    public Contact get(@PathVariable String contactNumber){
        return contactService.read(contactNumber);
    }

    @GetMapping("/all")
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    @PostMapping("/createUserContact")
    public ResponseEntity<?> createUserContact(@RequestBody UserContact userContact) {
        UserContact userContact1 = userContactService.create(userContact);

        if(userContact1 == null) {
            return ResponseEntity.badRequest().body("User or Contact with id given does not exist.");
        }
        return new ResponseEntity<>(userContact1, HttpStatus.CREATED);
    }

    @GetMapping("/allContacts/{userId}")
    public ResponseEntity<?> getUserContacts(@PathVariable String userId) {
        List<Contact> contactList =  userContactService.readAllContactsForUser(userId);
        if(contactList == null) {
            return ResponseEntity.badRequest().body("User has no contacts");
        }
        return ResponseEntity.ok(contactList);
    }


    @PostMapping("/createEmployeeContact")
    public ResponseEntity<?> createEmployeeContact(@RequestBody EmployeeContact employeeContact) {
        EmployeeContact employeeContact1 = employeeContactService.create(employeeContact);

        if(employeeContact1 == null) {
            return ResponseEntity.badRequest().body("Employee or Contact with id given does not exist.");
        }
        return new ResponseEntity<>(employeeContact1, HttpStatus.CREATED);
    }


    @GetMapping("/allContacts/{employeeId}")
    public ResponseEntity<?> getEmployeeContacts(@PathVariable String employeeId) {
        List<Contact> contactList =  employeeContactService.readAllContactsForEmployee(employeeId);
        if(contactList == null) {
            return ResponseEntity.badRequest().body("Employee has no contacts");
        }
        return ResponseEntity.ok(contactList);
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
