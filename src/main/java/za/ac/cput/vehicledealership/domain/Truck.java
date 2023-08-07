/*  Truck.java
    Entity for Truck
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(name = "truck")
public class Truck extends Vehicle {
    @Column(name = "number_of_wheels")
    protected int numOfWheels;
    @Column(name = "maximum_load_capacity")
    protected double maxLoadCapacity;

    protected Truck() {}

    private Truck(TruckBuilder builder) {
        super(builder);
        this.numOfWheels = builder.numOfWheels;
        this.maxLoadCapacity = builder.maxLoadCapacity;
    }

    public int getNumOfWheels() { return numOfWheels;}
    public double getMaxLoadCapacity() { return maxLoadCapacity;}

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
        return super.toString() +
                "numOfWheels=" + numOfWheels +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    public static class TruckBuilder extends Builder<TruckBuilder> {
        private int numOfWheels;
        private double maxLoadCapacity;

        public TruckBuilder setNumOfWheels(int numOfWheels) {
            this.numOfWheels = numOfWheels;
            return this;
        }
        public TruckBuilder setMaxLoadCapacity(double maxLoadCapacity) {
            this.maxLoadCapacity = maxLoadCapacity;
            return this;
        }

        public TruckBuilder copy(Truck truck) {
            super.copy(truck);
            this.numOfWheels = truck.numOfWheels;
            this.maxLoadCapacity = truck.maxLoadCapacity;
            return this;
        }

        public Truck build() { return new Truck(this);}
    }
}
