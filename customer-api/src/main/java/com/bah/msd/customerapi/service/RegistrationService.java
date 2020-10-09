package com.bah.msd.customerapi.service;

import java.util.Date;

import com.bah.msd.customerapi.domain.Registration;

public interface RegistrationService {
	
    Iterable<Registration> findAll();

    Registration findById(long id);
    
    Registration findByName(String name);
    
    Registration findByDate(Date date);

    Registration deleteById(long id);
    
    long add(Registration registration);
    
    Registration update(Registration registration);

}
