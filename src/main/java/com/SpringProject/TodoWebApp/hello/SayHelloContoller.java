package com.SpringProject.TodoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloContoller{
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hello! Whats About Today- Changed";
	}
	
	@RequestMapping("say-hello-jsp")
//	@ResponseBody
//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	public String SayHelloJSP() {
		return "sayHello";
	}
	
	

}
