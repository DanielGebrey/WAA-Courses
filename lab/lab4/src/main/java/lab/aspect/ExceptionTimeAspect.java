package lab.aspect;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lab.repo.ExceptionRepo;
import lab.entities.*;

@Aspect
@Component
public class ExceptionTimeAspect {

    @Autowired
    private ExceptionRepo exceptionRepo;

    @Pointcut("@annotation(lab.annotation.ExceptionTime)")
    public void ExceptionTime() {
    }

    @After("@annotation(lab.annotation.ExceptionTime)")
    public void logAfterByAnnotation(JoinPoint joinPoint) {
        System.out.println("Log after the method" + joinPoint.getSignature().getName() + " tooks ");

        // Save the log to the database
        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setOperation("Log after the Exception" + joinPoint.getSignature().getName() + " tooks ");
        exceptionLog.setPrinciple("ExceptionTimeAspect");
        exceptionLog.setDate(LocalDate.now());
        exceptionLog.setTime(LocalDateTime.now());
        exceptionRepo.save(exceptionLog);
    }
}
