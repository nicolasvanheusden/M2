package fr.uge.jee.springmvc.pokematch.model;

import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private List<Pokemon> evolutions;
    private String imageUrl;
    private int baseExperience;

    public Pokemon() {

    }

    public Pokemon(int id, String name, List<Pokemon> evolutions, String imageUrl, int baseExperience) {
        this.id = id;
        this.name = name;
        this.evolutions = evolutions;
        this.imageUrl = imageUrl;
        this.baseExperience = baseExperience;
    }
}
