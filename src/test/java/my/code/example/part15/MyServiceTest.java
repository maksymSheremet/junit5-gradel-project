package my.code.example.part15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {

    // MockitoExtension створює заглушку для цього поля
    @Mock
    private MyRepository myRepository;

    @Test
    void testFindUser() {
        // Налаштовуємо поведінку заглушки
        when(myRepository.findById(1)).thenReturn(Optional.of(new User(1, "John")));

        MyService myService = new MyService(myRepository);
        User user = myService.findUserById(1);

        // Перевіряємо, що сервіс працює коректно
        assertEquals("John", user.getName());
    }
}
