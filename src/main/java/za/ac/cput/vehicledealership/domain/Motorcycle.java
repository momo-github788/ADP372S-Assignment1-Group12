/*  Motorcycle.java
    Entity for Motorcycle
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle {
    @Column(name = "side_car")
    protected boolean hasSideCar;

    protected Motorcycle() {}

    protected Motorcycle(MotorcycleBuilder builder) {
        super(builder);
        this.hasSideCar = builder.hasSideCar;
    }

    public boolean isHasSideCar() { return hasSideCar;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return hasSideCar == that.hasSideCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasSideCar);
    }

    @Override
    public String toString() {
        return super.toString() +
                "hasSideCar= " + hasSideCar +
                '}';
    }

    public static class MotorcycleBuilder extends Builder<MotorcycleBuilder> {
        private boolean hasSideCar;

        public MotorcycleBuilder setHasSideCar(boolean hasSideCar) {
            this.hasSideCar = hasSideCar;
            return this;
        }

        public MotorcycleBuilder copy(Motorcycle motorcycle) {
            super.copy(motorcycle);
            this.hasSideCar = motorcycle.hasSideCar;
            return this;
        }

        public Motorcycle build() { return new Motorcycle(this);}
    }
}
