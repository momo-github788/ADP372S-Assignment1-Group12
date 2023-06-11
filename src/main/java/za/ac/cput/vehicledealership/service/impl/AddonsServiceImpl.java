package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.repository.impl.AddonsRepositoryImpl;
import za.ac.cput.vehicledealership.repository.impl.VehicleRepositoryImpl;
import za.ac.cput.vehicledealership.service.AddonsService;

import java.util.List;
import java.util.Set;

public class AddonsServiceImpl implements AddonsService {

    private static AddonsServiceImpl addonsService = null;
    private AddonsRepositoryImpl addonsRepository = null;

    public AddonsServiceImpl() {
        this.addonsRepository = AddonsRepositoryImpl.getAddonsRepository();
    }

    public static AddonsServiceImpl getAddonsServiceService() {
        if(addonsService == null) {
            addonsService = new AddonsServiceImpl();
        }
        return addonsService;
    }


    @Override
    public Addons create(Addons addons) {
        return addonsRepository.create(addons);
    }


    @Override
    public Addons read(String addonsId) {
        return addonsRepository.read(addonsId);
    }

    @Override
    public Addons update(Addons addons) {
        return addonsRepository.update(addons);
    }


    @Override
    public boolean delete(String addonsId) {
        return addonsRepository.delete(addonsId);
    }

    @Override
    public Set<Addons> getAll() {
        return addonsRepository.getAll();
    }
}

