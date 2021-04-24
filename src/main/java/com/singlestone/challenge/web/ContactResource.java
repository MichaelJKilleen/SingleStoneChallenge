package com.singlestone.challenge.web;

import com.singlestone.challenge.persist.Contact;
import com.singlestone.challenge.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<Contact> contact = contactService.findById(id);
        if(contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.status(204).build();

    }

    @GetMapping("/contacts/call-list")
    public ResponseEntity<List<Contact>> getCallableContacts() {
        List<Contact> contacts = contactService.findCallable();
        return ResponseEntity.ok(contacts);
    }
    //GET	/contacts/call-list	Get a call list (see detailed requirements in item #4 below)
    /*
    4.	The call list is generated from all contacts that include a home phone.
    It is sorted first by the contact’s last name, then by first name, and
    returned as an array of objects that each have the following JSON format:
     */

}
