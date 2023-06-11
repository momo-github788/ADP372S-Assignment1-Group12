package za.ac.cput.vehicledealership.service.impl;
/* ContactServiceImpl.java
   Implementation of ContactService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.repository.impl.ContactRepositoryImpl;
import za.ac.cput.vehicledealership.service.ContactService;

import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private static ContactServiceImpl contactService = null;

    private ContactRepositoryImpl contactRepositoryImpl = null;

    public ContactServiceImpl(){this.contactRepositoryImpl = ContactRepositoryImpl.getContactRepository();}

    public static ContactServiceImpl getContactService(){
        if(contactService ==null){
            contactService = new ContactServiceImpl();
        }
        return contactService;
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepositoryImpl.create(contact);
    }

    @Override
    public Contact read(String contactNumber) {
        return contactRepositoryImpl.read(contactNumber);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepositoryImpl.update(contact);
    }

    @Override
    public boolean delete(String contactNumber) {
        return contactRepositoryImpl.delete(contactNumber);
    }
    @Override
    public Set<Contact> getAll() {
        return contactRepositoryImpl.getAll();
    }
}
