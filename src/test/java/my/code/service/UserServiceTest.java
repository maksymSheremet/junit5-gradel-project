package my.code.service;

import my.code.entity.User;
import my.code.paramresolver.UserServiceParamResolver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("fast")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({
        UserServiceParamResolver.class
})
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
    void setUp(UserService userService) {
        System.out.println("Before each: " + this);
        this.userService = userService;
    }

    @Test
    @Order(1)
    @DisplayName("users will be empty if no user added")
    void usersEmptyIfNotUserAdded() {
        System.out.println("Test1: " + this);

        var users = userService.getAllUsers();

//        MatcherAssert.assertThat(users, IsEmptyCollection.empty());
        assertTrue(users.isEmpty());
    }

    @Test
    @Order(2)
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

    @Nested
    @Tag("login")
    @DisplayName("test user Login functionality")
    class LoginTest {

        @Test
        void loginSuccessIfUserExists() {
            userService.addUser(IVAN);
            Optional<User> maybeUser = userService.login(IVAN.getName(), IVAN.getPassword());

            assertTrue(maybeUser.isPresent());
            assertThat(maybeUser).isPresent();

            maybeUser.ifPresent(user -> assertEquals(IVAN, user));
            maybeUser.ifPresent(user -> assertThat(user).isEqualTo(IVAN));
        }

        @Test
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

        @ParameterizedTest(name = "{arguments} test")
//        @ArgumentsSource()
//        @NullSource
//        @EmptySource
//        @ValueSource(strings = {
//                "Ivan", "Petr"
//        })
//        @NullAndEmptySource
//        @EnumSource
        @MethodSource("my.code.service.UserServiceTest#getArgumentsForLoginTest")
//        @CsvFileSource(resources = "/login-test-data.csv", delimiter = ',', numLinesToSkip = 1)
//        @CsvSource({
//                "Ivan", "123",
//                "Petr", "111"
//        })
        @DisplayName("login display parametrized test")
        void loginParametrizedTest(String username, String password, Optional<User> user) {
            userService.addUser(IVAN, PETR);

            var maybeUser = userService.login(username, password);

            assertThat(maybeUser).isEqualTo(user);
        }


    }

    static Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(Arguments.of("Ivan", "123", Optional.of(IVAN)),
                Arguments.of("Petr", "111", Optional.of(PETR)),
                Arguments.of("Petr", "dummy", Optional.empty()),
                Arguments.of("dummy", "111", Optional.empty()));

//        return Stream.of("Ivan", "123", Optional.of(IVAN),
//                        "Petr", "111", Optional.of(PETR),
//                        "Petr", "dummy", Optional.empty(),
//                        "dummy", "111", Optional.empty())
//                .map(Arguments::of);
    }
}