package com.bah.msd.api.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.api.domain.Registration;

	public interface RegistrationRepository extends CrudRepository<Registration, Long> {

		//Registration findByName(String name);

		//Registration findByRegistration_Date(Date registration_date);

		//public void deleteByRegistration_Date(Date registration_date);
	
}
	