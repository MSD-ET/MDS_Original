package com.bah.msd.customerapi;
import java.net.URI;
import java.util.Iterator;
import java.util.Optional;

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

import com.bah.msd.customerapi.domain.Event;
import com.bah.msd.customerapi.repository.EventRepository;

import logging.Logging;

@RestController
@RequestMapping("/events")
public class EventAPI {
	
	@Autowired
	EventRepository service;

	@GetMapping
	public Iterable<Event> getAll() {
		return service.findAll();
	}

	@GetMapping("/{eventId}")
	public Optional<Event> getEventById(@PathVariable("eventId") long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 || newEvent.getName() == null || newEvent.getCode() == null) {
			// Reject we'll assign the customer id
			return ResponseEntity.badRequest().build();
		}
		newEvent = service.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}") 
				.buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	//lookupCustomerByName GET
	@GetMapping("/byname/{username}")
	public ResponseEntity<?> lookupCustomerByNameGet(@PathVariable("username") String username,
			UriComponentsBuilder uri) {
		Logging.log("username: " + username);
		
		Iterator<Customer> customers = service.findAll().iterator();
		while(customers.hasNext()) {
			Customer cust = customers.next();
			if(cust.getName().equalsIgnoreCase(username)) {
				ResponseEntity<?> response = ResponseEntity.ok(cust);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//lookupCustomerByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupCustomerByNamePost(@RequestBody String username, UriComponentsBuilder uri) {
		Logging.log("username: " + username);
		Iterator<Customer> customers = service.findAll().iterator();
		while(customers.hasNext()) {
			Customer cust = customers.next();
			if(cust.getName().equals(username)) {
				ResponseEntity<?> response = ResponseEntity.ok(cust);
				return response;				
			}			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}	
	
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(
			@RequestBody Customer newCustomer,
			@PathVariable("customerId") long customerId) 
	{
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = service.save(newCustomer);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		// repo.delete(id);
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	

}
