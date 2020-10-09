package com.bah.msd.customerapi.api;


import com.bah.msd.customerapi.domain.Registration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Component
public class RegistrationClient {

    RestTemplate template = new RestTemplate();

    @GetMapping("/test")
    public Registration getRegistrationDetails(){
        Registration r = template.getForObject("http://localhost:8080/registration/{date}", //revise, not sure if name or ID
                                            Registration.class,
                0L);

        System.out.println("event client : " + r);
        return r;
    }
}
