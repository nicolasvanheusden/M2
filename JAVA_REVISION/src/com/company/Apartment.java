package com.company;

import java.util.List;
import java.util.Objects;

public record Apartment(int surface, List<String> persons) implements Asset{


    public Apartment {
        Objects.requireNonNull(persons);
        if (surface <= 0) {
            throw new IllegalArgumentException("the surface must be positive and greater than 0");
        }
        if (persons.isEmpty()) {
            throw new IllegalArgumentException("persons must not be empty.");
        }
        persons = List.copyOf(persons);
    }

    public double efficiency() {
        return persons.size() >= 2 ? 1.0 : 0.5;
    }


    @Override
    public String toString() {
        return "Apartment " + surface + " m2 with " + String.join(", ", persons) + " " + efficiency();
    }

    @Override
    public double profitPerNight() {
        return 20 * persons.size() * efficiency();
    }
}
