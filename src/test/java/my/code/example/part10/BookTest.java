package my.code.example.part10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Тести для книги")
class BookTest {

    // Тести для загальних операцій
    @Test
    void bookIsNotNull() {
        assertNotNull(new Book());
    }

    @Nested
    @DisplayName("Коли книга не опублікована")
    class WhenUnpublished {
        private Book book;

        @BeforeEach
        void setup() {
            book = new Book("Sample Title", false, null);
        }

        @Test
        @DisplayName("Вона не повинна мати дати публікації")
        void shouldNotHavePublicationDate() {
            assertNull(book.getPublicationDate());
        }

        @Test
        @DisplayName("Змінити назву можливо")
        void canChangeTitle() {
            book.setTitle("New Title");
            assertEquals("New Title", book.getTitle());
        }
    }

    @Nested
    @DisplayName("Коли книга опублікована")
    class WhenPublished {
        private Book book;

        @BeforeEach
        void setup() {
            book = new Book("Sample Title", true, LocalDate.now());
        }

        @Test
        @DisplayName("Вона повинна мати дату публікації")
        void shouldHavePublicationDate() {
            assertNotNull(book.getPublicationDate());
        }

        @Test
        @DisplayName("Не можна змінити назву")
        void cannotChangeTitle() {
            assertEquals("Sample Title", book.getTitle());
        }
    }
}