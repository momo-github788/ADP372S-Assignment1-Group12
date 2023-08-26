package za.ac.cput.vehicledealership.repository;
/*  EmployeeContactRepository.java
    Repository Interface for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.domain.EmployeeContactId;


import java.util.List;
import java.util.Set;
@Repository
public interface EmployeeContactRepository extends JpaRepository<EmployeeContact, EmployeeContactId> {
    EmployeeContact findFirstByEmployeeNumberAndContactId(String employeeNumber, String contactId);
    List<EmployeeContact> findAllByEmployeeNumber(String employeeNumber);

}
