package com.singlestone.challenge.persist;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from Contact c join c.phone p where p.type = 'home'")
    List<Contact> findByCallable(Sort sort);
}
