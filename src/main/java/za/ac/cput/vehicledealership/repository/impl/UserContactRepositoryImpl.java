package za.ac.cput.vehicledealership.repository.impl;

import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.repository.UserContactRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*  UserContactRepositoryImpl.java
    Repository Class for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
public class UserContactRepositoryImpl implements UserContactRepository {

    private static UserContactRepositoryImpl userContactRepository = null;
    private Set<UserContact> userContactDB = null;

    private UserContactRepositoryImpl(){
        userContactDB = new HashSet<UserContact>();
    }

    public static UserContactRepositoryImpl getUserContactRepository(){
        if(userContactRepository == null){
            userContactRepository = new UserContactRepositoryImpl();
        }
        return userContactRepository;
    }
    @Override
    public UserContact create(UserContact userContact) {
        boolean success = userContactDB.add(userContact);
        if(!success){
            return null;
        }
        return userContact;
    }

    @Override
    public UserContact read(String userId) {
        UserContact userContact = userContactDB
                .stream()
                .filter(a -> a.getUserId().equals(userId))
                .findAny()
                .orElse(null);
        return userContact;
    }

    @Override
    public UserContact update(UserContact userContact) {
        UserContact oldUserContact = read(userContact.getUserId());
        if(oldUserContact!= null){
            userContactDB.remove(oldUserContact);
            userContactDB.add(userContact);
            return userContact;
        }
        return null;
    }

    @Override
    public boolean delete(String userId) {
        UserContact userContactToDelete = read(userId);
        if(userContactToDelete == null)
            return false;
        userContactDB.remove(userContactToDelete);
        return true;
    }

    @Override
    public Set<UserContact> getAll(){return userContactDB;}


}
