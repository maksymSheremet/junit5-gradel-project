package my.code.service;

import my.code.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "Petr", "111");
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

        userService.addUser(IVAN);
        userService.addUser(PETR);

        var users = userService.getAllUsers();

        assertEquals(2, users.size());
    }

    @Test
    void loginSuccessIfUserExists() {
        userService.addUser(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getName(), IVAN.getPassword());

        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals(IVAN, user));
    }

    @Test
    void loginFailIfPasswordIsNotCorrect() {
        userService.addUser(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getName(), "dummy");

        assertTrue(maybeUser.isEmpty());
    }

    @Test
    void loginFailIfUserDoesNotExist() {
        userService.addUser(IVAN);
        Optional<User> maybeUser = userService.login("dummy", IVAN.getPassword());

        assertTrue(maybeUser.isEmpty());
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
        System.out.println("after all: " + this + "\n");
    }
}