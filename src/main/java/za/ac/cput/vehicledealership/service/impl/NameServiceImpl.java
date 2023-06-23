package za.ac.cput.vehicledealership.service.impl;

/*  NameServiceImpl.java
    Implementation of NameService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.repository.NameRepository;
import za.ac.cput.vehicledealership.service.NameService;
import java.util.List;

@Service
public class NameServiceImpl implements NameService {


    private NameRepository nameRepository;

    public NameServiceImpl(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Override
    public Name create(Name post) {
        return nameRepository.save(post);
    }

    @Override
    public Name read(String postId) {
        return nameRepository.findById(postId)
                .orElse(null);
    }

    @Override
    public Name update(Name name) {
        if(this.nameRepository.existsById(name.getNameId().getFirstName())) {
            return this.nameRepository.save(name);
        }
        return null;
    }

    @Override
    public boolean delete(String nameId) {
        if(this.nameRepository.existsById(nameId)) {
            this.nameRepository.deleteById(nameId);
            return true;
        }
        return false;
    }

    @Override
    public List<Name> getAll() {
        return nameRepository.findAll();
    }
}
