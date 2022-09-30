package fr.uge.jee.onlineshop;

import fr.uge.jee.onlineshop.delivery.Delivery;
import fr.uge.jee.onlineshop.insurance.Insurance;

import java.util.Objects;
import java.util.Set;

public class OnlineShop {

    private String name;
    private Set<Delivery> deliveryOptions;
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
