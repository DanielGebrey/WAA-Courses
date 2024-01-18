package lab1.lab1.lab1.entities;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hsqldb.rights.User;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    long id;
    String content;
    String title;
    String author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;
}
