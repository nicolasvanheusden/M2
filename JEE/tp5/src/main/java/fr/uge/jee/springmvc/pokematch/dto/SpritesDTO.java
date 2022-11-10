package fr.uge.jee.springmvc.pokematch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SpritesDTO {

    @JsonProperty("front_default")
    private String frontDefault;

    public SpritesDTO(String frontDefault ){
        this.frontDefault = frontDefault;
    }

    public SpritesDTO() {
    }

    public static SpritesDTO fromJson(String input) {
        var res = Arrays.stream(input.split(",")).map(str -> str.split("\":")).collect(Collectors.toList());
        var hashMap = new HashMap<String, String>();
        res.forEach((array) -> {
            hashMap.put(array[0].substring(2), array[1].substring(2, array[1].length()-1));
        });

        for (var entry : hashMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + " | value=" + entry.getValue());
        }
        return new SpritesDTO(hashMap.get("front_default"));
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    @Override
    public String toString() {
        return "SpritesDTO{" +
            "frontDefault='" + frontDefault +
            '}';
    }
}
