package com.singlestone.challenge.persist;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public String getStreet() {
        return Objects.requireNonNullElse(street,"");
    }

    public String getCity() {
        return Objects.requireNonNullElse(city,"");
    }

    public String getState() {
        return Objects.requireNonNullElse(state,"");
    }

    public String getZip() {
        return Objects.requireNonNullElse(zip,"");
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
