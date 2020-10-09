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
}
