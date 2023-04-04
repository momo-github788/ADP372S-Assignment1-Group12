/*
* Branch.java
* This is the entity for Branch
* Author: Simphiwe kahlana(220162891)
* Date : March 2023
* */

package za.ac.cput.domain;

import java.util.UUID;

public class Branch {
    private String branchId;
    private String branchName;
    private int yearOpened;
    private Location location;

    private Branch(Builder builder) {
        this.branchId = builder.branchId;
        this.branchName = builder.branchName;
        this.yearOpened = builder.yearOpened;
        this.location = builder.location;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getYearOpened() {
        return yearOpened;
    }

    public Location getLocation() {
        return location;
    }

    public static class Builder {
        private String branchId;
        private String branchName;
        private int yearOpened;
        private Location location;

        public Builder setBranchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

        public Builder setYearOpened(int yearOpened) {
            this.yearOpened = yearOpened;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Branch build() {
            if (this.branchId == null || this.branchId.isEmpty()) {
                this.branchId = UUID.randomUUID().toString();
            }
            return new Branch(this);
        }
    }
}
