/*
* Branch.java
* This is the entity for Branch
* Author: Simphiwe kahlana(220162891)
* Date : March 2023
* */

package za.ac.cput.vehicledealership.domain;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@EqualsAndHashCode
@ToString
public class Branch {

    @Id
    @Column(name = "branch_id")
    private String branchId;
    private String branchName;
    private int yearOpened;
    @Embedded
    private Location location;

//    @OneToOne(mappedBy = "branch")
//    private Post post;

    protected Branch() {

    }

    private Branch (BranchBuilder branchBuilder){
        this.branchId = branchBuilder.branchId;
        this.branchName = branchBuilder.branchName;
        this.yearOpened = branchBuilder.yearOpened;
        this.location = branchBuilder.location;
    }

    public static class BranchBuilder {
        private String branchId;
        private String branchName;
        private int yearOpened;
        private Location location;

        public BranchBuilder setBranchId(String branchId) {
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
