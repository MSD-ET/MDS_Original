package com.bah.msd.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.msd.api.domain.Registration;
import com.bah.msd.api.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository repository;

	@Override
	public Iterable<Registration> findAll() {
		return repository.findAll();
	}


	@Override
	public Registration findById(Long id) {
		// TODO Auto-generated method stub
		return (repository.findById(id)).get();
	}



	/*
	 * @Override public Registration findByName(String name) { // TODO
	 * Auto-generated method stub return repository.findByName(name); }
	 */




	/*
	 * @Override public Registration findByRegistration_Date(Date registration_date)
	 * { // TODO Auto-generated method stub return
	 * repository.findByRegistration_Date(registration_date); }
	 * 
	 */
	@Override
	public Registration save(Registration newRegistration) {
		// TODO Auto-generated method stub
		return repository.save(newRegistration);
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
	}


	/*
	 * @Override public Registration deleteByDate(Date registration_date) { // TODO
	 * Auto-generated method stub return null; }
	 */
}
