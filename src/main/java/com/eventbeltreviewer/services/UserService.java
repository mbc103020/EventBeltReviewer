package com.eventbeltreviewer.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eventbeltreviewer.models.User;
import com.eventbeltreviewer.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
private final UserRepository userRepository;
private BCryptPasswordEncoder bCryptPasswordEncoder;

public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	this.userRepository = userRepository;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

public void createUser(User user) { 
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	userRepository.save(user);
}

public User findById(Long id) { 
	Optional<User> optional = userRepository.findById(id);
if( optional.isPresent() ) {
	return optional.get();
} else {
	return null;
	
}
}
}
