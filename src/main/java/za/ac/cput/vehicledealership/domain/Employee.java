package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {

    @Id
    private String employeeNumber;
    @Embedded
    private Name name;
    private LocalDateTime dateJoined;
    private String password;


    @OneToMany(mappedBy = "employee")
    private List<Post> posts;

    protected Employee() {

    }

    public Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.name = builder.name;
        this.dateJoined = builder.dateJoined;
        this.password = builder.password;
    }

    public static class Builder {
        private String employeeNumber;
        private Name name;
        private LocalDateTime dateJoined;
        private String password;


        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setDateJoined(LocalDateTime dateJoined) {
            this.dateJoined = dateJoined;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }


        public Builder copy(Employee employee) {
            this.employeeNumber = employee.employeeNumber;
            this.name = employee.name;
            this.dateJoined = employee.dateJoined;
            this.password = employee.password;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
