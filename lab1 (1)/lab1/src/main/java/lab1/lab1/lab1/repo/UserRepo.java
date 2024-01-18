package lab1.lab1.lab1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lab1.lab1.lab1.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    public List<lab1.lab1.lab1.entities.Users> findAll();

    @Query("SELECT u FROM Users u WHERE size(u.posts) > 1")
    public List<Users> findUsersWithMoreThanOnePosts();
}
