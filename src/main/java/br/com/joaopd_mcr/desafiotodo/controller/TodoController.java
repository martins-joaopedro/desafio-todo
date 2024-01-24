package br.com.joaopd_mcr.desafiotodo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopd_mcr.desafiotodo.entity.Todo;
import br.com.joaopd_mcr.desafiotodo.service.TodoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo create (@RequestBody Todo todo) {
        return this.todoService.create(todo);
    }

    @GetMapping
    public List<Todo> list() {
        return this.todoService.list();
    }

    @GetMapping("{id}")
    public Todo listOneTodo(@PathVariable Long id) {
        return this.todoService.listOneTodo(id);
    }

    @PutMapping
    public void update(@RequestBody Todo todo) {
        this.todoService.update(todo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.todoService.delete(id);
    }
}
