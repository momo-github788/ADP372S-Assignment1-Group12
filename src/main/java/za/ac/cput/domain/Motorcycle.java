/*  Motorcycle.java
    Entity for Motorcycle
    Author: Alan Chapman (220092362)
    Date: 2 April 2023
*/
package za.ac.cput.domain;

import java.util.Objects;

public class Motorcycle {
    private boolean isHasSideCar;

    private Motorcycle() {}

    private Motorcycle(MotorcycleBuilder builder) {
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
        return "Motorcycle{" +
                "isHasSideCar=" + isHasSideCar +
                '}';
    }

    public static class MotorcycleBuilder {
        private boolean isHasSideCar;

        public boolean isHasSideCar() { return isHasSideCar;}

        public MotorcycleBuilder copy(Motorcycle motorcycle) {
            this.isHasSideCar = motorcycle.isHasSideCar;
        return this;
        }

        public Motorcycle build() { return new Motorcycle(this);}
    }
}
