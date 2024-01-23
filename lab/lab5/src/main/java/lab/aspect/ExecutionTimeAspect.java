package lab.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(lab.annotation.ExecutionTime)")
    public void logMe() {
    }

    @Around("@annotation(lab.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " tooks " + (end - start) + " nanoseconds");
        return proceed;
    }

}
