package com.bah.msd.api;

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

import com.bah.msd.api.domain.Customer;
import com.bah.msd.api.repository.CustomerRepository;
import com.bah.msd.api.service.CustomerService;

import logging.Logging;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

	@Autowired
	CustomerService service;

	@GetMapping
	public Iterable<Customer> getAll() {
		return service.findAll();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		
		return service.findById(id);
	}



	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		System.out.println("Customer added: " + newCustomer);
		if (newCustomer.getId() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			System.out.println(" Reject we'll assign the customer id: " + newCustomer);// Reject we'll assign the customer id
			return ResponseEntity.badRequest().build();
		}
		newCustomer = service.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
		// DO YOU NEED TO CREATE A POST MAPPING FOR NAME AND EMAIL?????????????????
	}

	// lookupCustomerByName GET
	@GetMapping("/byname/{name}")
	public ResponseEntity<?> lookupCustomerByNameGet(@PathVariable("name") String name, UriComponentsBuilder uri) {
		System.out.println("lookupCustomerByNameGet: " + name);
		
		Logging.log("username: " + name);
		Optional<Customer> result = service.findByName(name);
		if(result.isPresent()) {
			return ResponseEntity.ok(result.get());
			
		}
		else {
			return ResponseEntity.badRequest().build();
		}
		

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer, @PathVariable long id) {
		System.out.println("Create new ID: " + id + " For customer: " + newCustomer);
		if (newCustomer.getId() != id  || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			System.out.println("Did not work: " + newCustomer);
			return ResponseEntity.badRequest().build();
			
		}
		newCustomer = service.save(newCustomer);
		return ResponseEntity.ok().build();
	}

	

	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	/*
	 * @DeleteMapping("/{customerName}") public ResponseEntity<?>
	 * deleteCustomerByName(@PathVariable("customerName") String name) { //
	 * //repo.delete(id); service.deleteByName(name); return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build(); }
	 */

}
