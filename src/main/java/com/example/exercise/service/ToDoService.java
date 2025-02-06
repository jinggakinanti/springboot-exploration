package com.example.exercise.service;

import com.example.exercise.entity.ToDo;

import java.util.List;

public interface ToDoService {
    ToDo toDoService(String name) throws Exception;
    List<ToDo> getAllToDo();
    Boolean deleteToDo(String id);
    ToDo searchToDo(String id);
}
