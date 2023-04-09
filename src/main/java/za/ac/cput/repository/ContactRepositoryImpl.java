package za.ac.cput.repository;
/*  ContactRepositoryImpl.java
    Repository Class for Contact Domain
    Author: Junaid Cedrass (219090912)
    Date: 8 April 2023
*/
import za.ac.cput.domain.Contact;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImpl implements IContactRepository {

    private static ContactRepositoryImpl contactRepository = null;
    private Set<Contact> contactDB = null;

    private ContactRepositoryImpl(){
        contactDB = new HashSet<Contact>();
    }

    public static ContactRepositoryImpl getContactRepository() {
        if (contactRepository == null) {
            contactRepository = new ContactRepositoryImpl();
        }
        return contactRepository;
    }


    @Override
    public Contact create(Contact contact) {
        boolean success = contactDB.add(contact);
        if(!success)
        return null;
            return contact;
    }

    @Override
    public Contact read(String contactNumber) {
        Contact contact = contactDB.stream().filter(c -> c.getContactNumber().equals(contactNumber))
                .findAny()
                .orElse(null);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        Contact oldContact = read(contact.getContactNumber());
        if(oldContact !=null){
            contactDB.remove(oldContact);
            contactDB.add(contact);
            return contact;
        }
        return null;
    }

    @Override
    public boolean delete(String contactNumber) {
        Contact contactToDelete = read(contactNumber);
        if (contactToDelete == null)
        return false;
        contactDB.remove(contactToDelete);
        return true;
    }

    @Override
    public Set<Contact> getAll() {
        return contactDB;
    }
}
