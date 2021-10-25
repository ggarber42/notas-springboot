package com.dump.todoList.service;

import com.dump.todoList.entity.TodoItem;
import com.dump.todoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    public List<TodoItem> getAllTodos(){
        return todoRepo.findAll();
    }

    public TodoItem getTodoItemByID(Long id){
        try{
            return todoRepo.getById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public String createTodoItem(TodoItem todoItem){
        try {
            todoItem.setDone(false);
            todoRepo.save(todoItem);
                return "Student record created successfully.";
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public String updateTodoItem(Long id){
        try{
            TodoItem todoItem = todoRepo.getById(id);
            todoItem.setDone(!todoItem.getDone());
            return "TodoItem updated!";
        }catch (Exception e){
           throw e;
        }
    }

    @Transactional
    public String deleteTodoItem(Long id){
        try {
            todoRepo.deleteById(id);
            return "Student record deleted successfully.";
        }catch (Exception e){
            throw e;
        }
    }
}
