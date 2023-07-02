package za.ac.cput.vehicledealership.repository;

/*  INameRepository.java
    Repository Interface for Name Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Name;

import java.util.List;
@Repository
public interface NameRepository extends JpaRepository<Name, String> {

}
