package Assignment5;

interface DataValidator {
    static boolean isNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }

    boolean isValid(String input);
}

class EmailValidator implements DataValidator {

    @Override
    public boolean isValid(String input) {
        if (!DataValidator.isNotEmpty(input)) return false;
        return input.contains("@") && input.contains(".");
    }
}

class PhoneValidator implements DataValidator {

    @Override
    public boolean isValid(String input) {
        if (!DataValidator.isNotEmpty(input)) return false;
        return input.matches("\\d{10}");
    }
}

public class ValidatorTest {
    public static void main(String[] args) {
        System.out.println(DataValidator.isNotEmpty("hello"));   // true
        System.out.println(DataValidator.isNotEmpty(""));        // false

        EmailValidator emailValidator = new EmailValidator();
        System.out.println(emailValidator.isValid("user@example.com")); // true
        System.out.println(emailValidator.isValid("invalidemail"));    // false

        PhoneValidator phoneValidator = new PhoneValidator();
        System.out.println(phoneValidator.isValid("1234567890")); // true
        System.out.println(phoneValidator.isValid("12345abcde")); // false
    }
}
