package com.singlestone.challenge.persist;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Name {
    private String first;
    private String middle;
    private String last;

    public String getFirst() {
        return Objects.requireNonNullElse(first,"");
    }

    public String getMiddle() {
        return Objects.requireNonNullElse(middle,"");
    }

    public String getLast() {
        return Objects.requireNonNullElse(last,"");
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
