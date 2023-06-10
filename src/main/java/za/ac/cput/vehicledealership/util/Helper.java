package za.ac.cput.vehicledealership.util;

import org.apache.commons.validator.EmailValidator;

import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || obj.toString().isEmpty() || obj == "";
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static Long generateNumericId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public static boolean isValidEmail(String emailAddress) {
        EmailValidator validator = EmailValidator.getInstance();

        return validator.isValid(emailAddress);
    }

}
