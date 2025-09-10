package my.code.example.part8;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testDivisionByZeroThrowException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void testExceptionMessageForDivisionByZero() {
        var exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));

        assertEquals("Дільник не може бути нулем.", exception.getMessage());
    }
}