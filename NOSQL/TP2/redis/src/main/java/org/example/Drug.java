package org.example;

import java.util.Map;

public record Drug(int cip7, String name, long cisCode) {

    public Map<String, String> toMap() {
        return Map.of("name", name, "cisCode", String.valueOf(cisCode));
    }

    public static Drug fromMap(int cip7, Map<String, String> map) {
        return new Drug(cip7, map.get("name"), Long.parseLong(map.get("cisCode")));
    }


    @Override
    public String toString() {
        return "Drug{" +
            "cip7=" +  cip7 +
            ", name='" + name + '\'' +
            ", cisCode=" + cisCode +
            '}';
    }
}
