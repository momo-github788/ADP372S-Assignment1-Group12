package za.ac.cput.vehicledealership.service.impl;
/* UserServiceImpl.java
   Implementation of UserService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceImpl {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleService roleService) {
        this.repository = repository;
    }

    public User readByEmailAddress(String emailAddress) {
        User user = repository.findByEmailAddress(emailAddress);

        if(user!=null){
            return this.repository.findByEmailAddress(emailAddress);
        }
        System.out.println("User " + emailAddress + " not exist");
        return null;

    }


    public User read(Integer userId) {
        return this.repository.findById(userId).orElse(null);
    }

    public User read(String email) {
        return this.repository.findByEmailAddress(email);
    }


    public User update(User user) {
        if (this.repository.existsById(user.getUserId())) {
            System.out.println("user exists with id " + user.getUserId());
            return this.repository.save(user);
        }
        System.out.println("user with id " + user.getUserId() + " doesnt ecist");
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

    public boolean delete(Integer userId) {
        if (this.repository.existsById(userId)){
            this.repository.deleteById(userId);
            return true;
        }
        return false;
    }


    public List<User> getAll() {
        return this.repository.findAll();
    }


    public void saveUser(User user) {
        this.repository.save(user);
    }


    public User getUserById(Integer id) {
        Optional<User> optional = repository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        }else {
            throw new RuntimeException("User not found with id ::" + id);
        }
        return user;
    }
}
