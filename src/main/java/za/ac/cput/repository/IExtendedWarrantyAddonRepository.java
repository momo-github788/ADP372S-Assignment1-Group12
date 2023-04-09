package za.ac.cput.repository;
/*  IExtendedWarrantyAddonsRepository.java
    Repository Interface for ExtendedWarrantyAddon Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import za.ac.cput.domain.ExtendedWarrantyAddon;


import java.util.Set;

public interface IExtendedWarrantyAddonRepository extends IRepository<ExtendedWarrantyAddon, String>{
    Set<ExtendedWarrantyAddon> getAll();
}
