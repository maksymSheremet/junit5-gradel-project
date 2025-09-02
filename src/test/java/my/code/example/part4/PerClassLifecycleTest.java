package my.code.example.part4;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Режим PER_CLASS
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS),
 * JUnit 5 створить лише один екземпляр цього класу для всіх тестових методів.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PerClassLifecycleTest {

    // Не статичний
    @BeforeAll
    void setupGlobalResource() {
        System.out.println("Нестатична ініціалізація");
    }

    // Не статичний
    @AfterAll
    void cleanupGlobalResource() {
        System.out.println("Нестатичне очищення");
    }

    @Test
    void test1() {
        assertTrue(true);
    }
}