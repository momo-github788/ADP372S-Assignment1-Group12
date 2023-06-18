package za.ac.cput.vehicledealership.service.impl;
/* UserServiceImpl.java
   Implementation of UserService
   Author: Junaid Cedrass (219090912)
   Date: 11 June 2023
 */

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.repository.impl.UserRepositoryImpl;
import za.ac.cput.vehicledealership.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService = null;
    private UserRepositoryImpl userRepository = null;

    public UserServiceImpl(){this.userRepository = UserRepositoryImpl.getRepository();}

    public static UserServiceImpl getUserService(){
        if(userService == null){
            userService = new UserServiceImpl();
        }
        return userService;
    }
    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User read(String userId) {
        return userRepository.read(userId);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean delete(String userId) {
        return userRepository.delete(userId);
    }

    @Override
    public Set<User> getAll() {
        return userRepository.getAll();
    }
}
