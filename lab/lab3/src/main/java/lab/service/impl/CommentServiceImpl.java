package lab.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.entities.dto.respond.CommentDTO;
import lab.entities.Comment;
import lab.entities.Post;
import lab.repo.CommentRepo;
import lab.repo.PostRepo;
import lab.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Override
    public List<CommentDTO> findAll() {
        return commentRepo.findAll().stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).toList();
    }

    @Override
    public CommentDTO findById(Long id) {
        return modelMapper.map(commentRepo.findById(id), CommentDTO.class);
    }

    @Override
    public CommentDTO create(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        commentRepo.save(comment);
        return modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO update(long id, CommentDTO commentDTO) {
        Optional<Comment> commentOpt = commentRepo.findById(id);
        if (!commentOpt.isPresent()) {
            throw new RuntimeException("Comment not found");
        }

        commentOpt.get().setName(commentDTO.getName());
        commentRepo.save(commentOpt.get());
        return modelMapper.map(commentOpt.get(), CommentDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void addCommentToPost(long postId, CommentDTO commentDTO) {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent()) {
            Comment comment = modelMapper.map(commentDTO, Comment.class);
            comment.setPost(post.get());
            post.get().getComment().add(comment);
        }

    }
}
