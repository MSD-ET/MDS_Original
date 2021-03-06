package com.bah.msd.api.service;

import java.util.Optional;

import com.bah.msd.api.domain.Customer;

/**
 * Contract Obligation
 */
public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(Long id);
    
    Optional<Customer> findByName(String name);
    
	String deleteByName(String name);
	

	//Customer findByEmail(String email);

	Customer save(Customer newCustomer);
	
	public void deleteById(Long id);
	
}
