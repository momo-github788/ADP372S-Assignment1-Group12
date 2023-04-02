package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class DetailingAddon {
    private LocalDateTime dateCheckedIn;
    private LocalDateTime dateCheckedOut;

    private DetailingAddon(){

    }

    public DetailingAddon(DetailingAddOnBuilder builder){
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
        if (!(o instanceof DetailingAddon that)) return false;
        return Objects.equals(dateCheckedIn, that.dateCheckedIn) && Objects.equals(dateCheckedOut, that.dateCheckedOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCheckedIn, dateCheckedOut);
    }

    @Override
    public String toString() {
        return "DetailingAddon{" +
                "dateCheckedIn=" + dateCheckedIn +
                ", dateCheckedOut=" + dateCheckedOut +
                '}';
    }

    public static class DetailingAddOnBuilder {

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

        public DetailingAddOnBuilder copy(DetailingAddon detailingAddon){
            this.dateCheckedIn = detailingAddon.dateCheckedIn;
            this.dateCheckedOut = detailingAddon.dateCheckedOut;
            return this;
        }

        public DetailingAddon build(){
            return new DetailingAddon(this);
        }
    }
}
