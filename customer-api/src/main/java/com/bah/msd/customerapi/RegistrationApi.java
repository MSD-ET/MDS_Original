package com.bah.msd.customerapi;

import java.net.URI;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.msd.customerapi.domain.Customer;
import com.bah.msd.customerapi.domain.Registration;
import com.bah.msd.customerapi.service.CustomerService;
import com.bah.msd.customerapi.service.RegistrationService;

import logging.Logging;

@RestController
@RequestMapping("/registrations")
public class RegistrationApi {

	@Autowired
	RegistrationService service;

	@GetMapping
	public Iterable<Registration> getAll() {
		return service.findAll();
	}

	@GetMapping("/{registrationId}")
	public Registration getRegistationById(@PathVariable("registrationId") long id) {
		//return repo.findOne(id);
		return service.findById(id);
	}


//	@GetMapping("/{customerEmail}")
//	public Customer getCustomerByEmail(@PathVariable("customerEmail") String email) {
//		//return repo.findOne(id);
//		return service.findByEmail(email);
//	}
//	
	
	@PostMapping
	public ResponseEntity<?> addRegistration (@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if (newRegistration.getId() != 0 || newRegistration.getNotes() == null || newRegistration.getRegistration_date() == null) {
			// Reject we'll assign the customer id
			return ResponseEntity.badRequest().build();
		}
		newRegistration = service.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
//DO YOU NEED TO CREATE A POST MAPPING FOR NAME AND EMAIL?????????????????
	}
	

	//lookupCustomerByName GET
	@GetMapping("/bydate/{date}")
	public ResponseEntity<?> lookupRegistrationByDateGet(@PathVariable("date") Date date,
			UriComponentsBuilder uri) {
		Logging.log("registationdate: " + date);
		
	Registration newRegistration = service.findByDate(date);
	ResponseEntity<?> response = ResponseEntity.ok(newRegistration);
	return response;
	}
	
	
	@PostMapping("/bydate")
	public ResponseEntity<?> lookupRegistrationByPost(@RequestBody Date date, UriComponentsBuilder uri) {
		Logging.log("registrationdate: " + date);
		Iterator<Registration> registrations = service.findAll().iterator();
		while(registrations.hasNext()) {
			Registration reg = registrations.next();
			if(reg.getRegistration_date().equals(date)) {
				ResponseEntity<?> response = ResponseEntity.ok(reg);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}	
	
	
	@PutMapping("/{registrationId}")
	public ResponseEntity<?> putRegistration(
			@RequestBody Registration newRegistration,
			@PathVariable("registrationId") long registrationId) 
	{
		if (newRegistration.getId() != registrationId || newRegistration.getNotes() == null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = service.save(newRegistration);
		return ResponseEntity.ok().build();
	}	
	
	@PutMapping("/{registrationDate}")
	public ResponseEntity<?> putRegistration(
			@RequestBody Registration newRegistration,
			@PathVariable("registrationDate") Date registrationDate) 
	{
		if (newRegistration.getId() != 0 || newRegistration.getRegistration_date() == registrationDate ) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = service.save(newRegistration);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{registrationId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("registationId") long id) {
		// repo.delete(id);
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	@DeleteMapping("/{registrationDate}")
	public ResponseEntity<?> deleteCustomerByName(@PathVariable("registrationDate") Date date) {
		// repo.delete(id);
		service.deleteByDate(date);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	

}

