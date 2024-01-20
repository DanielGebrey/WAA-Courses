package lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab.entities.dto.respond.CommentDTO;
import lab.entities.dto.respond.PostDTO;

@Service
public interface PostService {
    List<PostDTO> findAll();

    PostDTO findById(long id);

    PostDTO create(PostDTO postDTO);

    PostDTO updatePost(Long id, PostDTO postDTO);

    void deleteById(long id);

    void deleteAll();

    List<PostDTO> findByAuthor(String author);

    List<PostDTO> findByAuthorContaining(String name);

    void addCommentToPost(long postId, CommentDTO commentDTO);

    List<PostDTO> findByTitle(String title);
}
