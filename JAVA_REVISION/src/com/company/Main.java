package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        var hotel = new Hotel(10, 1.0);
        System.out.println(hotel);

        var apartment = new Apartment(20, List.of("Bonny", "Clyde"));
        System.out.println(apartment);

        var list = new ArrayList<String>();
        list.add("Bob");
        var apartment2 = new Apartment(50, list);
        list.remove("Bob");
        System.out.println(apartment2);  // Apartment 50 m2 with Bob 0.5*/

        var hotel = new Hotel(5, 0.75);
        var apartment = new Apartment(30, List.of("Bony", "Clyde"));
        var manager = new AssetManager();
        manager.add(hotel);
        manager.add(apartment);
        System.out.println(manager.profitPerNight()); // 415
        System.out.println(manager);
        System.out.println(manager.lowestEfficiency(0.8));
        manager.remove(0.8);
        System.out.println(manager);  // affiche
        // Apartment 30 m2 with Bony, Clyde 1.0


    }
}
