package com.singlestone.challenge.service;

import com.singlestone.challenge.persist.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAllContacts();

    Contact save(Contact body);

    Contact updateContact(Long id, Contact body);

    Optional<Contact> findById(Long id);

    void deleteContact(Long id);
}
