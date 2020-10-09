package com.bah.msd.customerapi.service;

import com.bah.msd.customerapi.domain.Registration;

public interface RegistrationService {
	
    Iterable<Registration> findAll();

    Registration findByDate(String date);

}
