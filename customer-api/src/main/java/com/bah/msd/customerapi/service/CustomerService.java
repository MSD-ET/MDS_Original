package com.bah.msd.customerapi.service;


import com.bah.msd.customerapi.domain.Customer;



/**
 * Contract Obligation
 */
public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(long id);
    
    Customer findByName(String name);
    
	String deleteByName(String name);
	
    int deleteById(long id);
    
    long add(Customer customer);
    
    Customer update(Customer customer);

	Customer findByEmail(String email);

	Customer save(Customer newCustomer);
}
