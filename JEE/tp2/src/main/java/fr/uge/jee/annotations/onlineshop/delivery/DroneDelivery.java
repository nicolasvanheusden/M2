package fr.uge.jee.annotations.onlineshop.delivery;

import org.springframework.stereotype.Component;

@Component
public class DroneDelivery implements Delivery {

    @Override
    public String getDescription() {
        return "Delivery by drone";
    }
}
