package my.code.service;

import my.code.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final List<User> users = new ArrayList<User>();

    public List<User> getAllUsers() {
        return users.isEmpty() ? Collections.emptyList() :  users;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public Optional<User> login(String name, String password) {
        return users.stream()
                .filter(user -> user.getName().equals(name) && user.getPassword().equals(password))
                .findFirst();
    }
}
