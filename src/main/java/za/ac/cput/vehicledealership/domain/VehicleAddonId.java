package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class VehicleAddonId implements Serializable {

    private String vehicleId;
    private String addonId;

    protected VehicleAddonId() {

    }

}