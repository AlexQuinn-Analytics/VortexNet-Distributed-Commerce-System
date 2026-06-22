package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable long id){
        return todoService.findById(id);
    }
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.save(todo);
    }
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id); // 确保我们更新的是正确的ID
        return todoService.save(todo);
    }
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
        return "ID为 " + id + " 的待办事项已成功删除。";
    }
}
