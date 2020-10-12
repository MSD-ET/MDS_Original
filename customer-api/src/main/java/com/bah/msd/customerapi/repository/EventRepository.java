package com.bah.msd.customerapi.repository;


import org.springframework.data.repository.CrudRepository;

import com.bah.msd.customerapi.domain.Event;

	public interface EventRepository extends CrudRepository<Event, Long> {

		Event findByName(String name);

		long add(Event event);

		Event update(Event event);

		Event findByCode(String code);

		String deleteByCode(String code);

		
	

	

}
