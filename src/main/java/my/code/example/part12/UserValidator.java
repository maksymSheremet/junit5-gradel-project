package my.code.example.part12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserValidator {

    private static final List<String> validUsernames = List.of("JohnDoe", "J.Smith123", "user_name");

    public static boolean isValid(String username) {
        return validUsernames.contains(username);
    }
}
