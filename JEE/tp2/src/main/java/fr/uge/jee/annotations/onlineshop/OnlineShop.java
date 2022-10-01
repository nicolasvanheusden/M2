package fr.uge.jee.annotations.onlineshop;

import fr.uge.jee.annotations.onlineshop.delivery.Delivery;
import fr.uge.jee.annotations.onlineshop.insurance.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
public class OnlineShop {

    @Value("${onlineshop.name}")
    private String name;
    @Autowired
    private Set<Delivery> deliveryOptions;
    @Autowired
    private Set<Insurance> insurances;

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public void setDeliveryOptions(Set<Delivery> deliveryOptions) {
        this.deliveryOptions = Set.copyOf(deliveryOptions);

    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = Set.copyOf(insurances);
    }

    public void printDescription(){
        System.out.println(name);
        System.out.println("Delivery options");
        deliveryOptions.forEach(opt -> System.out.println("\t"+opt.getDescription()));
        System.out.println("Insurance options");
        insurances.forEach(insurance -> System.out.println("\t"+insurance.getDescription()));
    }
}
