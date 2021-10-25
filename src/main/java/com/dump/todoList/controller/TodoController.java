package com.dump.todoList.controller;

import com.dump.todoList.entity.TodoItem;

import java.util.List;

import com.dump.todoList.service.TodoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoItem> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping(value="/{id}")
    public TodoItem getTodo(@PathVariable("id") Long id){
        return todoService.getTodoItemByID(id);
    }

    @PostMapping
    public String createTodoItem(@NotNull @RequestBody TodoItem todoItem){
        return todoService.createTodoItem(todoItem);
    }

    @PutMapping(value="/{id}")
    public String updateTodoItem(@PathVariable Long id){
        return todoService.updateTodoItem(id);
    }

    @DeleteMapping(value="/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodoItem(id);
    }

}
