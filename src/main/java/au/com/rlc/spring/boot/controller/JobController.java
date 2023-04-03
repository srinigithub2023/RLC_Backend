package au.com.rlc.spring.boot.controller;

import java.util.ArrayList;
import java.util.Date;
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

import au.com.rlc.spring.boot.exception.ResourceNotFoundException;
import au.com.rlc.spring.boot.models.Clients;
import au.com.rlc.spring.boot.models.Jobs;
import au.com.rlc.spring.boot.models.Materials;
import au.com.rlc.spring.boot.models.Outsource;
import au.com.rlc.spring.boot.models.Quotes;
import au.com.rlc.spring.boot.payload.request.ClientRequest;
import au.com.rlc.spring.boot.payload.request.JobDetails;
import au.com.rlc.spring.boot.payload.request.JobRequest;
import au.com.rlc.spring.boot.payload.request.Material;
import au.com.rlc.spring.boot.payload.request.OutSource;
import au.com.rlc.spring.boot.payload.response.JobsdetailsResponse;
import au.com.rlc.spring.boot.payload.response.MessageResponse;
import au.com.rlc.spring.boot.repository.ClientRepository;
import au.com.rlc.spring.boot.repository.JobsRepository;
import au.com.rlc.spring.boot.repository.QuoteRepository;
import au.com.rlc.spring.boot.util.Util;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/job")

public class JobController {
	
	@Autowired
	JobsRepository jobsRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createClient(@Valid @RequestBody JobRequest request) throws JsonProcessingException {
		System.out.println(" Object ==>> "+ request.toString());
		
		if(request != null) {
			//need to create job & get job id 
			JobDetails details= request.getJobDetails();
			Jobs jobs= new Jobs(new Long(6), new Long(3), details.getPurchaseorder(), details.getFixedprice(), details.getApprovedmethod(),
					details.getApprovedby(),details.getDrawingdatetime(), details.getDuedatetime(), details.getComment(),new Date() ,"Srini");
			
			
			  Material material = request.getMaterial();
			  
			  if(material != null) {
				  List<Materials> materialLst= new ArrayList<Materials>();
				  if(material.getSheet()) {
					  material.getSheetDetailsArray().stream().forEach((c) -> {
						  Materials materials = new  Materials();
						  materials.setType("Sheet");
						  materials.setSheetThickness(c.getSheetMaterial());
						  materials.setSheetType(c.getSheetMaterial());
						  materialLst.add(materials);
					  });
					  
					 
				  	}
				
					  if(material.getTube()) {
						  material.getTubeDetailsArray().stream().forEach((c) -> {
							  Materials materials = new  Materials();
							  materials.setType("Tube");
							  materials.setTubeType(c.getTubeMaterial());
							  materials.setTubeQuantity(c.getTubeQuatity());
							  materials.setTubeDimensions(c.getTubeDimension());
							  materialLst.add(materials);
						  });
						  
						 
					  }
					  if(material.getFreeIssue()) {
						  material.getMaterailOrderArray().stream().forEach((c) -> {
							  Materials materials = new  Materials();
							  materials.setType("Free Issue");
							  materials.setOrderNumber(c.getOderNumber());
							  materials.setOrderBy(c.getOrderBy());
							  materials.setSupplier(c.getSupplier());
							  materials.setArrivalDate(c.getArriveddate());
							  materialLst.add(materials);
						  });
						  
						 
					  	}
					  jobs.setMaterialsLst(materialLst);
					  
					  
				}	  
			  System.out.println("Materials "+ jobs.getMaterialsLst().size());
			  System.out.println("Materials "+ jobs.getMaterialsLst().toString());
			//quoteRepository.save(request);
			 OutSource outSource = request.getOutSource(); 
			 if(outSource != null && outSource.getOutsourcing()
					 && outSource.getOutSourcingArray().size() >0) {
				 List<Outsource> outSourceLst= new ArrayList<Outsource>();
				 if(outSource.getOutsourcing()) {
					 outSource.getOutSourcingArray().stream().forEach((c) -> {
						 
						Outsource outsource1= new Outsource();
						outsource1.setSourceType("OutSourcing");
						outsource1.setType(c.getType());
						outsource1.setCompany(c.getCompany());
						outSourceLst.add(outsource1);
					 });
				 }
				 jobs.setOutSourceLst(outSourceLst);
				 
				 System.out.println("Materials "+ jobs.getOutSourceLst().size());
				  System.out.println("Materials "+ jobs.getOutSourceLst().toString());
			 } 
			  
			//Jobs jobs1= jobsRepository.save(jobs);
			 System.out.println("jobs1 ::==> "+ jobs.toString());
					// Update Materials table 
			return ResponseEntity.ok(new MessageResponse("Jobs has been Created successfully!"));
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
			public ResponseEntity<List<Jobs>> getAllQuotes() {
				List<Jobs> list = jobsRepository.findAll();
				System.out.println("job list ::==>> :: "+ list);
				return ResponseEntity.ok(list);

			}
	
			@GetMapping("/searchbyname")
			public ResponseEntity<JobsdetailsResponse> getClientByName(@RequestParam Map<String, String> params) {
				System.out.println(params.keySet());
				System.out.println(params.values());
				String selectOption = params.get("selectOption").toString();
				String value = params.get("value").toUpperCase();

				params.values().forEach(v -> System.out.println(("value: " + v)));

				Clients client = null;
				Jobs jobs = null;
				JobsdetailsResponse jobsdetailsResponse = null;
				if (selectOption.equalsIgnoreCase(Util.selectoption_Name)) {
					System.out.println("in Name");
					client = clientRepository.findByclientname(value);
					jobs = jobsRepository.findByclientId(client.getId());
					System.out.println("jobs :: ==> "+ jobs);
					
					jobsdetailsResponse= Util.prepareJobDetailResponse(client, jobs);
				} else if (selectOption.equalsIgnoreCase(Util.selectoption_quoteNumber)) {
					System.out.println("in ABN");
					//client = clientRepository.findByQuoteNumber(value);
				} else if (selectOption.equalsIgnoreCase(Util.selectoption_email)) {
					System.out.println("in email");
					client = clientRepository.findByemial(value);
				}

				System.out.println("client ::==> in get :: ==>> :: " + client.toString());

				return ResponseEntity.ok(jobsdetailsResponse);
			}
}
