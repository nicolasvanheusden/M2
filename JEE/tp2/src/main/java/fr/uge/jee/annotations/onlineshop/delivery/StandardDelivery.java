package fr.uge.jee.annotations.onlineshop.delivery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StandardDelivery implements Delivery{

    @Value("${onlineshop.standarddelivery.delay}")
    private int delay;

    @Override
    public String getDescription() {
        return "Standard delivery with a delay of " + delay + " days";
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
