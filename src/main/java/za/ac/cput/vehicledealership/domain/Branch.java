/*
* Branch.java
* This is the entity for Branch
* Author: Simphiwe kahlana(220162891)
* Date : March 2023
* */

package za.ac.cput.vehicledealership.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int branchId;
    private String branchName;
    private int yearOpened;
    @Embedded
    private Location location;



    public Branch() {

    }

    private Branch (BranchBuilder branchBuilder){
        this.branchId = branchBuilder.branchId;
        this.branchName = branchBuilder.branchName;
        this.yearOpened = branchBuilder.yearOpened;
        this.location = branchBuilder.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return yearOpened == branch.yearOpened && Objects.equals(branchId, branch.branchId) && Objects.equals(branchName, branch.branchName) && Objects.equals(location, branch.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, yearOpened, location);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", yearOpened=" + yearOpened +
                ", location=" + location +
                '}';
    }

    public static class BranchBuilder {
        private int branchId;
        private String branchName;
        private int yearOpened;
        private Location location;

        public BranchBuilder setBranchId(int branchId) {
            this.branchId = branchId;
            return this;
        }

        public BranchBuilder setBranchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

        public BranchBuilder setYearOpened(int yearOpened) {
            this.yearOpened = yearOpened;
            return this;
        }

        public BranchBuilder setLocation(Location location) {
            this.location = location;
            return this;
        }


        public BranchBuilder copy(Branch branch) {
            this.branchId = branch.branchId;
            this.branchName = branch.branchName;
            this.yearOpened = branch.yearOpened;
            this.location = branch.location;
            return this;
        }
        public Branch build(){
            return new Branch(this);
        }
    }
}
