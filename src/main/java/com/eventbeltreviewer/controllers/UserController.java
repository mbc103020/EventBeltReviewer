package com.eventbeltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventbeltreviewer.models.User;
import com.eventbeltreviewer.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;

@RequestMapping("/registration")
public String register(@ModelAttribute("user") User user) {
	return "user/registration";
}
@PostMapping("/registration")
public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
if(result.hasErrors()) {
	return "user/registration";
}else {
	User u = userService.registerUser(user);
	session.setAttribute("userId", u.getId());
	return "redirect:/user/registration";
}
}
@RequestMapping("/login")
public String Login(Model model) { 
	
	return "user/login";
}


}
