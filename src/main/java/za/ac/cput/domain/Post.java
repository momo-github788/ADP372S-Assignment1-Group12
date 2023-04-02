package za.ac.cput.domain;

/*  Post.java
    Entity for the Post
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private String postId;
    private String title;
    private String description;
    private double price;
    private Vehicle vehicle;
    private Branch branch;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private boolean isActive;

    private Post() {

    }

    private Post(PostBuilder builder){
        this.postId = builder.postId;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.vehicle = builder.vehicle;
        this.branch = builder.branch;
        this.createdAt = builder.createdAt;
        this.expiredAt = builder.expiredAt;
        this.isActive = builder.isActive;
    }

    public String getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Branch getBranch() {
        return branch;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Double.compare(post.price, price) == 0 && isActive == post.isActive && Objects.equals(postId, post.postId) && Objects.equals(title, post.title) && Objects.equals(description, post.description) && Objects.equals(vehicle, post.vehicle) && Objects.equals(branch, post.branch) && Objects.equals(createdAt, post.createdAt) && Objects.equals(expiredAt, post.expiredAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, description, price, vehicle, branch, createdAt, expiredAt, isActive);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vehicle=" + vehicle +
                ", branch=" + branch +
                ", createdAt=" + createdAt +
                ", expiredAt=" + expiredAt +
                ", isActive=" + isActive +
                '}';
    }

    public static class PostBuilder {
        private String postId;
        private String title;
        private String description;
        private double price;
        private Vehicle vehicle;
        private Branch branch;
        private LocalDateTime createdAt;
        private LocalDateTime expiredAt;
        private boolean isActive;

        public PostBuilder setPostId(String postId) {
            this.postId = postId;
            return this;
        }

        public PostBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PostBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public PostBuilder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public PostBuilder setBranch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public PostBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PostBuilder setExpiredAt(LocalDateTime expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        public PostBuilder setActive(boolean active) {
            isActive = active;
            return this;
        }

        public PostBuilder copy(Post post){
            this.postId = post.postId;
            this.title = post.title;
            this.description = post.description;
            this.price = post.price;
            this.vehicle = post.vehicle;
            this.branch = post.branch;
            this.createdAt = post.createdAt;
            this.expiredAt = post.expiredAt;
            this.isActive = post.isActive;
            return this;
        }

        public Post build(){
            return new Post(this);
        }
    }
}
