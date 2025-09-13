package my.code.example.part12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {

    // Метод, який надає аргументи для тесту
    static Stream<String> validUsernames() {
        return Stream.of("JohnDoe", "J.Smith123", "user_name");
    }

    @ParameterizedTest
    @MethodSource("validUsernames")
    void isValidUsername_shouldBeTrue(String username) {
        assertTrue(UserValidator.isValid(username));
    }
}
