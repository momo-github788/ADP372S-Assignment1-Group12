package za.ac.cput.vehicledealership.repository;
/*  UserContactRepositoryImpl.java
    Repository Class for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.UserContact;

import java.util.Set;
@Repository
public interface UserContactRepository extends JpaRepository<UserContact, String> {


}
