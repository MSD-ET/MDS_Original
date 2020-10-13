package com.bah.msd.api.repository;


import org.springframework.data.repository.CrudRepository;

import com.bah.msd.api.domain.Event;

	public interface EventRepository extends CrudRepository<Event, Long> {

	
	}
