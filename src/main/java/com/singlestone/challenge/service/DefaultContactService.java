package com.singlestone.challenge.service;

import com.singlestone.challenge.persist.Contact;
import com.singlestone.challenge.persist.ContactRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultContactService implements ContactService {

    private final ContactRepository contactRepository;

    public DefaultContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact body) {
        return null;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> findCallable() {
        List<Contact> callableContactacts =contactRepository.findByCallable(Sort.by("name.last").and(Sort.by("name.first")));
        return callableContactacts;
    }
}
