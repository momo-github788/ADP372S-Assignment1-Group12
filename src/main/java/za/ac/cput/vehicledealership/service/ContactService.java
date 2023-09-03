package za.ac.cput.vehicledealership.service;
/*
        ContactService.java
        Service interface for Contact domain
        Author: Junaid Cedrass (219090912)
        Date: 11 June 2023
        */
import za.ac.cput.vehicledealership.domain.ContactDetail;

import java.util.List;

public interface ContactService extends IService<ContactDetail,String> {
    List<ContactDetail> getAll();
}
