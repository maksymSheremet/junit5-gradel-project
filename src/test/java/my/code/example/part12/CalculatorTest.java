package my.code.example.part12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "5, 3, 8",
            "-1, 1, 0"
    })
    void add_shouldReturnCorrectSum(int a, int b, int expectedSum) {
        assertEquals(expectedSum, Calculator.add(a, b));
    }
}
