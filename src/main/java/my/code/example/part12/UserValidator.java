package my.code.example.part12;

import java.util.List;

public class UserValidator {

    private UserValidator() {
    }

    private static final List<String> validUsernames = List.of("JohnDoe", "J.Smith123", "user_name");

    public static boolean isValid(String username) {
        return validUsernames.contains(username);
    }
}
