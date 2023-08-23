package za.ac.cput.vehicledealership.service;


import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.domain.VehicleAddons;

import java.util.List;


public interface VehicleAddonsService extends IService<VehicleAddons, String> {
    List<VehicleAddons> getAll();
}
