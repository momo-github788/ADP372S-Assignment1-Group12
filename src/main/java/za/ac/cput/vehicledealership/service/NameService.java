package za.ac.cput.vehicledealership.service;

/*  NameService.java
    Service Interface for Name Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Name;

import java.util.List;

public interface NameService extends IService<Name, String> {
    List<Name> getAll();
}
