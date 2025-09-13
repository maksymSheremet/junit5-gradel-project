package my.code.example.part12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {

    // Тест, що перевіряє, чи є рядок паліндромом
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "madam", "kayak"})
    void isPalindrome_shouldBeTrue(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate));
    }
}
