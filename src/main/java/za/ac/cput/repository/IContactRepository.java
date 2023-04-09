package za.ac.cput.repository;
/*  IContactRepository.java
    Repository Interface for Contact Domain
    Author: Junaid Cedrass (219090912)
    Date: 8 April 2023
*/
import za.ac.cput.domain.Contact;

import java.util.Set;

public interface IContactRepository extends IRepository<Contact, String> {

    public Set<Contact> getAll();
}
