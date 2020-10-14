package com.bah.msd.api;
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

import com.bah.msd.api.domain.Customer;
import com.bah.msd.api.domain.Registration;
import com.bah.msd.api.service.RegistrationService;

import logging.Logging;

@RestController
@RequestMapping("/api/registrations/")
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

	
	@PostMapping
	public ResponseEntity<?> addRegistration (@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if (newRegistration.getId() > 0 || newRegistration.getNotes() == null || newRegistration.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = service.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
		
	}
	
	
	
	
	@PutMapping
	public ResponseEntity<?> putRegistration(
			@RequestBody Registration newRegistration) 
	{
		if (newRegistration.getId() < 0 || newRegistration.getNotes() == null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = service.save(newRegistration);
		return ResponseEntity.ok().build();
	}	
	
	
	
	@DeleteMapping("/{registrationId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("registrationId") long id) {
		
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	/*
	 * @DeleteMapping("/{registrationDate}") public ResponseEntity<?>
	 * deleteCustomerByName(@PathVariable("registrationDate") Date
	 * registration_date) { // repo.delete(id);
	 * service.deleteByDate(registration_date); return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build(); }
	 */


}


