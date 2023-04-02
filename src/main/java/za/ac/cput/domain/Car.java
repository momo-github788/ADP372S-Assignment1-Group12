/*  Car.java
    Entity for Car
    Author: Alan Chapman (220092362)
    Date: 2 April 2023
*/
package za.ac.cput.domain;

import java.util.Objects;

public class Car {
    private boolean isHasTowBar;

    private Car() {}

    private Car(CarBuilder builder) {
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
        return "Car{" +
                "isHasTowBar=" + isHasTowBar +
                '}';
    }

    public static class CarBuilder {
        private boolean isHasTowBar;

        public void setHasTowBar(boolean hasTowBar) { isHasTowBar = hasTowBar;}

        public CarBuilder copy(Car car) {
            this.isHasTowBar = car.isHasTowBar;
            return this;
        }

        public Car build() { return new Car(this);}
    }
}
