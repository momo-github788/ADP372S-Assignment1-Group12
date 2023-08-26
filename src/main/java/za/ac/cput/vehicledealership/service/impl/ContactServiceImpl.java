package za.ac.cput.vehicledealership.service.impl;
/* ContactServiceImpl.java
   Implementation of ContactService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.repository.ContactRepository;
import za.ac.cput.vehicledealership.service.ContactService;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository repository;
    @Autowired
    private ContactServiceImpl(ContactRepository repository){
        this.repository = repository;
    };

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String contactNumber) {
        return this.repository.findById(contactNumber).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        if (this.repository.existsById(contact.getContactId()))
         return this.repository.save(contact);
        return null;
    }

    @Override
    public boolean delete(String contactNumber) {
        if (this.repository.existsById(contactNumber)){
            this.repository.existsById(contactNumber);
            return true;
        }
        return false;
    }

    @Override
    public List<Contact> getAll() {
        return this.repository.findAll();
    }
}

