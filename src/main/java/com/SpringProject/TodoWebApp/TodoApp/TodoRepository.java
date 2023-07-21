package com.SpringProject.TodoWebApp.TodoApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	public List<Todo> findByusername(String username);
	
}
