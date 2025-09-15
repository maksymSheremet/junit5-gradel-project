package my.code;

import my.code.extension.GlobalExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
        GlobalExtension.class
})
public abstract class BaseTest {
}
