package fr.uge.jee.aop.students;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Aspect
@Component
public class MyAspect {

    private final HashMap<String, ArrayList<Long>> timesFromDb;

    public MyAspect() {
        this.timesFromDb = new HashMap<>();
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
        timesFromDb.putIfAbsent(pjp.getSignature().getName(), new ArrayList<>());
        timesFromDb.computeIfPresent(
            pjp.getSignature().getName(),
            (k, v) -> {
                v.add((endTime - startTime) / 1000000);
                return v;
            }
        );
        return ret;
    }

    public void times() {
        System.out.println("DB timing report:");
        for (var entry: timesFromDb.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Mesured access times :" + entry.getValue());
            System.out.println("Average time : " + entry.getValue().stream().reduce(Long::sum).get() / entry.getValue().size());
        }
    }

}
