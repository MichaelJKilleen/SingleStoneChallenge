package com.singlestone.challenge.persist;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Name name;

    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private List<Phone> phone;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return Objects.requireNonNullElse(name,new Name());
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return Objects.requireNonNullElse(address,new Address());
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return Objects.requireNonNullElse(email,"");
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getPhone() {
        return Objects.requireNonNullElse(phone, Collections.EMPTY_LIST);
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }
}
