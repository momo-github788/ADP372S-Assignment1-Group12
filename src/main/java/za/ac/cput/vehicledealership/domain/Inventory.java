package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/*  Addons.java
    Entity for Inventory
    Author: Serge kalala

*/
@Entity
@Getter
@ToString
@EqualsAndHashCode
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String inventoryId;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private InventoryType inventoryType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle Vehicle;


    public Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.quantity =  builder.quantity;
        this.inventoryType =  builder.inventoryType;
        this. Vehicle = builder.Vehicle;
    }

    public Inventory() {

    }


    public static class Builder {

        private String inventoryId;
        private int quantity;
        private InventoryType inventoryType;
        private Vehicle Vehicle;

        public Builder setInventoryId(String inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setInventoryType(InventoryType inventoryType) {
            this.inventoryType = inventoryType;
            return this;
        }

        public Builder setVehicle(za.ac.cput.vehicledealership.domain.Vehicle vehicle) {
            Vehicle = vehicle;
            return this;
        }

        public Builder copy(Inventory inventory){
            this.inventoryId = inventory.inventoryId;
            this.quantity = inventory.quantity;
            this.inventoryType = inventory.inventoryType;
            this.Vehicle = inventory.Vehicle;
            return this;
        }
        public Inventory build(){
            return new Inventory(this);
        }
    }
    }

