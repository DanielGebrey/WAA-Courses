package lab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lab.entities.Post;
import lab.entities.dto.respond.PostDTO;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    public List<PostDTO> findByAuthor(String author);

    public List<PostDTO> findByAuthorContaining(String name);

    @Query("SELECT p from Post p WHERE p.title = :title")
    public List<PostDTO> findByTitle(String title);

}
