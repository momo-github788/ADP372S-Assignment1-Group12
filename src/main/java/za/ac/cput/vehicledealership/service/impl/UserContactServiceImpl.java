package za.ac.cput.vehicledealership.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.repository.impl.UserContactRepositoryImpl;
import za.ac.cput.vehicledealership.service.UserContactService;
import java.util.Set;

/*  UserContactServiceImpl.java
    ServiceImpl for userContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
@Service
public class UserContactServiceImpl implements UserContactService {
    private static UserContactServiceImpl userContactService = null;
    private UserContactRepositoryImpl userContactRepository = null;

    public UserContactServiceImpl() {
        this.userContactRepository = UserContactRepositoryImpl.getUserContactRepository();
    }

    public static UserContactServiceImpl getUserContactService() {
        if(userContactService == null) {
            userContactService = new UserContactServiceImpl();
        }
        return userContactService;
    }


    @Override
    public UserContact create(UserContact userContact) {
        return userContactRepository.create(userContact);
    }

    @Override
    public UserContact read(String userId) {
        return userContactRepository.read(userId);
    }

    @Override
    public UserContact update(UserContact userContact) {
        return userContactRepository.update(userContact);
    }

    @Override
    public boolean delete(String userId) {
        return userContactRepository.delete(userId);
    }

    @Override
    public Set<UserContact> getAll() {
        return userContactRepository.getAll();
    }
}



