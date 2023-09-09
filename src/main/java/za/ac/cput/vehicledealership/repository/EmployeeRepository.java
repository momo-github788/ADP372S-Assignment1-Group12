package za.ac.cput.vehicledealership.repository;
/*  IEmployeeRepository.java
    Repository Interface for Employee Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
//    Employee findEmployeeByEmailAddress(String emailAddress);
//    Boolean existsByEmailAddress(String emailAddress);
}
