package com.bah.msd.api.repository;


import org.springframework.data.repository.CrudRepository;

import com.bah.msd.api.domain.Customer;

// java Generics
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // No methods needed.

   // boolean existsByEmail(String email);
    //boolean existsByName(String email);
	
	Customer findByName(String name);
	
	//Customer findByEmail(String email);

	String deleteByName(String name);
	
	
}
