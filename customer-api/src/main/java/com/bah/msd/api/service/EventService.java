package com.bah.msd.api.service;


import com.bah.msd.api.domain.Event;

public interface EventService {
	
    Iterable<Event> findAll();

    Event findById(Long id);
    
   // Event findByCode(String code);

    Event deleteById(Long id);
   
    Event save(Event newEvent);
    
	//String deleteByCode(String code);

}
