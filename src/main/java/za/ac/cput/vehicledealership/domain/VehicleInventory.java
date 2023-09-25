/*
 * WatchListPost.java
 * This is the entity for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */
package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name="vehicle_inventory")
@ToString
@IdClass(VehicleInventoryId.class)
public class VehicleInventory implements Serializable {
    @Id
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Id
    @Column(name = "inventory_id")
    private int inventoryId;

    protected VehicleInventory() {

    }

    private VehicleInventory(Builder builder) {
        this.vehicleId = builder.vehicleId;
        this.inventoryId = builder.inventoryId;
    }


    public static class Builder {
        private int vehicleId;
        private int inventoryId;


        public Builder setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setInventoryId(int inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }


        private Builder copy(VehicleInventory vehicleInventory) {
            this.vehicleId = vehicleInventory.vehicleId;
            this.inventoryId = vehicleInventory.inventoryId;

            return this;
        }

        public VehicleInventory build() {
            return new VehicleInventory(this);
        }
    }
}

