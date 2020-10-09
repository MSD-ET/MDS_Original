package com.bah.msd.customerapi.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.customerapi.domain.Registration;

	public interface RegistrationRepository extends CrudRepository<Registration, Long> {

		Registration findByName(String name);

		long add(Registration registration);

		Registration update(Registration registration);

		Registration findByDate(Date date);

		
	
}
	