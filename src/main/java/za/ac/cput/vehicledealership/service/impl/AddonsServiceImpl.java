package za.ac.cput.vehicledealership.service.impl;
/*  AddonsServiceImpl.java
    ServiceImpl for addons
    Author: George Tapiwa Charimba (220073465)
    Date: 12 June 2023
*/
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.repository.AddonsRepository;
import za.ac.cput.vehicledealership.service.AddonsService;

import java.util.List;
import java.util.Set;

@Service
public class AddonsServiceImpl implements AddonsService {

    private AddonsRepository addonsRepository;

    public AddonsServiceImpl(AddonsRepository addonsRepository) {
        this.addonsRepository = addonsRepository;
    }

    @Override
    public Addons create(Addons addons) {
        return addonsRepository.save(addons);
    }


    @Override
    public Addons read(String addonsId) {
        return addonsRepository.findById(addonsId).orElse(null);
    }

    @Override
    public Addons update(Addons addons) {
        if(addonsRepository.existsById(addons.getAddonId())) {
            return this.addonsRepository.save(addons);
        }
        return null;
    }


    @Override
    public boolean delete(String addonsId) {
        if(addonsRepository.existsById(addonsId)) {
            this.addonsRepository.deleteById(addonsId);
        }
        return false;
    }

    @Override
    public List<Addons> getAll() {
        return addonsRepository.findAll();
    }
}

