package com.bah.msd.customerapi.service;

import java.util.Date;

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
	public Registration findById(long id) {
		// TODO Auto-generated method stub
		return (repository.findById(id)).get();
	}



	@Override
	public Registration findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}



	@Override
	public Registration deleteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long add(Registration registration) {
		// TODO Auto-generated method stub
		return repository.add(registration);
	}



	@Override
	public Registration update(Registration registration) {
		// TODO Auto-generated method stub
		return repository.update(registration);
	}


	@Override
	public Registration findByDate(Date date) {
		// TODO Auto-generated method stub
		return repository.findByDate(date);
	}


	@Override
	public Registration save(Registration newRegistration) {
		// TODO Auto-generated method stub
		return newRegistration;
	}


	@Override
	public Registration deleteByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
}
