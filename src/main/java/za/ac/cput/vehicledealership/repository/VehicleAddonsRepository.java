package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.domain.VehicleAddonsId;

import java.util.Set;

@Repository
public interface VehicleAddonsRepository extends JpaRepository<VehicleAddons, VehicleAddonsId> {
    VehicleAddons findFirstByUVehicleIdAndAddonId(String vehicleId, String addonId);

}
