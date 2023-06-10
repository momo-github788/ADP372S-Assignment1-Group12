/*  Motorcycle.java
    Entity for Motorcycle
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.domain;

import java.util.Objects;

public class Motorcycle extends Vehicle {
    private boolean isHasSideCar;

    private Motorcycle() {}

    private Motorcycle(MotorcycleBuilder builder) {
        super(builder);
        this.isHasSideCar = builder.isHasSideCar;
    }

    public boolean isHasSideCar() { return isHasSideCar;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return isHasSideCar == that.isHasSideCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHasSideCar);
    }

    @Override
    public String toString() {
        return super.toString() +
                "isHasSideCar= " + isHasSideCar +
                '}';
    }

    public static class MotorcycleBuilder extends Vehicle.VehicleBuilder<MotorcycleBuilder> {
        private boolean isHasSideCar;

        public MotorcycleBuilder setHasSideCar(boolean hasSideCar) {
            isHasSideCar = hasSideCar;
            return this;
        }

        public MotorcycleBuilder copy(Motorcycle motorcycle) {
            super.copy(motorcycle);
            this.isHasSideCar = motorcycle.isHasSideCar;
            return this;
        }

        public Motorcycle build() { return new Motorcycle(this);}
    }
}
