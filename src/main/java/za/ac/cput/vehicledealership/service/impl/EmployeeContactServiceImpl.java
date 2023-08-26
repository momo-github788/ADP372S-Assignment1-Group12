package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.repository.ContactRepository;
import za.ac.cput.vehicledealership.repository.EmployeeContactRepository;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.service.ContactService;
import za.ac.cput.vehicledealership.service.EmployeeContactService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.service.EmployeeService;



/*  EmployeeContactServiceImpl.java
    ServiceImpl for employeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/


@Service
public class EmployeeContactServiceImpl {

    private EmployeeContactRepository employeeContactRepository;
    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeContactServiceImpl(EmployeeContactRepository employeeContactRepository, ContactRepository contactRepository, EmployeeRepository employeeRepository) {
        this.employeeContactRepository = employeeContactRepository;
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
    }

    private Employee findById(String employeeNumber) {
        return employeeRepository.findById(employeeNumber).orElse(null);
    }

    public EmployeeContact create(EmployeeContact employeeContact) {
        findById(employeeContact.getEmployeeNumber());
        contactRepository.findById(employeeContact.getContactId()).orElse(null);

        return employeeContactRepository.save(employeeContact);

    }

    public List<Contact> readAllContactsForEmployee(String employeeNumber) {

        findById(employeeNumber);

        List<EmployeeContact> employeeContacts = employeeContactRepository.findAllByEmployeeNumber(employeeNumber);

        List<Contact> contactList = contactRepository.findAllByContactIdIn(
                employeeContacts.stream().map(contact -> contact.getContactId()).collect(Collectors.toList()));

        System.out.println(contactList);

        return contactList;
    }



}

