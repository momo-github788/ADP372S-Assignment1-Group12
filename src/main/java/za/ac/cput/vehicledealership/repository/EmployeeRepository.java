package za.ac.cput.vehicledealership.repository;

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
