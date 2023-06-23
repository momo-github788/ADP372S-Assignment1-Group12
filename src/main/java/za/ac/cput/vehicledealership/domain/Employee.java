package za.ac.cput.vehicledealership.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Employee {
    private long employeeNumber;

    private Name name;
    private LocalDateTime dateJoined;
    private String password;

    private Employee() {

    }

    public Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.name = builder.name;
        this.dateJoined = builder.dateJoined;
        this.password = builder.password;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public Name getName() {
        return name;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber && Objects.equals(name, employee.name) && Objects.equals(dateJoined, employee.dateJoined) && Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, name, dateJoined, password);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name=" + name +
                ", dateJoined=" + dateJoined +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private long employeeNumber;
        private Name name;
        private LocalDateTime dateJoined;
        private String password;


        public Builder setEmployeeNumber(long employeeNumber) {
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
