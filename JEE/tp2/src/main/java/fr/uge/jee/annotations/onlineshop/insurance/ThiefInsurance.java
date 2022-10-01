package fr.uge.jee.annotations.onlineshop.insurance;

import org.springframework.stereotype.Component;

@Component
public class ThiefInsurance implements Insurance{

    @Override
    public String getDescription() {
        return "Thief insurance";
    }
}
