package my.code.example.part15;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyRepository {
    List<User> users =  new ArrayList<>();

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }
}
