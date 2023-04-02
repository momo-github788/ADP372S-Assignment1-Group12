/*  Truck.java
    Entity for Truck
    Author: Alan Chapman (220092362)
    Date: 2 April 2023
*/
package za.ac.cput.domain;

import java.util.Objects;

public class Truck {
    private int numOfWheels;
    private int maxLoadCapacity;

    private  Truck() {}

    private Truck(TruckBuilder builder) {
        this.numOfWheels = builder.numOfWheels;
        this.maxLoadCapacity = builder.maxLoadCapacity;
    }

    public int getNumOfWheels() { return numOfWheels;}
    public int getMaxLoadCapacity() { return maxLoadCapacity;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return numOfWheels == truck.numOfWheels && maxLoadCapacity == truck.maxLoadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfWheels, maxLoadCapacity);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "numOfWheels=" + numOfWheels +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    public static class TruckBuilder {
        private int numOfWheels;
        private int maxLoadCapacity;

        public void setNumOfWheels(int numOfWheels) { this.numOfWheels = numOfWheels;}
        public void setMaxLoadCapacity(int maxLoadCapacity) { this.maxLoadCapacity = maxLoadCapacity;}

        public TruckBuilder copy(Truck truck) {
            this.numOfWheels = truck.numOfWheels;
            this.maxLoadCapacity = truck.maxLoadCapacity;
            return this;
        }

        public Truck build() { return new Truck(this);}
    }
}
