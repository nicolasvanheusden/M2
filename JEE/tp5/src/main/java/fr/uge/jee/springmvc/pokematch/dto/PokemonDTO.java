package fr.uge.jee.springmvc.pokematch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.uge.jee.springmvc.pokematch.model.Pokemon;


public class PokemonDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sprites")
    private SpritesDTO sprites;
    @JsonProperty("base_experience")
    private int baseExperience;

    public PokemonDTO() {}

    public PokemonDTO(int id, String name, SpritesDTO sprites, int baseExperience) {
        this.id = id;
        this.name = name;
        this.sprites = sprites;
        this.baseExperience = baseExperience;
    }
    public Pokemon toModel() {
        return new Pokemon(
            id,
            name,
            sprites.getFrontDefault(),
            baseExperience
        );
    }



}
