package com.example.exercise.service.impl;

import com.example.exercise.entity.ToDo;
import com.example.exercise.service.ToDoService;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Data
public class ToDoServiceImpl implements ToDoService {
    private final List<ToDo> ToDoList = new ArrayList<>();
    public ToDoServiceImpl(){
        ToDoList.add(new ToDo("Finish assignment", UUID.randomUUID().toString()));
        ToDoList.add(new ToDo("Pick up groceries", UUID.randomUUID().toString()));
        ToDoList.add(new ToDo("Return book to the library", UUID.randomUUID().toString()));
//        ToDoList.add(new ToDo("Test", "222"));
    }
    @Override
    public ToDo toDoService(String name) throws Exception {
        if(Strings.isEmpty(name)){
            throw new Exception("Please insert activity");
        }
        ToDo toDo = new ToDo(name, UUID.randomUUID().toString());
//        ToDoList.add(toDo);
        return toDo;
    }
    @Override
    public List<ToDo> getAllToDo()  {
//        if(getToDoList().isEmpty()){
//            throw new Exception("There's no activity");
//        }
        return getToDoList();
    }
    @Override
    public Boolean deleteToDo(String id) {
        for(ToDo list : ToDoList){
            if(list.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ToDo searchToDo(String id) {
        for(ToDo list : ToDoList){
            if(list.getId().equals(id)){
                return list;
            }
        }
        return null;
    }
}

/*

ToDoService SERVICE_BEAN = new ToDoServiceImpl();

 */
