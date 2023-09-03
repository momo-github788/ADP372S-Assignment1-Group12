package za.ac.cput.vehicledealership.repository;
/*  IContactRepository.java
    Repository Interface for Contact Domain
    Author: Junaid Cedrass (219090912)
    Date: 8 April 2023
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;

@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail, Integer> {
    //List<ContactDetail> findAllByContactIdIn(List<Integer> contactIdList);
    void deleteAllByEmployee(Employee employee);
    boolean existsByValue(String value);
}
