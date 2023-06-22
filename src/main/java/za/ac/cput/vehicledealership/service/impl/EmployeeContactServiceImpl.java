package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.repository.impl.EmployeeContactRepositoryImpl;
import za.ac.cput.vehicledealership.service.EmployeeContactService;

import java.util.Set;
import org.springframework.stereotype.Service;



/*  EmployeeContactServiceImpl.java
    ServiceImpl for employeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/

@Service
public class EmployeeContactServiceImpl implements EmployeeContactService {
    private static EmployeeContactServiceImpl employeeContactService = null;
    private EmployeeContactRepositoryImpl employeeContactRepository = null;

    public EmployeeContactServiceImpl() {
        this.employeeContactRepository = EmployeeContactRepositoryImpl.getEmployeeContactRepository();
    }

    public static EmployeeContactServiceImpl getEmployeeContactService() {
        if(employeeContactService == null) {
            employeeContactService = new EmployeeContactServiceImpl();
        }
        return employeeContactService;
    }


    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        return employeeContactRepository.create(employeeContact);
    }

    @Override
    public EmployeeContact read(Long employeeNumber) {
        return employeeContactRepository.read(employeeNumber);
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        return employeeContactRepository.update(employeeContact);
    }

    @Override
    public boolean delete(Long employeeNumber) {
        return employeeContactRepository.delete(employeeNumber);
    }

    @Override
    public Set<EmployeeContact> getAll() {
        return employeeContactRepository.getAll();
    }
}

