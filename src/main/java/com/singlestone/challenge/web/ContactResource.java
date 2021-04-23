package com.singlestone.challenge.web;

import com.singlestone.challenge.persist.Contact;
import com.singlestone.challenge.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactResource {

    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * List all contacts
     */
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.findAllContacts());
    }

    /**
     * Create a new contact
     */
    @PostMapping("/contacts")
    public ResponseEntity<Contact> createNewContact(@RequestBody Contact body) {
        return ResponseEntity.ok(contactService.save(body));
    }

    /**
     * Update a contact
     */
    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact body) {
        return ResponseEntity.ok(contactService.updateContact(id, body));
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.findById(id).orElse(new Contact()));

    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable Long id) {
        return ResponseEntity.status(204).build();

    }

    //GET	/contacts/call-list	Get a call list (see detailed requirements in item #4 below)

}
