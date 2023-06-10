package za.ac.cput.vehicledealership.repository;
/*  IContactRepository.java
    Repository Interface for Contact Domain
    Author: Junaid Cedrass (219090912)
    Date: 8 April 2023
*/
import za.ac.cput.vehicledealership.domain.Contact;

import java.util.Set;

public interface ContactRepository extends IRepository<Contact, String> {

    public Set<Contact> getAll();
}
