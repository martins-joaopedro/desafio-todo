package br.com.joaopd_mcr.desafiotodo.service;
import org.springframework.data.domain.Sort;
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
        Sort sorted = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );

        return todoRepository.findAll(sorted);
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
