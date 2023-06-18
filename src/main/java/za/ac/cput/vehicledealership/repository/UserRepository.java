package za.ac.cput.vehicledealership.repository;
/*  IUserRepository.java
    Repository Interface for User Domain
    Author: Junaid Cedrass (219090912)
    Date: 6 April 2023
*/
import za.ac.cput.vehicledealership.domain.User;

import java.util.Set;

public interface UserRepository extends IRepository<User, String>{

     Set<User> getAll();
}
