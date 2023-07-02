package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.VehicleAddons;

import java.util.Set;

@Repository
public interface VehicleAddonsRepository extends JpaRepository<VehicleAddons,String> {

}
