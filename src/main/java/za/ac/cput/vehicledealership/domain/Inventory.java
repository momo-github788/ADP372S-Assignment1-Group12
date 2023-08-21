package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
@Getter
@ToString
public class Inventory {

    private String inventoryId;
    private int quantity;
    private InventoryType inventoryType;

    @JoinColumn(name = "branch_id",  referencedColumnName = "branch_id")
    @OneToOne
    private Branch branch;




    public Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.quantity =  builder.quantity;
        this.inventoryType =  builder.inventoryType;
    }


    public static class Builder {

        private String inventoryId;
        private int quantity;
        private InventoryType inventoryType;
        private List<Vehicle> vehicles;

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

