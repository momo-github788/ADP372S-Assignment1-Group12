package za.ac.cput.vehicledealership.service;
/*  UserContactService.java
    Interface for User contact service
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.UserContact;
import java.util.Set;


public interface UserContactService extends IService<UserContact, String>{
    Set<UserContact> getAll();
}
