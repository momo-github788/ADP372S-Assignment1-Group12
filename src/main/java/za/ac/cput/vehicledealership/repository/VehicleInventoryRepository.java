package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.VehicleInventory;
import za.ac.cput.vehicledealership.domain.VehicleInventoryId;
import za.ac.cput.vehicledealership.domain.WatchListPost;

import java.util.List;

@Repository
public interface VehicleInventoryRepository extends JpaRepository<VehicleInventory, VehicleInventoryId> {
    VehicleInventory findFirstByVehicleIdAndInventoryId(int vehicleId, int inventoryId);
    List<VehicleInventory> findAllByInventoryId(int inventoryId);
    void deleteAllByInventoryId(int inventoryId);
}
