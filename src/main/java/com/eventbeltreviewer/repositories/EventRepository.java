package com.eventbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eventbeltreviewer.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll(); 

}
