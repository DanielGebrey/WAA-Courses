package lab.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ExceptionLog {
    @Id
    Long id;
    LocalDate date;
    LocalDateTime time;
    String principle;
    String operation;
    String type;
}
