package my.code.example.part4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Звичайний режим (PER_METHOD)
 */

class DefaultLifecycleTest {
    // Повинен бути статичним
    @BeforeAll
    static void setupGlobalResource() {
        System.out.println("Статична ініціалізація");
    }

    // Повинен бути статичним
    @AfterAll
    static void cleanupGlobalResource() {
        System.out.println("Статичне очищення");
    }

    @Test
    void test1() {
        assertTrue(true);
    }
}