package au.com.rlc.spring.boot.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.rlc.spring.boot.models.Clients;
import au.com.rlc.spring.boot.models.Contact_Persons;
import au.com.rlc.spring.boot.models.Jobs;
import au.com.rlc.spring.boot.models.Quotes;
import au.com.rlc.spring.boot.payload.request.Person;
import au.com.rlc.spring.boot.payload.request.QuoteRequest;
import au.com.rlc.spring.boot.payload.request.SignupRequest;
import au.com.rlc.spring.boot.payload.response.ClientResponse;
import au.com.rlc.spring.boot.payload.response.JobsdetailsResponse;
import au.com.rlc.spring.boot.repository.ContactPersonRepository;
import ch.qos.logback.core.net.server.Client;

public class Util {

	public static String selectoption_Name="clientname";
	public static String selectoption_quoteNumber="quoteNumber";
	public static String selectoption_email="email";
	
	public static SignupRequest createSignupRequest(Object requestObject) throws IOException {
		SignupRequest request = new SignupRequest();
		//request.setUsername(requestObject.);
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = requestObject.toString();	
		System.out.println(" jsonString :: ==> "+ jsonString);
        //read json file and convert to customer object
        SignupRequest request1 =  objectMapper.readValue(jsonString, SignupRequest.class);
		
		return request1;
	}
	
	
	public ClientResponse prepareClientResponse(Clients client) {
		ClientResponse clientResponse = new ClientResponse();
		clientResponse.setClientabn(client.getClientabn());
		clientResponse.setClientname(client.getClientname());
		clientResponse.setTelphone(client.getTelphonenum());
		clientResponse.setEmail(client.getEmial());
		clientResponse.setBillingaddress(client.getBillingaddress());
		clientResponse.setShippingaddress(client.getShippingaddress());
		/*
		 * List<Contact_Persons> contList = client.get Person person = new Person();
		 * person.setContactPersonMobile(contactPersonMobile);
		 * 
		 * clientResponse.setPersons(persons);
		 */
		
		
		return null;
		
	}
	
	public static Quotes prepareQuoteRequest(QuoteRequest quoteRequest) {
		Quotes quotes= new Quotes();
		quotes.setActive("A");
		quotes.setClientid(quoteRequest.getClientid());
		quotes.setComment(quoteRequest.getComment());
		quotes.setQuoteNum(quoteRequest.getQuoteNum());
		quotes.setQuoteprice(quoteRequest.getQuoteprice());
		if(quoteRequest.getContactperson()!=null) {
			quotes.setContactperson(quoteRequest.getContactperson());
		} /*
			 * else { List<Contact_Persons> contact_persons = new
			 * ArrayList<Contact_Persons>(); quoteRequest.getPersons().forEach(person -> {
			 * Contact_Persons contact_Person = new Contact_Persons();
			 * contact_Person.setContactpersonname(person.getContactpersonname());
			 * contact_Person.setContactpersonmobile(person.getContactpersonmobile());
			 * contact_persons.add(contact_Person); });
			 * quotes.setContact_Persons(contact_persons); }
			 */
		
		quotes.setCreatedDate(new Date());
		return quotes;
		
	}


	public static JobsdetailsResponse prepareJobDetailResponse(Clients client, Jobs jobs) {
		List<Person> persons= new ArrayList<Person>();
		JobsdetailsResponse jobsdetailsResponse = new JobsdetailsResponse();
		
		for (Contact_Persons contact_Persons : client.getContact_Persons()) {
			Person person = new Person();
			person.setPersonid(contact_Persons.getId());
			person.setContactpersonname(contact_Persons.getContactpersonname());
			person.setContactpersonmobile(contact_Persons.getContactpersonmobile());
			persons.add(person);
		}
		jobsdetailsResponse.setCompanyABN(client.getClientabn());
		jobsdetailsResponse.setContact_Persons(persons);
		jobsdetailsResponse.setCompanyName(client.getClientname());
		if(jobs!= null) {
			jobsdetailsResponse.setPurchaseOrder(jobs.getPurchaseOrder());
			jobsdetailsResponse.setComment(jobs.getComment());
			jobsdetailsResponse.setApprovedBy(jobs.getApprovedBy());
			jobsdetailsResponse.setQuoteId(jobs.getQuoteId());
			jobsdetailsResponse.setCreated(jobs.getCreatedDate());
			jobsdetailsResponse.setJobExists("Y");
		}else {
			jobsdetailsResponse.setJobExists("N");
		}
		return jobsdetailsResponse;
		
	}
}
