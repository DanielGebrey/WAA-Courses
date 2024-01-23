package lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab.annotation.LogMe;
import lab.entities.dto.respond.CommentDTO;

@Service
public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO findById(Long id);

    CommentDTO create(CommentDTO commentDTO);

    CommentDTO update(long id, CommentDTO commentDTO);

    void deleteById(Long id);

    void addCommentToPost(long postId, CommentDTO commentDTO);

}
