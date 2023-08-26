package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.repository.ContactRepository;
import za.ac.cput.vehicledealership.repository.UserContactRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.service.UserContactService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*  UserContactServiceImpl.java
    ServiceImpl for userContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
@Service
public class UserContactServiceImpl {


    private UserContactRepository userContactRepository;
    private UserRepository userRepository;
    private ContactRepository contactRepository;

    @Autowired
    public UserContactServiceImpl(UserContactRepository userContactRepository, UserRepository userRepository, ContactRepository contactRepository) {
        this.userContactRepository = userContactRepository;
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    private User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserContact create(UserContact userContact) {
        findById(userContact.getUserId());
        contactRepository.findById(userContact.getContactId()).orElse(null);

        return userContactRepository.save(userContact);

    }

    public List<Contact> readAllContactsForUser(String userId) {

        findById(userId);

        List<UserContact> userContacts = userContactRepository.findAllByUserId(userId);

        List<Contact> contactList = contactRepository.findAllByContactIdIn(
                userContacts.stream().map(contact -> contact.getContactId()).collect(Collectors.toList()));

        System.out.println(contactList);

        return contactList;
    }
}



