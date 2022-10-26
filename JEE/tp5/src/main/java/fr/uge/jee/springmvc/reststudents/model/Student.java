package fr.uge.jee.springmvc.reststudents.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Student {

    @JsonProperty("uid")
    private long uid;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    public Student(long uid, String firstName, String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {}


    @Override
    public String toString() {
        return "Student{" +
            "uid=" + uid +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
