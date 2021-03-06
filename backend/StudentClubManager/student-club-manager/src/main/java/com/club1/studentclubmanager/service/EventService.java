package com.club1.studentclubmanager.service;


import com.club1.studentclubmanager.exception.CustomNotFoundException;
import com.club1.studentclubmanager.model.Event;
import com.club1.studentclubmanager.model.School;
import com.club1.studentclubmanager.repo.EventRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event){
        // Event date is checked.
        if ( !isEventEligible(event))
            return null;

        return eventRepository.save(event);
    }

    public List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event, Long id){

        // event date is checked
        if ( !isEventEligible(event))
            return null;

        // Check if the event exists
        Event existingEvent = eventRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Event by id "+ id + " was not found"));


        existingEvent.setName(event.getName());
        existingEvent.setInfo(event.getInfo());
        existingEvent.setClub(event.getClub());
        existingEvent.setDate(event.getDate());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDuration(event.getDuration());

        return eventRepository.save(existingEvent);
    }

    public Event findEventById(Long id){
        return eventRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Event by id "+ id + " was not found"));
    }
    public void deleteEventById(Long id){
        boolean exists = eventRepository.existsById(id);
        if (!exists){
            throw new CustomNotFoundException("Event by id " + id + " was not found");
        }
        eventRepository.deleteById(id);
    }

    public boolean isEventEligible(Event event){
        // If event date is before the time event is created, return false.
        if ( event.getDate().before(Timestamp.from(Instant.now()))){
            System.out.println("Date cannot be before now.");
            return false;
        }
        return true;

    }
}
