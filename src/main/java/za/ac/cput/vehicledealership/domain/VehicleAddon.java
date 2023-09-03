package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name = "vehicle_addon")
@IdClass(VehicleAddonId.class)
public class VehicleAddon {
    @Id
    private int vehicleId;
    @Id
    private String addonId;

    public VehicleAddon() {
    }

    public VehicleAddon(Builder builder) {
        this.vehicleId = builder.vehicleId;
        this.addonId = builder.addonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleAddon that = (VehicleAddon) o;
        return vehicleId == that.vehicleId && Objects.equals(addonId, that.addonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, addonId);
    }

    @Override
    public String toString() {
        return "VehicleAddon{" +
                "vehicleId=" + vehicleId +
                ", addonId='" + addonId + '\'' +
                '}';
    }

    public static class Builder {
        private int vehicleId;
        private String addonId;

        public Builder setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setAddonId(String addonId) {
            this.addonId = addonId;
            return this;
        }

        public Builder copy(VehicleAddon vehicleAddon) {
            this.vehicleId = vehicleAddon.vehicleId;
            this.addonId = vehicleAddon.addonId;
            return this;
        }

        public VehicleAddon build() {
            return new VehicleAddon(this);
        }
    }
}