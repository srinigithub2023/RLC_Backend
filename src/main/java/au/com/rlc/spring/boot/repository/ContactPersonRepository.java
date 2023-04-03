package au.com.rlc.spring.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import au.com.rlc.spring.boot.models.Clients;
import au.com.rlc.spring.boot.models.Contact_Persons;

@Repository
public interface ContactPersonRepository extends JpaRepository<Contact_Persons, Long> {
	
	
}
