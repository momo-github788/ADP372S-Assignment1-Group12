package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VehicleInventoryId implements Serializable {

    private int vehicleId;
    private int inventoryId;

}