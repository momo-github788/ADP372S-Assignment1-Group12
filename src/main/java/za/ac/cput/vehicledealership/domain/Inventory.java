package za.ac.cput.vehicledealership.domain;

public class Inventory {

    private String inventoryId;
    private int quantity;
    private InventoryType inventoryType;
    private Vehicle Vehicle;


    public Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.quantity =  builder.quantity;
        this.inventoryType =  builder.inventoryType;
       this. Vehicle = builder.Vehicle;
    }


    public String getInventoryId() {
        return inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }
    public Vehicle getVehicle() {
        return Vehicle;
    }
    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId='" + inventoryId + '\'' +
                ", quantity=" + quantity +
                ", inventoryType='" + inventoryType + '\'' +
                ", Vehicle=" + Vehicle +
                '}';
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

