package com.club1.studentclubmanager.controller;


import com.club1.studentclubmanager.model.Event;
import com.club1.studentclubmanager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.findAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id){
        Event event = eventService.findEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        Event newEvent = eventService.addEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Long id,@RequestBody Event event){
        Event updatedEvent = eventService.updateEvent(event, id);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id){
        eventService.deleteEventById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
