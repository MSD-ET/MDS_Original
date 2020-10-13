package com.bah.msd.api.service;

import java.util.Date;

import com.bah.msd.api.domain.Registration;

public interface RegistrationService {
	
    Iterable<Registration> findAll();

    Registration findById(Long id);
    
    //Registration findByName(String name);
    
    //Registration findByRegistration_Date(Date registration_date);

    Registration deleteById(Long id);

	Registration save(Registration newRegistration);

	//Registration deleteByDate(Date registration_date);



}
