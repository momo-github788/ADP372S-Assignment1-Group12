package za.ac.cput.domain;
/*  ServicingAddon.java
    Entity for the Servicing Addons
    Author: George Tapiwa Charimba (220073465)
    Date: 2 April 2023
*/

import java.util.Objects;

public class ServicingAddon extends Addons{
    private int serviceCount;
    private int mileageLimit;

    private ServicingAddon() {
    }

    private ServicingAddon(ServicingAddonBuilder builder) {
        super(builder);
        this.serviceCount = builder.serviceCount;
        this.mileageLimit = builder.mileageLimit;
    }

    public int getServiceCount() {
        return serviceCount;
    }

    public int getMileageLimit() {
        return mileageLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServicingAddon that = (ServicingAddon) o;
        return serviceCount == that.serviceCount && mileageLimit == that.mileageLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serviceCount, mileageLimit);
    }

    @Override
    public String toString() {
        return "ServicingAddon{" +
                "serviceCount=" + serviceCount +
                ", mileageLimit=" + mileageLimit +
                '}';
    }

    public static class ServicingAddonBuilder extends Addons.AddonsBuilder<ServicingAddonBuilder>{
        private int serviceCount;
        private int mileageLimit;

        public ServicingAddonBuilder setServiceCount(int serviceCount) {
            this.serviceCount = serviceCount;
            return this;
        }

        public ServicingAddonBuilder setMileageLimit(int mileageLimit) {
            this.mileageLimit = mileageLimit;
            return this;
        }

        public ServicingAddonBuilder copy(ServicingAddon servicingAddon) {
            this.serviceCount = servicingAddon.serviceCount;
            this.mileageLimit = servicingAddon.mileageLimit;
            return this;
        }

        public ServicingAddon build() { return new ServicingAddon(this);}
    }
}
