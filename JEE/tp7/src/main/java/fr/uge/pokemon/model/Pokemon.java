package fr.uge.pokemon.model;


import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int score;

    public Pokemon() {
    }

    public Pokemon(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
