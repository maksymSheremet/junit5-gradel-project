package my.code.service;

import my.code.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class UserService {

    private final List<User> users = new ArrayList<User>();

    public List<User> getAllUsers() {
        return users.isEmpty() ? Collections.emptyList() : users;
    }

    public void addUser(User... users) {
        this.users.addAll(Arrays.asList(users));
    }

    public Optional<User> login(String name, String password) {
        return users.stream()
                .filter(user -> user.getName().equals(name) && user.getPassword().equals(password))
                .findFirst();
    }

    public Map<Integer, User> getAllConvertedById() {
        return users.stream()
                .collect(toMap(User::getId, identity()));
    }
}
