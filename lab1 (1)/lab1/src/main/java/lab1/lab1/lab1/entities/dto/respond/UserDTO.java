package lab1.lab1.lab1.entities.dto.respond;

import java.util.List;

import lab1.lab1.lab1.entities.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Id
    @GeneratedValue
    long id;
    String name;
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Post> posts;
}
