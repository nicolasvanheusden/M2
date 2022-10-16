package fr.uge.jee.aop.students;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class TimeKeeper {

    private final HashMap<String, ArrayList<Long>> timesFromDb;

    public TimeKeeper() {
        this.timesFromDb = new HashMap<>();
    }

    public void addTime(String name, long startTime, long endTime) {
        timesFromDb.putIfAbsent(name, new ArrayList<>());
        timesFromDb.computeIfPresent(
            name,
            (k, v) -> {
                v.add((endTime - startTime) / 1000000);
                return v;
            }
        );
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
