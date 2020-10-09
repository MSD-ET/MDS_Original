package com.bah.msd.customerapi.service;

import com.bah.msd.customerapi.domain.Customer;
import com.bah.msd.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// PROXY Pattern
// IoC
// Interface Driven Design

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(long id) {

        // Java 8 feature called (Optional (Customer) ) (NPE)
        return ( repository.findById(id) ).get();
    }

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		return (repository.findByName(name));
	}

	@Override
	public int deleteById(long id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public long add(Customer customer) {
		// TODO Auto-generated method stub
		return repository.add(customer);
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return repository.update(customer);
	}

	@Override
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

	@Override
	public String deleteByName(String name) {
		// TODO Auto-generated method stub
		return repository.deleteByName(name);
	}

	@Override
	public Customer save(Customer newCustomer) {
		// TODO Auto-generated method stub
		return repository.save(newCustomer);
	}

    
}
