package za.ac.cput.vehicledealership.service;
/*  AddonsService.java
    Entity for addons service
    Author: George Tapiwa Charimba (220073465)
    Date: 11 June 2023
*/
import za.ac.cput.vehicledealership.domain.Addons;

import java.util.List;
import java.util.Set;

public interface AddonsService extends IService <Addons, String> {
    List<Addons> getAll();

}
