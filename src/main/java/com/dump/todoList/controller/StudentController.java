package com.dump.todoList.controller;

import com.dump.todoList.entity.TodoItem;

import java.util.List;

import com.dump.todoList.repository.TodoRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/todo")
public class StudentController {

    @Autowired
    private TodoRepository todoRepo;

    @GetMapping
    public List<TodoItem> getStudents(){
        return todoRepo.findAll();
    }

    @PostMapping
    public TodoItem save(@NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value="/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoRepo.deleteById(id);
    }

}
