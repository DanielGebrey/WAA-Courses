package Lab1.Lab1.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    long id;
    String content;
    String title;
    String author;
}
