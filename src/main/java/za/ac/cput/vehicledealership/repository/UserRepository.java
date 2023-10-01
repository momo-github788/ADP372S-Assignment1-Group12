package za.ac.cput.vehicledealership.repository;
/*  IUserRepository.java
    Repository Interface for User Domain
    Author: Junaid Cedrass (219090912)
    Date: 6 April 2023
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String email);
//    User findUserByContact_EmailAddress(String emailAddress);
//    Boolean existsByContact_EmailAddress(String emailAddress);

}
