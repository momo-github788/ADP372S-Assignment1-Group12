package za.ac.cput.repository;

/*  INameRepository.java
    Repository Interface for Name Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/


import za.ac.cput.domain.Name;
import java.util.Set;

public interface INameRepository extends IRepository<Name, String> {
    Set<Name> getAll();
}
