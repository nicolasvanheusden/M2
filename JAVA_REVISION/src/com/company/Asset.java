package com.company;

public sealed interface Asset permits Hotel, Apartment{

    double profitPerNight();
    double efficiency();
}
