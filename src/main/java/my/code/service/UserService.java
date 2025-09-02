package my.code.service;

import my.code.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<User>();

    public List<User> getAllUsers() {
        return users.isEmpty() ? Collections.emptyList() :  users;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }
}
