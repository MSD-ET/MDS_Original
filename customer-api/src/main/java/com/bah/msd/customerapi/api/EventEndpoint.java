package com.bah.msd.customerapi.api;


import com.bah.msd.customerapi.domain.Event;
import com.bah.msd.customerapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/event")
public class EventEndpoint {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public Iterable<Event> all(){
        return eventService.findAll();
    }


    @GetMapping("/{name}")
    public Event findByName(@PathVariable String name){
        System.out.println("findByName: " + name);
        return eventService.findByName(name);
    }

}