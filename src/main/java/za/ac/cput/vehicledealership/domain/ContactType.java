package za.ac.cput.vehicledealership.domain;

public enum ContactType {
    MOBILE("Mobile"),
    EMAIL("Email");

    private final String displayValue;

    private ContactType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
