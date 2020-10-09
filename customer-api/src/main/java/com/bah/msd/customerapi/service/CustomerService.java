package com.bah.msd.customerapi.service;


import com.bah.msd.customerapi.domain.Customer;



/**
 * Contract Obligation
 */
public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(long id);

}
