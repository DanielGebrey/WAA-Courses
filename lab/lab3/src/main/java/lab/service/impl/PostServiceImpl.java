package lab.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.entities.Comment;
import lab.entities.Post;
import lab.entities.dto.respond.CommentDTO;
import lab.entities.dto.respond.PostDTO;
import lab.repo.PostRepo;
import lab.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDTO> findAll() {
        return postRepo.findAll().stream().map(post -> modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDTO.class);
    }

    @Override
    public PostDTO create(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepo.save(post);
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        // Post post = modelMapper.map(postDTO, Post.class);

        // first find the object from the db
        Optional<Post> postOpt = postRepo.findById(id);
        if (postOpt.isPresent()) {
            postOpt.get().setAuthor(postDTO.getAuthor());
            postOpt.get().setContent(postDTO.getContent());
            postRepo.save(postOpt.get());
        }
        return modelMapper.map(postOpt.get(), PostDTO.class);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        postRepo.deleteAll();
    }

    @Override
    public List<PostDTO> findByAuthor(String author) {
        List<PostDTO> posts = postRepo.findByAuthor(author);
        return posts;
    }

    @Override
    public List<PostDTO> findByAuthorContaining(String name) {
        List<PostDTO> posts = postRepo.findByAuthorContaining(name);
        return posts;
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

    @Override
    public List<PostDTO> findByTitle(String title) {
        List<PostDTO> posts = postRepo.findByTitle(title);
        return posts;

    }
}
