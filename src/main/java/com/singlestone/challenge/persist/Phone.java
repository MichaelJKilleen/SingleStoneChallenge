package com.singlestone.challenge.persist;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Phone {
    private Long id;
    private String number;
    private String type;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="id", nullable=false)
    private Contact contact;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return Objects.requireNonNullElse(number,"");
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return Objects.requireNonNullElse(type,"");
    }

    public void setType(String type) {
        this.type = type;
    }


}
