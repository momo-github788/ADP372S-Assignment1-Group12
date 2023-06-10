package za.ac.cput.vehicledealership.repository;

import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends IRepository<Employee, Long> {
    List<Employee> getAll();
}
