package fr.uge.servlet.hellosession;

import java.util.HashMap;
import java.util.Objects;

public class UserManager {

    private final HashMap<String, Integer> manager;
    private final Object lock = new Object();

    UserManager() {
        this.manager = new HashMap<>();
    }


    public void addUser(String key) {
        synchronized (lock) {
            Objects.requireNonNull(key);
            manager.putIfAbsent(key, 1);
        }
    }

    public void updateValue(String oldKey, String newKey) {
        synchronized (lock) {
            var score = manager.remove(oldKey);
            manager.putIfAbsent(newKey, ++score);
        }
    }

    public int getScore(String key) {
        synchronized (lock) {
            Objects.requireNonNull(key);
            var score = manager.get(key);
            return score == null ? 0 : score;
        }
    }



}
