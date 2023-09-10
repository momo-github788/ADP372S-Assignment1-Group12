package za.ac.cput.vehicledealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.VehicleAddonFactory;
import za.ac.cput.vehicledealership.repository.AddonRepository;
import za.ac.cput.vehicledealership.repository.VehicleAddonRepository;
import za.ac.cput.vehicledealership.repository.VehicleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleAddonService {

    private VehicleAddonRepository vehicleAddonRepository;
    private VehicleRepository vehicleRepository;
    private AddonRepository addonsRepository;

    @Autowired
    public VehicleAddonService(VehicleAddonRepository vehicleAddonRepository, VehicleRepository vehicleRepository, AddonRepository addonsRepository) {
        this.vehicleAddonRepository = vehicleAddonRepository;
        this.vehicleRepository = vehicleRepository;
        this.addonsRepository = addonsRepository;
    }



    public VehicleAddon create(VehicleAddon vehicleAddon) {
        Vehicle v = vehicleRepository.findById(vehicleAddon.getVehicleId()).orElse(null);
        Addon a = addonsRepository.findById(vehicleAddon.getAddonId()).orElse(null);

        VehicleAddon vehicleAddon1 = VehicleAddonFactory.createVehicleAddonFactory(v.getVehicleId(), a.getAddonId());
        return vehicleAddonRepository.save(vehicleAddon1);

    }


    public List<Addon> readAllAddonsForVehicle(int vehicleId) {

        vehicleRepository.findById(vehicleId).orElse(null);

        List<VehicleAddon> vehicleAddons = vehicleAddonRepository.findAllByVehicleId(vehicleId);

        List<Addon> addonList = addonsRepository.findAllByAddonIdIn(
                vehicleAddons.stream().map(addon -> addon.getAddonId()).collect(Collectors.toList()));

        System.out.println(addonList);

        return addonList;
    }
}
