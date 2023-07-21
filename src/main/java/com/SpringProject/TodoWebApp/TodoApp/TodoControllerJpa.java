package com.SpringProject.TodoWebApp.TodoApp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	
	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todo")
	public String Todoprint(ModelMap model) {
		String username = getloggedInUsername(model);
		
		List<Todo> todo = todoRepository.findByusername(username);
		model.put("todo", todo);
		return "ListTodo";
	}

	
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String ShowNewtodo(ModelMap model) {
		String username = getloggedInUsername(model);
		
		Todo todos = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todos);
		return "newtodo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewtodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "newtodo";
		}
		String name = getloggedInUsername(model);
		todo.setUsername(name);
		todoRepository.save(todo);
		//todoes.addtodo(name, todo.getDescription(), todo.getDate(), false);
		return "redirect:list-todo";
	}
	
	@RequestMapping("delete-todo")
	public String DeleteTodo(@RequestParam int  id) {
		todoRepository.deleteById(id);
		//todoes.deletetodo(id);	
		return "redirect:list-todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodo(@RequestParam int  id,ModelMap model) {
//		todoes.deletetodo(id);
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute(todo);
		return "newtodo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updatetodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newtodo";
		}
		String username = getloggedInUsername(model);
		todo.setUsername(username);
		
		todoRepository.save(todo);
		//todoes.Updatetodo(todo);
		
		return "redirect:list-todo";
	}
	
	
	private String getloggedInUsername(ModelMap model) {
		Authentication auth =	SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

}
