package za.ac.cput.repository;

/*  NameRepositoryImpl.java
    Implementation of INameRepository
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/

import za.ac.cput.domain.Name;
import java.util.HashSet;
import java.util.Set;

public class NameRepositoryImpl implements INameRepository {

    private static NameRepositoryImpl nameRepository = null;
    private Set<Name> nameDB = null;

    private NameRepositoryImpl() {
        this.nameDB = new HashSet<>();
    }

    public static NameRepositoryImpl getNameRepository() {
        if(nameRepository == null) {
            nameRepository = new NameRepositoryImpl();
        }
        return nameRepository;
    }

    @Override
    public Name create(Name name) {
        boolean success = nameDB.add(name);

        if(!success) {
            return null;
        }
        return name;
    }

    @Override
    public Name read(String firstName) {
        return nameDB
                .stream()
                .filter(name -> name.getFirstName().equals(firstName))
                .findAny()
                .orElse(null);
    }

    @Override
    public Name update(Name name) {
        Name oldName = read(name.getFirstName());

        if(oldName != null) {
            nameDB.remove(oldName);
            nameDB.add(name);
            return name;

        }
        return null;
    }

    @Override
    public boolean delete(String firstName) {
        Name name = read(firstName);

        if(name == null) {
            return false;
        }

        nameDB.remove(name);
        return true;
    }

    @Override
    public Set<Name> getAll() {
        return nameDB;
    }
}
