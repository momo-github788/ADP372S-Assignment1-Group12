package za.ac.cput.vehicledealership.repository;
/*  EmployeeContactRepository.java
    Repository Interface for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/

import za.ac.cput.vehicledealership.domain.EmployeeContact;

import java.util.Set;

public interface EmployeeContactRepository extends IRepository<EmployeeContact, Long>{

    Set<EmployeeContact> getAll();
}
