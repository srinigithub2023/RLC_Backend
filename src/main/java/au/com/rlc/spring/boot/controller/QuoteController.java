package au.com.rlc.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import au.com.rlc.spring.boot.models.Clients;
import au.com.rlc.spring.boot.models.Contact_Persons;
import au.com.rlc.spring.boot.models.Jobs;
import au.com.rlc.spring.boot.models.Quotes;
import au.com.rlc.spring.boot.payload.request.ClientRequest;
import au.com.rlc.spring.boot.payload.request.QuoteRequest;
import au.com.rlc.spring.boot.payload.response.JobsdetailsResponse;
import au.com.rlc.spring.boot.payload.response.MessageResponse;
import au.com.rlc.spring.boot.repository.ClientRepository;
import au.com.rlc.spring.boot.repository.ContactPersonRepository;
import au.com.rlc.spring.boot.repository.QuoteRepository;
import au.com.rlc.spring.boot.util.Util;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/quotes")

public class QuoteController {
	
	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ContactPersonRepository conctPersonRepo;
	
	@PostMapping("/create")
	public ResponseEntity<?> createClient(@Valid @RequestBody QuoteRequest quoteRequest) throws JsonProcessingException {
		System.out.println(" Object ==>> "+ quoteRequest.toString());
		Quotes quotes= Util.prepareQuoteRequest(quoteRequest);
		System.out.println(" quotes ==>> "+ quotes.toString());
		
		if(quotes != null) {
			Quotes quotes2= quoteRepository.save(quotes);
			System.out.println(" quotes2 ==>> "+ quotes2.toString());
			if(quotes2 != null) {
				List<Contact_Persons> contact_persons = new ArrayList<Contact_Persons>();
				quoteRequest.getPersons().forEach(person -> {
						Contact_Persons contact_Person = new Contact_Persons();
						contact_Person.setContactpersonname(person.getContactpersonname());
						contact_Person.setContactpersonmobile(person.getContactpersonmobile());
						contact_Person.setQuoteid(quotes2.getId());
						contact_Person.setClientid(quoteRequest.getClientid());
						contact_persons.add(contact_Person);
						conctPersonRepo.save(contact_Person);
					});
				
				
			}
			return ResponseEntity.ok(new MessageResponse("Quote has been Created successfully!"));
		}
			//return ResponseEntity.badRequest();
		return null;
			
		  /*Clients clients = clientRepository.findById(client.getId()) .orElseThrow(()
		  -> new ResourceNotFoundException("Employee not exist with id :" +
		  client.getId()));
		  
		  return ResponseEntity.ok(clients);*/ 
		 
		
		
	}
	
	// get all Clients
		@GetMapping("/list")
		public ResponseEntity<List<Quotes>> getAllQuotes() {
			List<Quotes> list = quoteRepository.findAll();
			return ResponseEntity.ok(list);

		}
		
		@GetMapping("/searchbyname")
		public ResponseEntity<Clients> getCompanyByName(@RequestParam Map<String, String> params) {
			
			String selectOption = params.get("selectOption").toString();
			String value = params.get("value").toUpperCase();

			

			Clients client = null;

			if (selectOption.equalsIgnoreCase(Util.selectoption_Name)) {
				client = clientRepository.findByclientname(value);
			} else {
				client= null;
			}

			return ResponseEntity.ok(client);
		}
		

}
