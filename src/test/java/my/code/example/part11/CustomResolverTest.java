package my.code.example.part11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyStringResolver.class)
class CustomResolverTest {

    @Test
    void testWithCustomString(String message) {
        System.out.println(message); // Виведе "Впроваджено!"
        Assertions.assertTrue(message.contains("Впроваджено"));
    }
}
