package za.ac.cput.vehicledealership.service;
/*  AddonsService.java
    Entity for addons service
    Author: George Tapiwa Charimba (220073465)
    Date: 11 June 2023
*/
import za.ac.cput.vehicledealership.domain.Addon;

import java.util.List;

public interface AddonsService extends IService <Addon, String> {
    List<Addon> getAll();

}
