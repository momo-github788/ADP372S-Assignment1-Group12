package za.ac.cput.vehicledealership.service.impl;

/*  NameServiceImpl.java
    Implementation of NameService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.service.NameService;
import za.ac.cput.vehicledealership.repository.impl.NameRepositoryImpl;

import java.util.List;

public class NameServiceImpl implements NameService {

    private static NameServiceImpl nameService = null;
    private NameRepositoryImpl nameRepository = null;

    public NameServiceImpl() {
        this.nameRepository = NameRepositoryImpl.getNameRepository();
    }

    public static NameServiceImpl getNameService() {
        if(nameService == null) {
            nameService = new NameServiceImpl();
        }
        return nameService;
    }


    @Override
    public Name create(Name name) {
        return nameRepository.create(name);
    }


    @Override
    public Name read(String firstName) {
        return nameRepository.read(firstName);
    }

    @Override
    public Name update(Name name) {
        return nameRepository.update(name);
    }


    @Override
    public boolean delete(String firstName) {
        return nameRepository.delete(firstName);
    }

    @Override
    public List<Name> getAll() {
        return nameRepository.getAll();
    }
}
