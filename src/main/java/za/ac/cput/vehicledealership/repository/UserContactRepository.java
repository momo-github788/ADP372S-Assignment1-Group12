package za.ac.cput.vehicledealership.repository;
/*  UserContactRepositoryImpl.java
    Repository Class for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import za.ac.cput.vehicledealership.domain.UserContact;

import java.util.Set;

public interface UserContactRepository extends IRepository<UserContact, String> {

    public Set<UserContact> getAll();
}
