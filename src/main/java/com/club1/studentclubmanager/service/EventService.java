package com.club1.studentclubmanager.service;


import com.club1.studentclubmanager.exception.UserNotFoundException;
import com.club1.studentclubmanager.model.Event;
import com.club1.studentclubmanager.repo.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event){
        return eventRepository.save(event);
    }

    public List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event){
        return eventRepository.save(event);
    }

    public Event findEventById(Long id){
        return eventRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("event by id "+ id + " was not found"));
    }
    public void deleteEventById(Long id){
        boolean exists = eventRepository.existsById(id);
        if (!exists){
            throw new UserNotFoundException("event by id " + id + " was not found");
        }
        eventRepository.deleteById(id);
    }
}
