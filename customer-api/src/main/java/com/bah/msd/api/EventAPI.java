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
import com.bah.msd.api.domain.Event;
import com.bah.msd.api.repository.EventRepository;
import com.bah.msd.api.service.EventService;

import logging.Logging;

@RestController
@RequestMapping("/events")
public class EventAPI {
	
	@Autowired
	EventService service;

	@GetMapping
	public Iterable<Event> getAll() {
		return service.findAll();
	}

	@GetMapping("/{eventId}")
	public Event getEventById(@PathVariable("eventId") long id) {
		return service.findById(id);
	}
	
	@PostMapping //post id
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() > 0 || newEvent.getCode() == null) {
			// Reject we'll assign the customer id
			return ResponseEntity.badRequest().build();
		}
		newEvent = service.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") 
				.buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	
	
	@PutMapping
	public ResponseEntity<?> putEvent(@RequestBody Event newEvent) 
	{
		if (newEvent.getId() < 0 || newEvent.getCode() == null ) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = service.save(newEvent);
		return ResponseEntity.ok().build();
	}	
	
	
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteEventById(@PathVariable("eventId") long id) {
		
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	/*
	 * @DeleteMapping("/{eventCode}") public ResponseEntity<?>
	 * deleteEventByCode(@PathVariable("eventCode") String code) { //
	 * repo.delete(id); service.deleteByCode(code); return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build(); }
	 */

}
