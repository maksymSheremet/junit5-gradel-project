package my.code.service;

import my.code.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    private UserService userService;

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("before all\n");
//    }
    @BeforeAll
    void beforeAll() {
        System.out.println("before all: " + this);
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNotUserAdded() {
        System.out.println("Test1: " + this);

        var users = userService.getAllUsers();

        assertTrue(users.isEmpty());
    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test2: " + this);

        userService.addUser(new User());
        userService.addUser(new User());

        var users = userService.getAllUsers();

        assertEquals(2,  users.size());
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each: " + this + "\n");
    }

//    @AfterAll
//    static void afterAll() {
//        System.out.println("after all");
//    }
    @AfterAll
    void afterAll() {
        System.out.println("after all: " +  this + "\n");
    }
}