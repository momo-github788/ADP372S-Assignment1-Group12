package za.ac.cput.vehicledealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.repository.VehicleAddonsRepository;
import za.ac.cput.vehicledealership.service.VehicleAddonsService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleServiceAddons implements VehicleAddonsService {

    private final VehicleAddonsRepository repository;

    @Override
    public VehicleAddons create(VehicleAddons type) {
        VehicleAddons create=repository.save(type);
        return create;
    }

    @Override
    public VehicleAddons read(String s) {
        VehicleAddons read=repository.getById(s);
        return read;
    }

    @Override
    public VehicleAddons update(VehicleAddons type) {
        VehicleAddons update=repository.save(type);
        return update;
    }

    @Override
    public boolean delete(String s) {
        boolean delete =repository.existsById(s);
        return delete;
    }

    @Override
    public List<VehicleAddons> getAll() {
        return repository.findAll();
    }
}
