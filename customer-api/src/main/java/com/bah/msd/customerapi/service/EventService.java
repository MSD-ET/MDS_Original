package com.bah.msd.customerapi.service;

import com.bah.msd.customerapi.domain.Event;

public interface EventService {
	
    Iterable<Event> findAll();

    Event findByName(String name);

}
