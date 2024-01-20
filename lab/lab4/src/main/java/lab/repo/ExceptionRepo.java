package lab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab.entities.ExceptionLog;

@Repository
public interface ExceptionRepo extends JpaRepository<ExceptionLog, Long> {
}
