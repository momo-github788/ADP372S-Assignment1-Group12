package za.ac.cput.vehicledealership.repository;

/*  INameRepository.java
    Repository Interface for Name Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/


import za.ac.cput.vehicledealership.domain.Name;

import java.util.List;

public interface NameRepository extends IRepository<Name, String> {
    List<Name> getAll();
}
