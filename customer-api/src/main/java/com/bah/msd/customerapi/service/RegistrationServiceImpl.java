package com.bah.msd.customerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.msd.customerapi.domain.Registration;
import com.bah.msd.customerapi.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	


	    @Autowired
	    private RegistrationRepository repository;

	    @Override
	    public Iterable<Registration> findAll() {
	        return repository.findAll();
	    }

@Override
public Registration findByDate(String date) {

	        // Java 8 feature called (Optional (Customer) ) (NPE)
return ( repository.findByDate(date) ).get();
	    

	}
}




