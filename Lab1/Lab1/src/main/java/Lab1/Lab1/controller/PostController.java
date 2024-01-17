package Lab1.Lab1.controller;

import org.springframework.web.bind.annotation.RestController;

import Lab1.Lab1.entities.Post;
import Lab1.Lab1.entities.dto.respond.PostDTO;
import Lab1.Lab1.service.PostService;
import Lab1.Lab1.service.impl.PostServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDTO findById(@PathVariable("id") long id) {
        return postService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody PostDTO post) {
        postService.create(post);
    }

    @PutMapping
    public void update(@RequestBody PostDTO post) {
        postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        postService.deleteById(id);
    }

    @GetMapping("/filter/byAuthor/{author}")
    public List<PostDTO> findByAuthor(@PathVariable("author") String author) {
        return postService.findByAuthor(author);
    }

    @GetMapping("/filter/byAuthorContaining/{byAuthorContaining}")
    public List<PostDTO> findByAuthorContaining(@PathVariable("byAuthorContaining") String author) {
        return postService.findByAuthorContaining(author);
    }
}
