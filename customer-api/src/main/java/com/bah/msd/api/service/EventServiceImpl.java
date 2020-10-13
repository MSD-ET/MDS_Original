package com.bah.msd.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.msd.api.domain.Event;
import com.bah.msd.api.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository repository;

    @Override
    public Iterable<Event> findAll() {
        return repository.findAll();
    }

    


	
	@Override
	public Event save(Event newEvent) {
		// TODO Auto-generated method stub
		return repository.save(newEvent);
	}





	@Override
	public Event findById(Long id) {
		// TODO Auto-generated method stub
		return  ( repository.findById(id) ).get();
	}





	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
	}

}
