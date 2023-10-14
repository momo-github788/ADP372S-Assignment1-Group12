package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

/*  Addons.java
    Entity for Inventory
    Author: Serge kalala

*/

@Entity
@Getter
@Setter
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;
    private String name;
    private int quantity = 0;
    @Enumerated(EnumType.STRING)
    private InventoryType inventoryType;

    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;


    public Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.quantity =  builder.quantity;
        this.name = builder.name;
        this.inventoryType =  builder.inventoryType;
        this.branch = builder.branch;
    }

    public Inventory() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryId == inventory.inventoryId && quantity == inventory.quantity && Objects.equals(name, inventory.name) && inventoryType == inventory.inventoryType && Objects.equals(branch, inventory.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, name, quantity, inventoryType, branch);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", inventoryType=" + inventoryType +
                ", branch=" + branch +
                '}';
    }

    public static class Builder {

        private int inventoryId;
        private String name;
        private int quantity;
        private InventoryType inventoryType;
//        private List<Vehicle> vehicles;
        private Branch branch;

        public Builder setInventoryId(int inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setInventoryType(InventoryType inventoryType) {
            this.inventoryType = inventoryType;
            return this;
        }

//        public Builder setVehicles(List<Vehicle> vehicles) {
//            this.vehicles = vehicles;
//            return this;
//        }
//
        public Builder setBranch(Branch branch) {
            this.branch = branch;
            return this;
        }


        public Builder copy(Inventory inventory){
            this.inventoryId = inventory.inventoryId;
            this.quantity = inventory.quantity;
            this.inventoryType = inventory.inventoryType;
            this.name = inventory.name;
//            this.vehicles = inventory.vehicles;
            this.branch = inventory.branch;
            return this;
        }
        public Inventory build(){
            return new Inventory(this);
        }
    }
    }

