package lab.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lab.annotation.ExecutionTime;
import lab.annotation.LogMe;
import lab.entities.dto.respond.CommentDTO;
import lab.service.CommentService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    final CommentService commentService;

    @GetMapping
    @LogMe
    @ExecutionTime
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CommentDTO>> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(commentService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO comment) {
        return ResponseEntity.ok(commentService.create(comment));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentDTO> update(@PathVariable long id, @RequestBody CommentDTO comment) {
        return ResponseEntity.ok(commentService.update(id, comment));
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@RequestParam long id) {
        commentService.deleteById(id);
    }

}
