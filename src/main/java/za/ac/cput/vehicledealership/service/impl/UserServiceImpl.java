package za.ac.cput.vehicledealership.service.impl;
/* UserServiceImpl.java
   Implementation of UserService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.service.UserService;

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

    @Override
    public User read(String userId) {
        return this.repository.findById(userId).orElse(null);
    }

    @Override
    public User update(User user) {
        if (this.repository.existsById(user.getUserId()))
            return this.repository.save(user);
        return null;
    }

    @Override
    public boolean delete(String userId) {
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
