package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Todo {

	private String id;
	private String title;
	private boolean completed;

	public Todo() {
	}

	public Todo(String id, String title, boolean completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}

class NewTodoRequest {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/todos")
class TodosRestController {

	private final List<Todo> todos = new ArrayList<>();

	public TodosRestController() {
		todos.add(new Todo("1", "Learn Spring Boot", true));
		todos.add(new Todo("2", "Learn React", false));
	}

	@GetMapping
	public List<Todo> getTodos() {
		return todos;
	}

	@PostMapping
	public Todo createTodo(@RequestBody NewTodoRequest todo) {
		Todo newTodo = new Todo(String.valueOf(todos.size() + 1), todo.getTitle(), false);
		todos.add(newTodo);
		return newTodo;
	}

	@DeleteMapping("/:id")
	public void deleteTodo(@PathVariable String id) {
		todos.removeIf(todo -> todo.getId().equals(id));
	}

}

@SpringBootApplication
public class TodosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosServiceApplication.class, args);
	}

	// cors configuration
	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// return new WebMvcConfigurer() {
	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/api/todos/**").allowedOrigins("http://localhost:5173");
	// }
	// };
	// }

}
