package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
