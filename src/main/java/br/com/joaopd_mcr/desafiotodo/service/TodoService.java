package br.com.joaopd_mcr.desafiotodo.service;
import org.springframework.stereotype.Service;

import br.com.joaopd_mcr.desafiotodo.entity.Todo;
import br.com.joaopd_mcr.desafiotodo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        this.todoRepository.save(todo);
        
        return list();
    }

    public List<Todo> list() {
        return todoRepository.findAll();
    }

    public Todo listOneTodo(Long id) {
        System.out.println(todoRepository.findById(id).get());
        return todoRepository.findById(id).get();
    }

    public List<Todo> update(Todo todo) {
        this.todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        this.todoRepository.deleteById(id);
        return list();
    }
}
