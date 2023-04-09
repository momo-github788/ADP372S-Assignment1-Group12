package za.ac.cput.repository;
/*  IUserRepository.java
    Repository Interface for User Domain
    Author: Junaid Cedrass (219090912)
    Date: 6 April 2023
*/
import za.ac.cput.domain.User;

import java.util.Set;

public interface IUserRepository extends IRepository<User, String>{

    public Set<User> getAll();
}
