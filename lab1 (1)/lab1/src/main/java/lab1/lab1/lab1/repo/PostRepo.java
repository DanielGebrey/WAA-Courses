package lab1.lab1.lab1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab1.lab1.lab1.entities.Post;
import lab1.lab1.lab1.entities.dto.respond.PostDTO;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    public List<Post> findAll();

    public Post findById(long id);

    public void save(PostDTO postDTO);

    // public void update(PostDTO postDTO);

    public void deleteById(long id);

    public List<PostDTO> findByAuthor(String author);

    public List<PostDTO> findByAuthorContaining(String name);
}
