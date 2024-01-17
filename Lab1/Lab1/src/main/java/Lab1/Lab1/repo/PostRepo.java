package Lab1.Lab1.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Lab1.Lab1.entities.Post;
import Lab1.Lab1.entities.dto.respond.PostDTO;

@Repository
public interface PostRepo extends MongoRepository<Post, Long> {

    public List<Post> findAll();

    public Post findById(long id);

    public void save(PostDTO postDTO);

    public void deleteById(long id);

    public List<PostDTO> findByAuthor(String author);

    public List<PostDTO> findByAuthorContaining(String name);
}
