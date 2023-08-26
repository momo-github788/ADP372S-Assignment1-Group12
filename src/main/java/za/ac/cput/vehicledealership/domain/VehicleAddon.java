package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "vehicle_addon")
@IdClass(VehicleAddonId.class)
public class VehicleAddon {
    @Id
    private String vehicleId;
    @Id
    private String addonId;

    public VehicleAddon() {
    }

    public VehicleAddon(Builder builder) {
        this.vehicleId = builder.vehicleId;
        this.addonId = builder.addonId;
    }


    public static class Builder {
        private String vehicleId;
        private String addonId;

        public Builder setVehicleId(String vehicleId) {
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