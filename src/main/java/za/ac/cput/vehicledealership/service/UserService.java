package za.ac.cput.vehicledealership.service;
/*      UserService.java
        Service interface for User domain
        Author: Junaid Cedrass (219090912)
        Date: 10 June 2023
        */
import za.ac.cput.vehicledealership.domain.User;

import java.util.Set;

public interface UserService extends IService<User, String>{
    Set<User> getAll();
}
