package za.ac.cput.vehicledealership.service;


import za.ac.cput.vehicledealership.domain.VehicleAddon;


import java.util.List;


public interface VehicleAddonService extends IService<VehicleAddon, String> {
    List<VehicleAddon> getAll();
}
