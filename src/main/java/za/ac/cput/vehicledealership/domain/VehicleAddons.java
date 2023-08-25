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
@Table(name = "vehicle_addons")
@IdClass(VehicleAddonsId.class)
public class VehicleAddons {
    @Id
    private String vehicleId;
    @Id
    private String addonId;

    public VehicleAddons() {
    }

    public VehicleAddons(Builder builder) {
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

        public Builder copy(VehicleAddons vehicleAddons) {
            this.vehicleId = vehicleAddons.vehicleId;
            this.addonId = vehicleAddons.addonId;
            return this;
        }

        public VehicleAddons build() {
            return new VehicleAddons(this);
        }
    }
}