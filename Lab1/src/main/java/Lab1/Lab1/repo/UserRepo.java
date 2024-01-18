package Lab1.Lab1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Lab1.Lab1.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public List<User> findAll();
}
