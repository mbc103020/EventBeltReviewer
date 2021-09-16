package com.eventbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eventbeltreviewer.models.User;

public interface UserRepository  extends CrudRepository<User, Long>{
List<User> findAll();
User findByEmail(String email);
}
