package my.code.example.part10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private Boolean isAuthor;
    private LocalDate publicationDate;
}
