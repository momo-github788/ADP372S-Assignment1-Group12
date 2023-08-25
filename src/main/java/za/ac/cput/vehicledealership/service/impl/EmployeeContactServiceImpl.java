package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.repository.ContactRepository;
import za.ac.cput.vehicledealership.repository.EmployeeContactRepository;
import za.ac.cput.vehicledealership.service.ContactService;
import za.ac.cput.vehicledealership.service.EmployeeContactService;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.service.EmployeeService;



/*  EmployeeContactServiceImpl.java
    ServiceImpl for employeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/

@Service
public class EmployeeContactServiceImpl implements EmployeeContactService {

    private EmployeeContactRepository employeeContactRepository;
    private ContactService contactService;
    private EmployeeService employeeService;

    public EmployeeContactServiceImpl(EmployeeContactRepository employeeContactRepository, ContactService contactService, EmployeeService employeeService) {
        this.employeeContactRepository = employeeContactRepository;
        this.contactService = contactService;
        this.employeeService = employeeService;
    }


    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        Employee employee = employeeService.read(employeeContact.getEmployeeNumber());
        Contact contact = contactService.read(employeeContact.getContactId());

        if(employee != null && contact != null) {
            return employeeContactRepository.save(employeeContact);
        }
        return null;

    }

    @Override
    public EmployeeContact read(EmployeeContact employeeContact) {

        Employee employee = employeeService.read(employeeContact.getEmployeeNumber());
        Contact contact = contactService.read(employeeContact.getContactId());



        return employeeContactRepository.findById(employeeNumber).orElse(null);
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        if(employeeContactRepository.existsById(employeeContact.getEmployeeNumber())) {
            return this.employeeContactRepository.save(employeeContact);
        }
        return null;
    }

    @Override
    public boolean delete(Long employeeNumber) {
        if(this.employeeContactRepository.existsById(employeeNumber)) {
            this.employeeContactRepository.deleteById(employeeNumber);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeContact> getAll() {
        return employeeContactRepository.findAll();
    }
}

