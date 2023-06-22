package za.ac.cput.vehicledealership.repository.impl;

import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.repository.EmployeeContactRepository;

import java.util.HashSet;
import java.util.Set;

/*  IAddonsRepository.java
    Repository Interface for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
public class EmployeeContactRepositoryImpl implements EmployeeContactRepository {
    private static EmployeeContactRepositoryImpl employeeContactRepository = null;
    private Set<EmployeeContact> employeeContactDB = null;

    private EmployeeContactRepositoryImpl(){
        employeeContactDB = new HashSet<EmployeeContact>();
    }

    public static EmployeeContactRepositoryImpl getEmployeeContactRepository(){
        if(employeeContactRepository == null){
            employeeContactRepository = new EmployeeContactRepositoryImpl();
        }
        return employeeContactRepository;
    }
    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        boolean success = employeeContactDB.add(employeeContact);
        if(!success){
            return null;
        }
        return employeeContact;
    }

    @Override
    public EmployeeContact read(Long employeeNumber) {
        return employeeContactDB
                .stream()
                .filter(employeeContact -> employeeContact.getEmployeeNumber() == employeeNumber)
                .findAny()
                .orElse(null);
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        EmployeeContact oldEmployeeContact = read(employeeContact.getEmployeeNumber());
        if(oldEmployeeContact!= null){
            employeeContactDB.remove(oldEmployeeContact);
            employeeContactDB.add(employeeContact);
            return employeeContact;
        }
        return null;
    }

    @Override
    public boolean delete(Long employeeNumber) {
        EmployeeContact employeeContact = read(employeeNumber);

        if(employeeContact == null) {
            return false;
        }

        employeeContactDB.remove(employeeContact);
        return true;
    }

    @Override
    public Set<EmployeeContact> getAll(){return employeeContactDB;}


}