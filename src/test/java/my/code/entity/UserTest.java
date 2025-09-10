package my.code.entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Приклад життєвого циклу тесту
 */
class UserTest {

    @BeforeAll
    static void setupDatabaseConnection() {
        System.out.println("1. Встановлення з'єднання з базою даних");
    }

    @BeforeEach
    void setupTestUser() {
        System.out.println("2. Створення нового користувача перед тестом");
    }

    @Test
    void testUserLogin() {
        System.out.println("3. Виконання тесту: перевірка входу в систему");
        Assertions.assertTrue(true);
    }

    @Test
    void testUserRegistration() {
        System.out.println("3. Виконання тесту: перевірка реєстрації");
        Assertions.assertTrue(true);
    }

    @AfterEach
    void cleanupTestUser() {
        System.out.println("4. Очищення: видалення тестового користувача");
    }

    @AfterAll
    static void closeDatabaseConnection() {
        System.out.println("5. Закриття з'єднання з базою даних");
    }
}