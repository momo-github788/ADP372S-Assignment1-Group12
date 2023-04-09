package za.ac.cput.repository;
/*  IAddonsRepository.java
    Repository Interface for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/

import za.ac.cput.domain.Addons;

import java.util.Set;

public interface IAddonsRepository extends IRepository<Addons, String>{

    Set<Addons> getAll();
}
