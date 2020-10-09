package com.bah.msd.customerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.msd.customerapi.domain.Event;
import com.bah.msd.customerapi.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository repository;

    @Override
    public Iterable<Event> findAll() {
        return repository.findAll();
    }

    @Override
    public Event findByName(String name) {

        // Java 8 feature called (Optional (Customer) ) (NPE)
        return ( repository.findByName(name) ).get();
    }

}
