package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
