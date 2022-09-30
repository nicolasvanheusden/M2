package com.company;

public record Hotel(int rooms, double efficiency) implements Asset{

    public Hotel {

        if (efficiency < 0 || efficiency > 1) {
            throw new IllegalArgumentException("efficiency's value must be constraint between 0 and 1");
        }
    }

    @Override
    public String toString() {
        return "Hotel " + rooms + " rooms " + efficiency;
    }

    @Override
    public double profitPerNight() {
        return 100 * rooms * efficiency;
    }
}
