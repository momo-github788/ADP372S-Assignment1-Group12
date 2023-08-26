package za.ac.cput.vehicledealership.service.impl;
/* ContactServiceImpl.java
   Implementation of ContactService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.repository.ContactRepository;
import za.ac.cput.vehicledealership.service.ContactService;
import java.util.List;

@Service
public class ContactServiceImpl  {
    private ContactRepository repository;


    @Autowired
    private ContactServiceImpl(ContactRepository repository){
        this.repository = repository;
    };

    public Contact create(ContactType contactType, String value) {

        if(!existsByEmailAddress(value)) {
            Contact createdContact = ContactFactory.createContact(contactType, value);
            return repository.save(createdContact);
        }
        System.out.println("Contact with this value already exists");
        return null;


    }

    public Contact read(String contactId) {
        return this.repository.findById(contactId).orElse(null);
    }

    public boolean existsByEmailAddress(String emailAddress) {
        return repository.existsByValue(emailAddress);
    }

    public Contact update(Contact contact) {
        if (this.repository.existsById(contact.getContactId()))
         return this.repository.save(contact);
        return null;
    }

    public boolean delete(String contactNumber) {
        if (this.repository.existsById(contactNumber)){
            this.repository.existsById(contactNumber);
            return true;
        }
        return false;
    }

    public List<Contact> getAll() {
        return this.repository.findAll();
    }
}

