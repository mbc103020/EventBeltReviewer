package com.eventbeltreviewer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

//@RequestMapping("/login")
//public String getLogin(@ModelAttribute("user") User user) { 
//	return "login";
//}
//
//@PostMapping("/login")
//public String Login(@Valid User user, BindingResult result,) {
//
//}
}
