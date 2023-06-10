/*  Car.java
    Entity for Car
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.domain;

import java.util.Objects;

public class Car extends Vehicle {
    private boolean isHasTowBar;

    private Car() {}

    private Car(CarBuilder builder) {
        super(builder);
        this.isHasTowBar = builder.isHasTowBar;
    }

    public boolean isHasTowBar() { return isHasTowBar;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isHasTowBar == car.isHasTowBar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHasTowBar);
    }

    @Override
    public String toString() {
        return super.toString() +
                "isHasTowBar= " + isHasTowBar +
                " }";
    }

    public static class CarBuilder extends Vehicle.VehicleBuilder<CarBuilder> {
        private boolean isHasTowBar;

        public CarBuilder setHasTowBar(boolean hasTowBar) {
            isHasTowBar = hasTowBar;
            return this;
        }

        public CarBuilder copy(Car car) {
            super.copy(car);
            this.isHasTowBar = car.isHasTowBar;
            return this;
        }

        public Car build() { return new Car(this);}
    }
}
