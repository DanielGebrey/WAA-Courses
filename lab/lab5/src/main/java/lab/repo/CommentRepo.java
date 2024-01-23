package lab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
