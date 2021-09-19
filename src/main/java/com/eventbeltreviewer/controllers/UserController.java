package com.eventbeltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eventbeltreviewer.models.User;
import com.eventbeltreviewer.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;

public static final String[] states = {
		"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",	"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
};

@RequestMapping("/registration")
public String register(@ModelAttribute("user") User user, Model model) {
	model.addAttribute("states", states);
	return "user/registration";
}
@PostMapping("/registration")
public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
if(result.hasErrors()) {
	model.addAttribute("states", states);
	return "user/registration";
}else {
	User u = userService.registerUser(user);
	session.setAttribute("userId", u.getId());
	return "redirect:/user/login";
}
}
@RequestMapping("/login")
public String Login(@ModelAttribute("user") User user) { 
	return "user/login";
}

 //post login info to check for correct credentials if pass then will redirect if fail will recieve error message 
@RequestMapping(value="/login", method=RequestMethod.POST)
public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    // if the user is authenticated, save their user id in session
    // else, add error messages and return the login page
	boolean isAuthenticated = userService.authenticateUser(email, password);
	if(isAuthenticated) {
		User u = userService.findByEmail(email);
		session.setAttribute("userId", u.getId());
		return "redirect:/home";
	}else {
		model.addAttribute("error", "Invalid Credentials");
		return "user/login";
	}
}



}
