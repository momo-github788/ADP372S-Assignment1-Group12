package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.repository.UserContactRepository;
import za.ac.cput.vehicledealership.service.UserContactService;

import java.util.List;
import java.util.Set;

/*  UserContactServiceImpl.java
    ServiceImpl for userContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
@Service
public class UserContactServiceImpl implements UserContactService {


    private UserContactRepository userContactRepository;

    @Autowired
    public UserContactServiceImpl(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    @Override
    public UserContact create(UserContact userContact) {
        return userContactRepository.save(userContact);
    }

    @Override
    public UserContact read(String userId) {
        return userContactRepository.findById(userId).orElse(null);
    }

    @Override
    public UserContact update(UserContact userContact) {
        if(userContactRepository.existsById(userContact.getUserId())) {
            return this.userContactRepository.save(userContact);
        }
        return null;
    }

    @Override
    public boolean delete(String userId) {
        if(userContactRepository.existsById(userId)) {
            this.userContactRepository.deleteById(userId);
        }
        return false;
    }

    @Override
    public List<UserContact> getAll() {
        return userContactRepository.findAll();
    }
}



