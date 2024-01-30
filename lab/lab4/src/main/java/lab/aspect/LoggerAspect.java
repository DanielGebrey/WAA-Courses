package lab.aspect;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lab.entities.Log;
import lab.repo.LogRepo;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    private LogRepo logRepository;

    @After("@annotation(lab.annotation.LogMe)")
    public void logAfterByAnnotation(JoinPoint joinPoint) {
        System.out.println("Log after the method" + joinPoint.getSignature().getName());

        // Save the log to the database
        Log log = new Log();
        log.setOperation("Log after the method" + joinPoint.getSignature().getName());
        log.setPrinciple("LoggerAspect");
        log.setDate(LocalDate.now());
        log.setTime(LocalDateTime.now());
        logRepository.save(log);
    }

    @After("execution(* lab..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Log after the method " + joinPoint.getSignature().getName());
    }
    
}
