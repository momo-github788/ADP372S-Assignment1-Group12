package za.ac.cput.vehicledealership.service;
/* EmployeeContactService.java
   Interface for User contact service
   Author: George Tapiwa Charimba (220073465)
   Date: 18 June 2023
*/
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.service.IService;

import java.util.Set;

public interface EmployeeContactService extends IService<EmployeeContact, Long> {
    Set<EmployeeContact> getAll();
}
