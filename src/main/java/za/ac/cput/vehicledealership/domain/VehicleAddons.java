package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import lombok.Data;

/*  Addons.java
    Entity for VehicleAddons
    Author: Serge kalala
*/
@Data
public class VehicleAddons {
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicleId")
    @MapsId
    private Vehicle vehicleId;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "addons_id")
    @MapsId
    private  Addons addonId;

    public VehicleAddons() {

    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public VehicleAddons(Builder builder) {
        this.vehicleId =builder.vehicleId;
        this.addonId = builder.addonId;
    }

    public Addons getAddons() {
        return addonId;
    }
    @Override
    public String toString() {
        return "VehicleAddons{" +
                "vehicleId='" + vehicleId + '\'' +
                ", Addons='" + addonId + '\'' +
                '}';
    }

    public static class Builder {

        private Vehicle vehicleId;
        private Addons addonId;
        public Builder setVehicleId(Vehicle vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setAddons(Addons addonId) {
            this.addonId = addonId;
            return this;
        }
        public Builder copy(VehicleAddons vehicleAddons){
            this.vehicleId =vehicleAddons.vehicleId;
            this.addonId= vehicleAddons.addonId;
            return this;
        }
        public VehicleAddons build(){
            return new VehicleAddons(this);
        }
        }
    }


