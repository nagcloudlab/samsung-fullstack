package com.example;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Query;

@Document(collection = "todos")
@Data
class Todo {

	@Id
	private String id;
	private String title;
	private boolean completed;

	public Todo() {
	}

	public Todo(String title, boolean completed) {
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

interface TodoRepository extends org.springframework.data.mongodb.repository.MongoRepository<Todo, String> {

	@Query("{ 'title' : ?0 }")
	Todo findByxxx(String title);
	java.util.List<Todo> findByCompleted(boolean completed);

}

@SpringBootApplication
public class SpringBootWithMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongodbApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(TodoRepository repository) {
		return (args) -> {
			//repository.deleteAll();

//			// save a couple of customers
//			repository.save(new Todo("Buy milk", false));
//			repository.save(new Todo("Buy bread", false));
//			repository.save(new Todo("Buy butter", false));

			// fetch all customers
//			System.out.println("Todos found with findAll():");
//			System.out.println("-------------------------------");
//			for (Todo todo : repository.findAll()) {
//				System.out.println(todo);
//			}
//			System.out.println();

//			// fetch an individual customer
			System.out.println("Todo found with findByTitle('Buy milk'):");
			System.out.println("--------------------------------");
			System.out.println(repository.findByxxx("Buy milk"));
//
//			System.out.println("Todos found with findByCompleted(false):");
//			System.out.println("--------------------------------");
//			for (Todo todo : repository.findByCompleted(false)) {
//				System.out.println(todo);
//			}
		};
	}

}
