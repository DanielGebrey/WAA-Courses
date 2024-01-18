package lab1.lab1.lab1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab1.lab1.lab1.entities.Post;
import lab1.lab1.lab1.entities.dto.respond.PostDTO;

@Service
public interface PostService {
    List<Post> findAll();

    PostDTO findById(long id);

    void create(PostDTO postDTO);

    PostDTO updatePost(Long id, PostDTO postDTO);

    void deleteById(long id);

    void deleteAll();

    List<PostDTO> findByAuthor(String author);

    List<PostDTO> findByAuthorContaining(String name);
}
