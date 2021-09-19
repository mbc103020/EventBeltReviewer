//package com.eventbeltreviewer.validators;
//
//import javax.validation.Validator;
//
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.eventbeltreviewer.models.User;
//import com.eventbeltreviewer.repositories.UserRepository;
//
//@Component
//public class UserValidator implements Validator{
//	
//	@Autowired
//	private UserRepository userRepository;
//	@Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//    
//    @Override
//    public void validate(Object target, Errors errors) {
//        User u = (User) target;    
//        if (!u.getConfirmPassword().equals(u.getPassword())) {
//            errors.rejectValue("passwordConfirmation", "Match");
//        }         
//    }	
//	
//}
