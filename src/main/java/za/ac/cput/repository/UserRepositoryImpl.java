package za.ac.cput.repository;
/*  UserRepositoryImpl.java
    Implementation of IUserRepository
    Author: Junaid Cedrass (219090912)
    Date: 6 April 2023
*/
import za.ac.cput.domain.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements IUserRepository {

    private static UserRepositoryImpl repository = null;
    private Set<User> userDB = null;

    private UserRepositoryImpl() {
        userDB = new HashSet<User>();
    }

    public static UserRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new UserRepositoryImpl();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        boolean success = userDB.add(user);
        if (!success)
            return null;
        return user;
    }

    @Override
    public User read(String userId) {
        User user = userDB.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findAny()
                .orElse(null);
        return user;
    }

    @Override
    public User update(User user) {
        User oldUser = read(user.getUserId());
        if (oldUser != null) {
            userDB.remove(oldUser);
            userDB.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(String userId) {
        User userToDelete = read(userId);
        if (userToDelete == null)
            return false;
        userDB.remove(userToDelete);
        return true;
    }

    @Override
    public Set<User> getAll() {
        return userDB;
    }
}
