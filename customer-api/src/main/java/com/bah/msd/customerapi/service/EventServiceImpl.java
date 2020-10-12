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
    public Event findById(long id) {

        // Java 8 feature called (Optional (Customer) ) (NPE)
    	 return ( repository.findById(id) ).get();
    }

	@Override
	public Event findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	@Override
	public Event deleteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long add(Event event) {
		// TODO Auto-generated method stub
		return repository.add(event);
	}

	@Override
	public Event update(Event event) {
		// TODO Auto-generated method stub
		return repository.update(event);
	}

	@Override
	public Event findByCode(String code) {
		// TODO Auto-generated method stub
		return repository.findByCode(code);
	}

	@Override
	public String deleteByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
