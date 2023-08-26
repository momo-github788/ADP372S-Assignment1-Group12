package za.ac.cput.vehicledealership.domain;

/*  Post.java
    Entity for the Post
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Post {

    @Transient
    @JsonIgnore
    private long EXPIRATION_TIME_MONTHS = 1;

    @Id
    @Column(name = "post_id")
    private String postId;

    private String title;

    private String description;
    private double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee_number")
    private Employee employee;

    @Column(name="post_creator_email")
    private String postCreatorEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id",  referencedColumnName = "branch_id")
    private Branch branch;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private boolean isActive;

    protected Post() {

    }

    private Post(Builder builder){
        this.postId = builder.postId;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.vehicle = builder.vehicle;
        this.branch = builder.branch;
        this.createdAt = builder.createdAt;
        this.expiredAt = builder.expiredAt;
        this.isActive = builder.isActive;
        this.employee = builder.employee;
        this.postCreatorEmail = builder.postCreatorEmail;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.expiredAt = calculateExpiryDate(createdAt);

    }

    private LocalDateTime calculateExpiryDate(LocalDateTime createdAt) {
        return createdAt.plusMonths(EXPIRATION_TIME_MONTHS);
    }

    @JsonIgnore
    public boolean isPostExpired() {
        LocalDateTime current = LocalDateTime.now();
        return current.isAfter(getExpiredAt());
    }

    public static class Builder {
        private String postId;
        private String title;
        private String description;
        private double price;
        private Vehicle vehicle;
        private Branch branch;
        private LocalDateTime createdAt;
        private LocalDateTime expiredAt;
        private boolean isActive;
        private Employee employee;
        private String postCreatorEmail;

        public Builder setPostId(String postId) {
            this.postId = postId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder setBranch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setExpiredAt(LocalDateTime expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }

        public Builder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder setPostCreatorEmail(String postCreatorEmail) {
            this.postCreatorEmail = postCreatorEmail;
            return this;
        }

        public Builder copy(Post post){
            this.postId = post.postId;
            this.title = post.title;
            this.description = post.description;
            this.price = post.price;
            this.vehicle = post.vehicle;
            this.branch = post.branch;
            this.createdAt = post.createdAt;
            this.expiredAt = post.expiredAt;
            this.isActive = post.isActive;
            this.employee = post.employee;
            this.postCreatorEmail = post.postCreatorEmail;
            return this;
        }

        public Post build(){
            return new Post(this);
        }
    }
}
