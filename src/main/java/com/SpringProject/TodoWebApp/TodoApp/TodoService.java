package com.SpringProject.TodoWebApp.TodoApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service 
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	public static int  count =0;
	
     static{
    	 todos.add(new Todo(++count,"Prajot","java",
    			 LocalDate.now().plusYears(2),false));
    	 todos.add(new Todo(++count,"Prajot","java",
    			 LocalDate.now().plusYears(2),false));
    	 todos.add(new Todo(++count,"Prajot","java",
    			 LocalDate.now().plusYears(2),false));
    	 todos.add(new Todo(++count,"Prajot","java",
    			 LocalDate.now().plusYears(2),false));
     }
     
     public List<Todo> findbyusername(String username){
    	 //username = "Prajot"
    	 
    	 Predicate<? super Todo> Predicate = 
    			 todo -> todo.getUsername().equals(username);
    	 return todos.stream().filter(Predicate).toList();
     }
     
     

	public void addtodo(String name, String description, LocalDate plusYears, boolean done) {
		// TODO Auto-generated method stub
		 Todo todo = new Todo(++count, name, description, plusYears,  done);
    	 todos.add(todo);
		
	}
	
	public void deletetodo(int id) {
		
		Predicate<? super Todo> Predicate = todo -> todo.getId() == id;
		todos.removeIf(Predicate); 
	}
	
	



	public Todo findbyid(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> Predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(Predicate).findFirst().get();
		return todo;
	}



	public void Updatetodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		
		deletetodo(todo.getId());
		todos.add(todo);
		
	}
	
	
}
