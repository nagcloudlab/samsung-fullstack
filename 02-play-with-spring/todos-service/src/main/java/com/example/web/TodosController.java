package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Todo;
import com.example.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodosController {

    private final TodoRepository todoRepository;

    // @GetMapping("/todos")
    // public ModelAndView getTodos() {
    // List<Todo> todos = todoRepository.findAll();
    // ModelAndView modelAndView = new ModelAndView();
    // modelAndView.setViewName("todos");
    // modelAndView.addObject("todos", todos);
    // return modelAndView;
    // }

    @GetMapping("/view-todos")
    public String getTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(
            @RequestParam("id") Integer id) {
        todoRepository.deleteById(id);
        return "redirect:/view-todos";
    }

    @PostMapping("/create-todo")
    public String createTodo(
            @RequestParam("title") String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todoRepository.save(todo);
        return "redirect:/view-todos";
    }

}
