package lab1.lab1.lab1.entities.dto.respond;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @Id
    long id;
    String content;
    String title;
    String author;
}
