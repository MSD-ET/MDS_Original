package com.bah.msd.customerapi.service;


import com.bah.msd.customerapi.domain.Event;

public interface EventService {
	
    Iterable<Event> findAll();

    Event findById(long id);
    
    Event findByName(String name);
    
    Event findByCode(String code);

    Event deleteById(long id);
    
    long add(Event event);
    
    Event update(Event event);
    
	String deleteByCode(String code);

}
