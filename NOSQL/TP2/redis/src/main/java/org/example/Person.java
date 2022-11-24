package org.example;

import java.util.HashMap;

public record Person(int id, String firstName, String name) {

    public HashMap<String, String> toMap() {
        var map = new HashMap<String, String>();
        map.put("firstName", firstName);
        map.put("name", name);
        return map;
    }
}
