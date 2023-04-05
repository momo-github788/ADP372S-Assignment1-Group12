package za.ac.cput.domain;
/* DetailingAddOn.java
    Subclass for Entity that is extends from Addons
    Junaid Cedrass - 219090912
    02 April 2023

 */
import java.time.LocalDateTime;
import java.util.Objects;

public class DetailingAddOn extends AddOns{
    private LocalDateTime dateCheckedIn;
    private LocalDateTime dateCheckedOut;

    private DetailingAddOn(){

    }

    public DetailingAddOn(DetailingAddOnBuilder builder){
        super(builder);
        this.dateCheckedIn = builder.dateCheckedIn;
        this.dateCheckedOut = builder.dateCheckedOut;
    }

    public LocalDateTime getDateCheckedIn() {
        return dateCheckedIn;
    }

    public LocalDateTime getDateCheckedOut() {
        return dateCheckedOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailingAddOn that)) return false;
        return Objects.equals(dateCheckedIn, that.dateCheckedIn) && Objects.equals(dateCheckedOut, that.dateCheckedOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCheckedIn, dateCheckedOut);
    }

    @Override
    public String toString() {
        return super.toString() + "dateCheckedIn=" + dateCheckedIn +
                ", dateCheckedOut=" + dateCheckedOut +
                '}';
    }

    public static class DetailingAddOnBuilder extends Addons.AddonsBuilder<DetailingAddOnBuilder>{

        private LocalDateTime dateCheckedIn;
        private LocalDateTime dateCheckedOut;

        public DetailingAddOnBuilder setDateCheckedIn(LocalDateTime dateCheckedIn) {
            this.dateCheckedIn = dateCheckedIn;
            return this;
        }

        public DetailingAddOnBuilder setDateCheckedOut(LocalDateTime dateCheckedOut) {
            this.dateCheckedOut = dateCheckedOut;
            return this;
        }

        public DetailingAddOnBuilder copy(DetailingAddOn detailingAddOn){
            this.dateCheckedIn = detailingAddOn.dateCheckedIn;
            this.dateCheckedOut = detailingAddOn.dateCheckedOut;
            return this;
        }

        public DetailingAddOn build(){
            return new DetailingAddOn(this);
        }
    }
}