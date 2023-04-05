package za.ac.cput.domain;

import java.util.Objects;

/*  ExtendedWarrantyAddon.java
    Entity for the Extended Warranty Addons
    Author: George Tapiwa Charimba (220073465)
    Date: 2 April 2023
*/
public class ExtendedWarrantyAddon extends Addons{
    private int mileageLimit;

    private ExtendedWarrantyAddon() {
    }

    private ExtendedWarrantyAddon(ExtendedWarrantyAddonBuilder builder) {
        super(builder);
        this.mileageLimit = builder.mileageLimit;
    }

    public int getMileageLimit() {
        return mileageLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExtendedWarrantyAddon that = (ExtendedWarrantyAddon) o;
        return mileageLimit == that.mileageLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mileageLimit);
    }

    @Override
    public String toString() {
        return "ExtendedWarrantyAddon{" +
                "mileageLimit=" + mileageLimit +
                '}';
    }

    public static class ExtendedWarrantyAddonBuilder extends Addons.AddonsBuilder<ExtendedWarrantyAddonBuilder>{
        private int mileageLimit;

        public ExtendedWarrantyAddonBuilder setMileageLimit(int mileageLimit) {
            this.mileageLimit = mileageLimit;
            return this;
        }

        public ExtendedWarrantyAddonBuilder copy(ExtendedWarrantyAddon extendedWarrantyAddon) {
            this.mileageLimit = extendedWarrantyAddon.mileageLimit;
            return this;
        }

        public ExtendedWarrantyAddon build() { return new ExtendedWarrantyAddon(this);}
    }
}
