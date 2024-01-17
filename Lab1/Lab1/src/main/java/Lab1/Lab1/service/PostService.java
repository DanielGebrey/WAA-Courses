package Lab1.Lab1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Lab1.Lab1.entities.Post;
import Lab1.Lab1.entities.dto.respond.PostDTO;

@Service
public interface PostService {
    List<Post> findAll();

    PostDTO findById(long id);

    void create(PostDTO postDTO);

    PostDTO update(PostDTO postDTO);

    void deleteById(long id);

    void deleteAll();

    List<PostDTO> findByAuthor(String author);

    List<PostDTO> findByAuthorContaining(String name);
}
