package za.ac.cput.vehicledealership.domain;
/*  Employee.java
    Entity for Employee
    Author: George Tapiwa Charimba (220073465)
    Date: 2 April 2023
*/
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    @Column(name = "employee_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;
    @Embedded
    private Name name;
    private LocalDateTime dateJoined;
    @NotBlank(message = "Required")
    private String password;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    private String emailAddress;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ContactDetail> contactDetails = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    protected Employee() {

    }



    public Employee(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.employeeNumber = builder.employeeNumber;
        this.name = builder.name;
        this.posts = builder.posts;
        this.dateJoined = builder.dateJoined;
        this.password = builder.password;
        this.contactDetails = builder.contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber && Objects.equals(name, employee.name) && Objects.equals(dateJoined, employee.dateJoined) && Objects.equals(password, employee.password) && Objects.equals(posts, employee.posts) && Objects.equals(emailAddress, employee.emailAddress) && Objects.equals(contactDetails, employee.contactDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, name, dateJoined, password, posts, emailAddress, contactDetails);
    }

    @PrePersist
    private void onCreate() {
        this.dateJoined = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name=" + name +
                ", dateJoined=" + dateJoined +
                ", password='" + password + '\'' +
                ", posts=" + posts +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactDetails=" + contactDetails +
                '}';
    }

    public static class Builder {
        private String emailAddress;
        private int employeeNumber;
        private Name name;
        private LocalDateTime dateJoined;
        private String password;
        private List<Post> posts;
        private Set<ContactDetail> contactDetails;


        public Builder setEmployeeNumber(int employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setPosts(List<Post> posts) {
            this.posts = posts;
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

        public Builder setContactDetails(Set<ContactDetail> contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }


        public Builder copy(Employee employee) {
            this.posts = employee.posts;
            this.employeeNumber = employee.employeeNumber;
            this.emailAddress = emailAddress;
            this.name = employee.name;
            this.dateJoined = employee.dateJoined;
            this.password = employee.password;
            this.contactDetails = employee.contactDetails;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
