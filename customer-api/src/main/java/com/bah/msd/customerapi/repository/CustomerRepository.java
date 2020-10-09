package com.bah.msd.customerapi.repository;


import com.bah.msd.customerapi.domain.Customer;
import org.springframework.data.repository.CrudRepository;

// java Generics
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // No methods needed.


//    boolean existsByEmail(String email);
//    boolean existsByName(String email);
	
	Customer findByName(String name);

	long add(Customer customer);

	Customer update(Customer customer);
	
	int deleteById (long id);

	Customer findByEmail(String email);

	String deleteByName(String name);
	
	
}
