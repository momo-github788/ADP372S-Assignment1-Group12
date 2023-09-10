package za.ac.cput.vehicledealership.service.impl;
/*  AddonsServiceImpl.java
    ServiceImpl for addons
    Author: George Tapiwa Charimba (220073465)
    Date: 12 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Addon;
import za.ac.cput.vehicledealership.repository.AddonRepository;
import za.ac.cput.vehicledealership.service.AddonsService;

import java.util.List;

@Service
public class AddonsServiceImpl implements AddonsService {

    private AddonRepository addonsRepository;

    @Autowired
    public AddonsServiceImpl(AddonRepository addonsRepository) {
        this.addonsRepository = addonsRepository;
    }

    @Override
    public Addon create(Addon addon) {

        return addonsRepository.save(addon);

    }


    @Override
    public Addon read(String addonsId) {
        return addonsRepository.findById(addonsId).orElse(null);
    }

    @Override
    public Addon update(Addon addons) {
        if(addonsRepository.existsById(addons.getAddonId())) {
            return this.addonsRepository.save(addons);
        }
        return null;
    }


    @Override
    public boolean delete(String addonsId) {
        if(addonsRepository.existsById(addonsId)) {
            this.addonsRepository.deleteById(addonsId);
            return true;
        }
        return false;
    }

    @Override
    public List<Addon> getAll() {
        return addonsRepository.findAll();
    }
}

