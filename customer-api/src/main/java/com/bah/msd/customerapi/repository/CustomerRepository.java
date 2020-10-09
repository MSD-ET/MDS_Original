package com.bah.msd.customerapi.repository;


import com.bah.msd.customerapi.domain.Customer;
import org.springframework.data.repository.CrudRepository;

// java Generics
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // No methods needed.


//    boolean existsByEmail(String email);
//    boolean existsByName(String email);
	
	
}
