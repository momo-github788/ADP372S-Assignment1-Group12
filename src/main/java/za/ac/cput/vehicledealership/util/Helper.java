package za.ac.cput.vehicledealership.util;

import org.apache.commons.validator.EmailValidator;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    // Minimum of 6 characters
    // Atleast one uppercase letter
    // Atleast one lowercase letter
    // Atleast one digit
    private static final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
