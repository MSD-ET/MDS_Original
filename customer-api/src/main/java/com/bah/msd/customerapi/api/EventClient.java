package com.bah.msd.customerapi.api;


import com.bah.msd.customerapi.domain.Event;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Component
public class EventClient {

    RestTemplate template = new RestTemplate();

    @GetMapping("/test")
    public Event getEventDetails(){
        Event e = template.getForObject("http://localhost:8080/event/{name}", //revise, not sure if name or ID
                                            Event.class,
                0L);

        System.out.println("event client : " + e);
        return e;
    }
}
