package za.ac.cput.vehicledealership.service.impl;
/* UserServiceImpl.java
   Implementation of UserService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    public User readByEmailAddress(String emailAddress) {
        User user = repository.findByEmailAddress(emailAddress);

        if(user!=null){
            return this.repository.findByEmailAddress(emailAddress);
        }
        System.out.println("User " + emailAddress + " not exist");
        return null;

    }

    @Override
    public User read(Integer userId) {
        return this.repository.findById(userId).orElse(null);
    }

    @Override
    public User update(User user) {
        if (this.repository.existsById(user.getUserId()))
            return this.repository.save(user);
        return null;
    }

    public Set<ContactDetail> getContactsByUserId(int userId) {
        User user = repository.findById(userId).orElse(null);

        if (user != null) {
            System.out.println("getContactsByUserId");
            System.out.println(user.getContactDetails());
            return user.getContactDetails();
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean delete(Integer userId) {
        if (this.repository.existsById(userId)){
            this.repository.existsById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }
}
