/**
 * 
 */
package au.com.rlc.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import au.com.rlc.spring.boot.exception.ResourceNotFoundException;
import au.com.rlc.spring.boot.models.Clients;
import au.com.rlc.spring.boot.models.Contact_Persons;
import au.com.rlc.spring.boot.payload.request.ClientRequest;
import au.com.rlc.spring.boot.payload.response.MessageResponse;
import au.com.rlc.spring.boot.repository.ClientRepository;
import au.com.rlc.spring.boot.repository.JobsRepository;
import au.com.rlc.spring.boot.util.Util;

/**
 * @author srini
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	JobsRepository jobsRepository;
	// get all Clients
	@GetMapping("/all")
	public ResponseEntity<List<Clients>> getAllClient() {
		List<Clients> list = clientRepository.findAll();
		return ResponseEntity.ok(list);

	}

	@PostMapping("/create")
	public ResponseEntity<?> createClient(@Valid @RequestBody ClientRequest request) throws JsonProcessingException {

		System.out.println(" Object ==>> " + request.toString());

		List<Contact_Persons> contact_persons = new ArrayList<Contact_Persons>();
		request.getPersons().forEach(person -> {
			Contact_Persons contact_Person = new Contact_Persons();
			contact_Person.setContactpersonname(person.getContactpersonname());
			contact_Person.setContactpersonmobile(person.getContactpersonmobile());
			contact_persons.add(contact_Person);
		});

		Clients client = new Clients(request.getClientabn(), request.getClientname(), request.getTelphone(),
				request.getEmail(), request.getBillingaddress(), request.getShippingaddress(), contact_persons);

		client.setActive("Y");
		client.setCreatedDate("");
		client.setCreatedUser("");
		

		Clients client1= clientRepository.save(client); 
		/*client.setId(new Long(6));
		Clients client1 = clientRepository.findById(client.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + client.getId())); */

		return ResponseEntity.ok(client1);

		// return ResponseEntity.ok(new MessageResponse("Client has been Created
		// successfully!"));
	}

	// get employee by id rest api
	@GetMapping("/client/{id}")
	public ResponseEntity<Clients> getEmployeeById(@PathVariable Long id) {
		Clients client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		System.out.println("client ::==> in get :: ==>> :: " + client.toString());
		return ResponseEntity.ok(client);
	}

	
	 @PutMapping("/client/{id}") 
	 public ResponseEntity<?>
	  updateEmployee(@PathVariable Long id, @RequestBody ClientRequest request){
		 System.out.println("Updating Client request :: ==> "+ request.toString());
	 
		 Clients client = clientRepository.findById(id) .orElseThrow(() -> new
	  ResourceNotFoundException("Employee not exist with id :" + id));
	  
	  client.setClientabn(request.getClientabn());
	  client.setEmial(request.getEmail());
	  client.setClientname(request.getClientname());
	  client.setTelphonenum(request.getTelphone());
	  client.setBillingaddress(request.getBillingaddress());
	  client.setShippingaddress(request.getShippingaddress());
	  System.out.println("Updating Client request :: ==> "+ client.toString());
	  Clients updatedClient = clientRepository.save(client); 
	  return ResponseEntity.ok(updatedClient); 
	  
	 }
	  
}
