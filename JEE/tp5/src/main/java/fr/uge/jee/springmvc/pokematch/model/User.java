package fr.uge.jee.springmvc.pokematch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Objects;

public class User {

    @NotNull
    @Pattern(regexp="^[a-zA-Z]+$", message="Enter only letters")
    private String firstName;

    @NotNull
    @Pattern(regexp="^[a-zA-Z]+$", message="Enter only letters")
    private String lastName;

    private final ArrayList<Pokemon> favouritesPokemon;

    public User(String firstName, String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.favouritesPokemon = new ArrayList<>();
    }

    public User() {
        this.favouritesPokemon = new ArrayList<>();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.lastName = lastName;
    }

    public void addPokemon(Pokemon pokemon) {
        Objects.requireNonNull(pokemon);
        this.favouritesPokemon.add(pokemon);
    }

    @Override
    public String toString() {
        return "User{" +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }


}
