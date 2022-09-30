package fr.uge.jee.onlineshop.insurance;

import java.util.Objects;

public class ReturnInsurance implements Insurance{

    private boolean onlyMember;


    @Override
    public String getDescription() {
        return "Return insurance " + (onlyMember ? "only for members" : "");
    }

    public void setOnlyMember(boolean onlyMember) {
        this.onlyMember = onlyMember;
    }
}
