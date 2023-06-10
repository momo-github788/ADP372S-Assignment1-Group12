package za.ac.cput.vehicledealership.repository.impl;

import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl employeeRepository = null;
    private List<Employee> employeeDb = null;

    public EmployeeRepositoryImpl() {
        this.employeeDb = new ArrayList<>();
    }

    public static EmployeeRepositoryImpl getEmployeeRepository() {
        if(employeeRepository == null) {
            employeeRepository = new EmployeeRepositoryImpl();
        }
        return employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        boolean success = employeeDb.add(employee);

        if(!success) {
            return null;
        }
        return employee;
    }

    @Override
    public Employee read(Long employeeId) {
        return employeeDb
                .stream()
            .filter(employee -> employee.getEmployeeNumber() == employeeId)
            .findAny()
            .orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        Employee oldEmployee = read(employee.getEmployeeNumber());

        if(oldEmployee != null) {
            employeeDb.remove(oldEmployee);
            employeeDb.add(employee);
            return employee;

        }
        return null;
    }

    @Override
    public boolean delete(Long employeeNumber) {
        Employee employee = read(employeeNumber);

        if(employee == null) {
            return false;
        }

        employeeDb.remove(employee);
        return true;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDb;
    }

}
