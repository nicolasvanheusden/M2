package fr.uge.jee.onlineshop.delivery;

import java.util.Objects;

public class StandardDelivery implements Delivery{

    private int delay;

    @Override
    public String getDescription() {
        return "Standard delivery with a delay of " + delay + " days";
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
