package com.bah.msd.api.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.api.domain.Customer;

// java Generics
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // No methods needed.

   // boolean existsByEmail(String email);
    //boolean existsByName(String email);
	
	Optional <Customer> findByName(String name);
	
	//Customer findByEmail(String email);

	String deleteByName(String name);
	
	
}
