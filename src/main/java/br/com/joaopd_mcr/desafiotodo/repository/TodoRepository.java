package br.com.joaopd_mcr.desafiotodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaopd_mcr.desafiotodo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
