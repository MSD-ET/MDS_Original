package com.bah.msd.customerapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.customerapi.domain.Event;

	public interface EventRepository extends CrudRepository<Event, String> {
	

	

}
