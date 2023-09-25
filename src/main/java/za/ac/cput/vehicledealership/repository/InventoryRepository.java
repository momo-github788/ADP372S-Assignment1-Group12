package za.ac.cput.vehicledealership.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Inventory;

import java.util.Set;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    boolean existsByName(String name);
}
