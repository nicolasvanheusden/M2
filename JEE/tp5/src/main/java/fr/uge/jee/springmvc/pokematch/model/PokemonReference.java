package fr.uge.jee.springmvc.pokematch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonReference {


    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

    public PokemonReference() {}

    public PokemonReference(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "PokemonReference{" +
            "name='" + name + '\'' +
            ", url='" + url + '\'' +
            '}';
    }
}
