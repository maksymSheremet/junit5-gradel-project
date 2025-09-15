package my.code.example.part15;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyService {
    private final MyRepository myRepository;

    public User findUserById(int id) {
        return myRepository.findById(id)
                .orElseThrow();
    }
}
