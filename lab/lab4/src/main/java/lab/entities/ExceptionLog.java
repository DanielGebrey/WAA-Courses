package lab.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ExceptionLog {
    Long id;
    LocalDate date;
    LocalDateTime time;
    String principle;
    String operation;
    String type;
}
