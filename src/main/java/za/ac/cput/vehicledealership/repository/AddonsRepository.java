package za.ac.cput.vehicledealership.repository;
/*  IAddonsRepository.java
    Repository Interface for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Addons;

import java.util.Set;
@Repository
public interface AddonsRepository extends JpaRepository<Addons, String> {

}
