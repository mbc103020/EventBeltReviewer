package com.eventbeltreviewer.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eventbeltreviewer.models.Event;
import com.eventbeltreviewer.repositories.EventRepository;


@Service
public class EventService {
	
	private final EventRepository eventRepository; 
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository; 
	}
	
	public List<Event> allEvents() {
        return eventRepository.findAll();
    }
    // creates an event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    // retrieves an event
    public Event findEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
        
        
    }
    
    public void save(Event event) {
		this.eventRepository.save(event);
	}
    
    public Event updateEvent(Long id, String name, Date date, String city, String state) {
    	
    	Event event = findEventById(id); 
    	
    	if(event != null) {
    		event.setName(name);
    		event.setDate(date);
    		event.setCity(city);
    		event.setState(state);
    		this.save(event); 
    	}
    	return event; 
    	
    }
    
    public void deleteEvent(Long id) {
    	Optional<Event> optionalEvent = eventRepository.findById(id); 
    	if(optionalEvent.isPresent()) {
    		eventRepository.deleteById(id);
    	}
    }
	

}
