package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.VehicleAddon;
import za.ac.cput.vehicledealership.domain.VehicleAddonId;

import java.util.List;

@Repository
public interface VehicleAddonRepository extends JpaRepository<VehicleAddon, VehicleAddonId> {
    VehicleAddon findFirstByVehicleIdAndAddonId(int vehicleId, String addonId);
    List<VehicleAddon> findAllByVehicleId(int vehicleId);

}
