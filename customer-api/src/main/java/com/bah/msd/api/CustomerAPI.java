package com.bah.msd.api;

import java.net.URI;
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
import com.bah.msd.api.repository.CustomerRepository;
import com.bah.msd.api.service.CustomerService;

import logging.Logging;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {

	@Autowired
	CustomerService service;

	@GetMapping
	public Iterable<Customer> getAll() {
		return service.findAll();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		// return repo.findOne(id);
		return service.findById(id);
	}

//		@GetMapping("/{customerEmail}")
//		public Customer getCustomerByEmail(@PathVariable("customerEmail") String email) {
//			//return repo.findOne(id);
//			return service.findByEmail(email);
//		}
//		

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		if (newCustomer.getId() <= 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			// Reject we'll assign the customer id
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
		Logging.log("username: " + name);

		Customer newCustomer = service.findByName(name);
		ResponseEntity<?> response = ResponseEntity.ok(newCustomer);
		return response;

	}

//		lookupCustomerByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupCustomerByNamePost(@RequestBody String name, UriComponentsBuilder uri) {
		Logging.log("username: " + name);
		Iterator<Customer> customers = service.findAll().iterator();
		while (customers.hasNext()) {
			Customer cust = customers.next();
			if (cust.getName().equals(name)) {
				ResponseEntity<?> response = ResponseEntity.ok(cust);
				return response;
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
			@PathVariable("customerId") long customerId) {
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = service.save(newCustomer);
		return ResponseEntity.ok().build();
	}

	/*
	 * @PutMapping("/{customername}") public ResponseEntity<?> putCustomer(
	 * 
	 * @RequestBody Customer newCustomer,
	 * 
	 * @PathVariable("customerName") String customerName) { if (newCustomer.getId()
	 * <= 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
	 * return ResponseEntity.badRequest().build(); } newCustomer =
	 * service.save(newCustomer); return ResponseEntity.ok().build(); }
	 */ // POSSIBLY MAKE ONE FOR EMAIL?

	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		// repo.delete(id);
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{customerName}")
	public ResponseEntity<?> deleteCustomerByName(@PathVariable("customerName") String name) { //
		//repo.delete(id);
		service.deleteByName(name);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
