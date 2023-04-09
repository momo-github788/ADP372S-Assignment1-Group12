package za.ac.cput.repository;
/*  IServicingAddon.java
    Repository Interface for ServicingAddon Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import za.ac.cput.domain.ServicingAddon;

import java.util.Set;

public interface IServicingAddon extends IRepository<ServicingAddon, String> {

        Set<ServicingAddon> getAll();
        }
