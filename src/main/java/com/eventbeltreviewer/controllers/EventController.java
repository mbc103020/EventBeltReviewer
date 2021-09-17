package com.eventbeltreviewer.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventbeltreviewer.models.Event;
import com.eventbeltreviewer.services.EventService;

@Controller
public class EventController {
	
	private final EventService eventService; 
	
	public EventController(EventService eventService) {
		this.eventService = eventService; 
	}
	
	@RequestMapping("/event")
	public String eventsHome(Model model, @ModelAttribute("event") Event event) {
		List<Event> events = this.eventService.allEvents(); 
		model.addAttribute("events", events); 
		return "/events/eventsHome.html"; 
	}
	
	@PostMapping("/events/newEvent")
	public String createNewLanguage(
			@Valid Event event, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "/events/eventsHome.html"; 
		} else {
			this.eventService.createEvent(event); 
			return "redirect:/events/eventsHome.html"; 
		}	
	}
	
	

}
