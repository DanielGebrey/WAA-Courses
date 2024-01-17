package Lab1.Lab1.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab1.Lab1.entities.Post;
import Lab1.Lab1.entities.dto.respond.PostDTO;
import Lab1.Lab1.repo.PostRepo;
import Lab1.Lab1.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDTO findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDTO.class);
    }

    @Override
    public void create(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepo.save(post);
    }

    @Override
    public PostDTO update(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        return modelMapper.map(postRepo.save(post), PostDTO.class);
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

}
