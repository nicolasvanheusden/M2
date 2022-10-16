package fr.uge.jee.aop.students;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {

    private final TimeKeeper timeKeeper;

    public MyAspect(TimeKeeper timeKeeper) {
        this.timeKeeper = timeKeeper;
    }

    @Around(value="execution(* fr.uge.jee.aop.students.RegistrationService.create*(..))")
    public Object aroundCreate(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Calling " + pjp.getSignature().getName() + " with arguments " + Arrays.toString(pjp.getArgs()));
        var ret = pjp.proceed();
        System.out.println("Returning id " + ret + " by " + pjp.getSignature().getName());
        return ret;
    }

    @Around(value="execution(* fr.uge.jee.aop.students.RegistrationService.*DB(..))\"")
    public Object aroundDB(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.nanoTime();
        var ret = pjp.proceed();
        long endTime = System.nanoTime();
        timeKeeper.addTime(pjp.getSignature().getName(), startTime, endTime);
        return ret;
    }

    public void times() {
        timeKeeper.times();
    }



}
