package com.example.demo.service;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todoList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    public TodoService(){
        todoList.add(new Todo(counter.incrementAndGet(),"学习Spring Boot", false));
        todoList.add(new Todo(counter.incrementAndGet(), "完成课后作业", false));
    }

    public List<Todo> findAll(){
        return todoList;
    }

    public Todo findById(Long id){
        return todoList.stream()
                .filter(todo -> Objects.equals(todo.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Todo save(Todo todo){
        if (todo.getId() == null){
            todo.setId(counter.incrementAndGet());
            todoList.add(todo);
        }else{
            Todo existingTodo = findById(todo.getId());
            if (existingTodo != null){
                existingTodo.setId(todo.getId());
                existingTodo.setCompleted(todo.isCompleted());
            }
        }
        return todo;
    }

    public void deleteById(Long id) {
        todoList.removeIf(todo -> Objects.equals(todo.getId(), id));
    }
}
