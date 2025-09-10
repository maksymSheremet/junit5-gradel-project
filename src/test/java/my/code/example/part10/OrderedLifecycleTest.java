package my.code.example.part10;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedLifecycleTest {

    @Test
    @Order(1)
        // Цей тест виконається першим
    void firstTest() {
        System.out.println("Виконання першого тесту.");
        assertTrue(true);
    }

    @Test
    @Order(2)
        // Цей тест виконається другим
    void secondTest() {
        System.out.println("Виконання другого тесту.");
        assertTrue(true);
    }
}
