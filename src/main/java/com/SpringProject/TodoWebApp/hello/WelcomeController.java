package com.SpringProject.TodoWebApp.hello;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {   
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String gotWelcomepage(ModelMap model) {
		model.put("name", getloggedusername());
		return "Welcome";     
	}
	
	private String getloggedusername(){
		
		Authentication auth =	SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	

} 
