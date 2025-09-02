package my.code.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {

    @Test
    void usersEmptyIfNotUserAdded() {
        var userService = new UserService();
        var users = userService.getAllUsers();
        assertTrue(users.isEmpty());
    }
}