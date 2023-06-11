package za.ac.cput.vehicledealership.repository;
/*  IAddonsRepository.java
    Repository Interface for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/

import za.ac.cput.vehicledealership.domain.Addons;

import java.util.Set;

public interface AddonsRepository extends IRepository<Addons, String>{

    Set<Addons> getAll();
}
