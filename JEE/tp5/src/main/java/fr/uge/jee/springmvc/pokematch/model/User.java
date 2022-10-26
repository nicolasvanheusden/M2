package fr.uge.jee.springmvc.pokematch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class User {

    @NotNull
    @Pattern(regexp="^[a-zA-Z]+$", message="Enter only letters")
    private String firstName;

    @NotNull
    @Pattern(regexp="^[a-zA-Z]+$", message="Enter only letters")
    private String lastName;

    public User(String firstName, String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {}


    @Override
    public String toString() {
        return "User{" +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }


}
