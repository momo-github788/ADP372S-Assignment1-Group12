package za.ac.cput.domain;

public class VehicleAddons {
    private String vehicleId;
    private  String addonId;
    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleAddons(Builder builder) {
        this.vehicleId =builder.vehicleId;
        this.addonId = builder.addonId;
    }

    public String getAddonId() {
        return addonId;
    }
    @Override
    public String toString() {
        return "VehicleAddons{" +
                "vehicleId='" + vehicleId + '\'' +
                ", addonId='" + addonId + '\'' +
                '}';
    }

    public static class Builder {

        private String vehicleId;
        private String addonId;
        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setAddonId(String addonId) {
            this.addonId = addonId;
            return this;
        }




        public Builder copy(VehicleAddons vehicleAddons){
            this.vehicleId =vehicleAddons.vehicleId;
            this.addonId= vehicleAddons.addonId;
            return this;
        }
        public VehicleAddons build(){
            return new VehicleAddons(this);
        }
        }
    }


