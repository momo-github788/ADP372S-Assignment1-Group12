package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Entity
@EqualsAndHashCode
@ToString
@Getter
public class City implements Serializable {

    @Id
    @Column(name = "city_id")
    private String id;
    private String name;

    protected City(){

    }

    public City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }
}
