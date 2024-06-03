package com.example.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.NewTodoRequest;
import com.example.entity.Todo;
import com.example.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequiredArgsConstructor
public class TodosRestController {

    private final TodoRepository todoRepository;

    // GET /api/v1/todos
    @GetMapping(value = "/api/v1/todos", produces = "application/json")
    public ResponseEntity<?> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        ResponseEntity<List<Todo>> responseEntity = ResponseEntity.ok(todos);
        return responseEntity;
    }

    // GET /api/v1/todos/{id}
    @GetMapping(value = "/api/v1/todos/{id}", produces = "application/json")
    public ResponseEntity<?> getTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todo);
    }

    // HEAD /api/v1/todos/{id}
    @RequestMapping(value = "/api/v1/todos/{id}", produces = "application/json", method = RequestMethod.HEAD)
    public ResponseEntity<?> getTodoHeaders(@PathVariable Integer id) {
        // send response with headers
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header("X-Todo-Title", todo.getTitle())
                .header("X-Todo-Completed", String.valueOf(todo.isCompleted())).build();
    }

    // POST /api/v1/todos
    @PostMapping(value = "/api/v1/todos", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createTodo(@RequestBody NewTodoRequest newTodoRequest) {
        Todo todo = new Todo();
        todo.setTitle(newTodoRequest.getTitle());
        todo.setCompleted(newTodoRequest.isCompleted());
        todo = todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    // PUT /api/v1/todos/{id}
    @PutMapping(value = "/api/v1/todos/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody NewTodoRequest newTodoRequest) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        todo.setTitle(newTodoRequest.getTitle());
        todo.setCompleted(newTodoRequest.isCompleted());
        todo = todoRepository.save(todo);
        return ResponseEntity.ok(todo);
    }

    // PATCH /api/v1/todos/{id}
    @PatchMapping(value = "/api/v1/todos/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateTodoPartially(@PathVariable Integer id, @RequestBody NewTodoRequest newTodoRequest) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        if (newTodoRequest.getTitle() != null) {
            todo.setTitle(newTodoRequest.getTitle());
        }
        if (newTodoRequest.isCompleted()) {
            todo.setCompleted(newTodoRequest.isCompleted());
        }
        todo = todoRepository.save(todo);
        return ResponseEntity.ok(todo);
    }

    // DELETE /api/v1/todos/{id}
    @DeleteMapping(value = "/api/v1/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        todoRepository.delete(todo);
        return ResponseEntity.noContent().build();
    }

}
