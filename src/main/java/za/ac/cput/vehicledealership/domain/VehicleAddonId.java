package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
public class VehicleAddonId implements Serializable {

    private String vehicleId;
    private String addonId;

    protected VehicleAddonId() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleAddonId that = (VehicleAddonId) o;
        return Objects.equals(vehicleId, that.vehicleId) && Objects.equals(addonId, that.addonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, addonId);
    }

    @Override
    public String toString() {
        return "VehicleAddonId{" +
                "vehicleId='" + vehicleId + '\'' +
                ", addonId='" + addonId + '\'' +
                '}';
    }
}