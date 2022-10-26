package fr.uge.jee.springmvc.rectanglesession.model;


import java.util.ArrayList;
import java.util.List;

public class RectangleHistory {

    private final ArrayList<Integer> results;

    public RectangleHistory() {
        this.results = new ArrayList<>();
    }

    public void saveResult(int result) {
        results.add(result);
    }

    public List<Integer> getResults() {
        return List.copyOf(results);
    }
}
