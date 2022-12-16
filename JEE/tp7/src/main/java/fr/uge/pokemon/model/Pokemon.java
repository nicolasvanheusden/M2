package fr.uge.pokemon.model;


import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    private String name;
    private int score;

    public Pokemon() {
    }

    public Pokemon(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
