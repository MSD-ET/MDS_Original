package com.bah.msd.customerapi.api;


import com.bah.msd.customerapi.domain.Registration;
import com.bah.msd.customerapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/registrations")
public class RegistrationEndpoint {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/")
    public Iterable<Registration> all(){
        return registrationService.findAll();
    }


    @GetMapping("/{date}")
    public Registration findByDate(@PathVariable String date){
        System.out.println("findByDate: " + date);
        return RegistrationService.findByDate(date);
    }

}