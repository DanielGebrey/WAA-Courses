package lab.controller;

import org.springframework.web.bind.annotation.RestController;

import lab.entities.Post;
import lab.service.PostService;
import lab.entities.dto.respond.CommentDTO;
import lab.entities.dto.respond.PostDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public List<PostDTO> findAll() {
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

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO updatedPost) {
        PostDTO updated = postService.updatePost(postId, updatedPost);
        return ResponseEntity.ok(updated);
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

    @PostMapping("/{postId}/comment")
    public void addCommentToPost(@PathVariable("postId") long postId, @RequestBody CommentDTO commentDTO) {
        postService.addCommentToPost(postId, commentDTO);
    }

    @GetMapping("/filter/byTitle/{title}")
    public List<PostDTO> findByTitle(@PathVariable("title") String title) {
        return postService.findByTitle(title);
    }
}
