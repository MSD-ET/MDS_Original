package com.bah.msd.customerapi.service;


import com.bah.msd.customerapi.domain.Customer;

import java.util.List;

/**
 * Contract Obligation
 */
public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(long id);

}
