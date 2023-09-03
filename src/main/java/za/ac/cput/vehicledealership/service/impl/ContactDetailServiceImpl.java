package za.ac.cput.vehicledealership.service.impl;
/* ContactServiceImpl.java
   Implementation of ContactService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.factory.ContactDetailFactory;
import za.ac.cput.vehicledealership.repository.ContactDetailRepository;

import java.util.List;
import java.util.Set;

@Service
public class ContactDetailServiceImpl {
    private ContactDetailRepository repository;

    @Autowired
    private ContactDetailServiceImpl(ContactDetailRepository repository){
        this.repository = repository;
    };

    public ContactDetail create(ContactType contactType, String value) {

//        if(!repository.existsByValue(value)) {
            ContactDetail createdContact = ContactDetailFactory.createContact(contactType, value);
            System.out.println("Creating contact with type " + contactType + " and value " + value);
            return repository.save(createdContact);
//        }
//        System.out.println("Contact with this value already exists");
//        return null;


    }

//    public Set<ContactDetail> getAllContactDetailsForEmployee(int employeeNumber) {
//        Employee employee = employeeService.read(employeeNumber);
//
//    }


    public void deleteAll() {
        repository.deleteAll();
    }

    public ContactDetail read(int contactDetailId) {
        return this.repository.findById(contactDetailId).orElse(null);
    }

    public boolean existsByEmailAddress(String emailAddress) {
        return repository.existsByValue(emailAddress);
    }

    public ContactDetail update(ContactDetail contact) {
        if (this.repository.existsById(contact.getContactDetailId()))
         return this.repository.save(contact);
        return null;
    }

    public boolean delete(int contactDetailId) {
        if (this.repository.existsById(contactDetailId)){
            this.repository.existsById(contactDetailId);
            return true;
        }
        return false;
    }

    public List<ContactDetail> getAll() {
        return this.repository.findAll();
    }
}

