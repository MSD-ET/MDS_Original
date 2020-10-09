package com.bah.msd.customerapi.api;


import com.bah.msd.customerapi.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Component
public class CustomerClient {

    RestTemplate template = new RestTemplate();

    @GetMapping("/test")
    public Customer getCustomerDetails(){
        Customer c = template.getForObject("http://localhost:8080/customer/{id}",
                                            Customer.class,
                0L);

        System.out.println("customer client : " + c);
        return c;
    }
}
