package lab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lab.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE size(u.posts) > 1")
    public List<Users> findUsersWithMoreThanOnePosts();
}
