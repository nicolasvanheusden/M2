package fr.uge.jee.springmvc.pokematch.model;

import java.util.Base64;

public class Pokemon {
    private int id;
    private String name;

    private String imageUrl;
    private int baseExperience;

    public Pokemon() {}

    public Pokemon(int id, String name, String imageUrl, int baseExperience) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.baseExperience = baseExperience;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getBaseExperience() {
        return baseExperience;
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pokemon && ((Pokemon) obj).getId() == id;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", baseExperience=" + baseExperience +
            '}';
    }
}
