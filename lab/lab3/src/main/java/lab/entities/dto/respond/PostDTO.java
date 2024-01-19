package lab.entities.dto.respond;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String content;
    String title;
    String author;
}
