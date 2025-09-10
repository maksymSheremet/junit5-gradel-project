package my.code.service;

import my.code.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("fast")
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

//        MatcherAssert.assertThat(users, IsEmptyCollection.empty());
        assertTrue(users.isEmpty());
    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test2: " + this);

        userService.addUser(IVAN);
        userService.addUser(PETR);

        var users = userService.getAllUsers();

        assertThat(users).hasSize(2);

        assertEquals(2, users.size());
    }

    @Test
    void usersConvertedToMapById() {
        userService.addUser(IVAN, PETR);

        Map<Integer, User> users = userService.getAllConvertedById();

//        MatcherAssert.assertThat(users, IsMapContaining.hasKey(IVAN.getId()));

        assertAll(
                () -> assertThat(users).containsKeys(IVAN.getId(), PETR.getId()),
                () -> assertThat(users).containsValues(IVAN, PETR)
        );

//        assertThat(users).containsKeys(IVAN.getId(), PETR.getId());
//        assertThat(users).containsValues(IVAN, PETR);

    }

    @Test
    @Tag("login")
    void loginSuccessIfUserExists() {
        userService.addUser(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getName(), IVAN.getPassword());

        assertTrue(maybeUser.isPresent());
        assertThat(maybeUser).isPresent();

        maybeUser.ifPresent(user -> assertEquals(IVAN, user));
        maybeUser.ifPresent(user -> assertThat(user).isEqualTo(IVAN));
    }

    @Test
    @Tag("login")
    void throwExceptionIfUsernameOrPasswordIsNull() {
        assertAll(
                () -> {
                    var exception = assertThrows(IllegalArgumentException.class, () -> userService.login(null, "123"));
                    assertThat(exception.getMessage()).isEqualTo("Username or password is empty");
                },
                () -> assertThrows(IllegalArgumentException.class, () -> userService.login("dummy", null))
        );

//        try {
//            userService.login(null, "123");
//            fail("login should throw exception");
//        } catch (IllegalArgumentException e) {
//            assertTrue(true);
//        }
    }

    @Test
    @Tag("login")
    void loginFailIfPasswordIsNotCorrect() {
        userService.addUser(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getName(), "dummy");

        assertTrue(maybeUser.isEmpty());
    }

    @Test
    @Tag("login")
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