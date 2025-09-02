package my.code.example.part1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Створюємо екземпляр калькулятора перед тестом.");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Очищуємо ресурси після тесту.");
    }

    @Test
    @DisplayName("Перевірка додавання двох додатних чисел")
    void testAddPositiveNimbers() {
        int a = 2;
        int b = 5;

        int sum = calculator.add(a, b);

        assertEquals(7, sum, "2 + 5 має дорівнювати 7");
    }
}