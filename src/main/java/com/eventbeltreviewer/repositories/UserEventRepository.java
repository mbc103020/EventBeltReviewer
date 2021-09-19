package com.eventbeltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eventbeltreviewer.models.UserEvent;

public interface UserEventRepository extends CrudRepository<UserEvent, Long>{

}
