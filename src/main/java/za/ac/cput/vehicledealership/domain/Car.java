/*  Car.java
    Entity for Car
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "car")
public class Car extends Vehicle {
    @Column(name = "tow_bar")
    protected boolean hasTowBar;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    protected BodyType bodyType;

    protected Car() {}

    protected Car(CarBuilder builder) {
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
        Car car = (Car) o;
        return hasTowBar == car.hasTowBar && bodyType == car.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasTowBar, bodyType);
    }

    @Override
    public String toString() {
        return super.toString() +
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
