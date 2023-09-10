package za.ac.cput.vehicledealership.service.impl;
/* ContactServiceImpl.java
   Implementation of ContactService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.repository.ContactDetailRepository;
import za.ac.cput.vehicledealership.service.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailServiceImpl implements ContactService {
    private ContactDetailRepository repository;

    @Autowired
    private ContactDetailServiceImpl(ContactDetailRepository repository){
        this.repository = repository;
    };

    public ContactDetail create(ContactDetail contactDetail) {

        return repository.save(contactDetail);

//        if(!repository.existsByValue(value)) {
//            ContactDetail createdContact = ContactDetailFactory.createContact(contactType, value);
//            System.out.println("Creating contact with type " + contactType + " and value " + value);
//            return repository.save(createdContact);
//        }
//        System.out.println("Contact with this value already exists");
//        return null;


    }

    @Override
    public ContactDetail read(Integer integer) {
        return null;
    }


//    public Set<ContactDetail> getAllContactDetailsForEmployee(int employeeNumber) {
//        Employee employee = employeeService.read(employeeNumber);
//
//    }


    public ContactDetail read(int contactDetailId) {
        return this.repository.findById(contactDetailId).orElse(null);
    }


    public ContactDetail update(ContactDetail contact) {
        if (this.repository.existsById(contact.getContactDetailId()))
         return this.repository.save(contact);
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
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

    @Override
    public ContactDetail getContactDetailById(int id) {
        Optional<ContactDetail> optional = repository.findById(id);
        ContactDetail contactDetail = null;
        if (optional.isPresent()){
            contactDetail = optional.get();
        }else {
            throw new RuntimeException(" Contact Id " + id + "is not found");
        }
        return contactDetail;
    }
    }
