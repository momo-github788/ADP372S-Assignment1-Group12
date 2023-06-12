/*  Car.java
    Entity for Car
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.domain;

import java.util.Objects;

public class Car extends Vehicle {
    private boolean hasTowBar;

    private BodyType bodyType;

    private Car() {}

    private Car(CarBuilder builder) {
        super(builder);
        this.hasTowBar = builder.hasTowBar;
        this.bodyType = builder.bodyType;
    }

    public boolean isHasTowBar() { return hasTowBar;}

    public BodyType getBodyType() { return bodyType;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return hasTowBar == car.hasTowBar && bodyType == car.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasTowBar, bodyType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "hasTowBar=" + hasTowBar +
                ", bodyType=" + bodyType +
                '}';
    }

    public static class CarBuilder extends Builder<CarBuilder> {
        private boolean hasTowBar;

        private BodyType bodyType;

        public CarBuilder setHasTowBar(boolean hasTowBar) {
            this.hasTowBar = hasTowBar;
            return this;
        }

        public CarBuilder setBodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public CarBuilder copy(Car car) {
            super.copy(car);
            this.hasTowBar = car.hasTowBar;
            this.bodyType = car.bodyType;
            return this;
        }

        public Car build() { return new Car(this);}
    }
}
