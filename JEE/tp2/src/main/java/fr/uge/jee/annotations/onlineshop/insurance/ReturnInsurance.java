package fr.uge.jee.annotations.onlineshop.insurance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ReturnInsurance implements Insurance{

    @Value("${onlineshop.returninsurance.membersonly}")
    private boolean onlyMember;


    @Override
    public String getDescription() {
        return "Return insurance " + (onlyMember ? "only for members" : "");
    }

    public void setOnlyMember(boolean onlyMember) {
        this.onlyMember = onlyMember;
    }
}
