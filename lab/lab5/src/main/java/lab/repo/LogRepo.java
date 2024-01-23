package lab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab.entities.Log;

@Repository
public interface LogRepo extends JpaRepository<Log, Long> {
}
