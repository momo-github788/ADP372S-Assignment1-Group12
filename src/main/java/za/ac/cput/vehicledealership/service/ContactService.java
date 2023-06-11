package za.ac.cput.vehicledealership.service;
/*
        ContactService.java
        Service interface for Contact domain
        Author: Junaid Cedrass (219090912)
        Date: 10 June 2023
        */
import za.ac.cput.vehicledealership.domain.Contact;

import java.util.Set;

public interface ContactService extends IService<Contact,String> {
    Set<Contact> getAll();
}
