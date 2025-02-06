package com.example.exercise.controller;

import com.example.exercise.entity.ToDo;
import com.example.exercise.model.BaseResponse;
import com.example.exercise.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/to-do")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping(value = "/list")
    public ResponseEntity<BaseResponse<List<ToDo>>> getToDo() {

        List<ToDo> ToDoList = toDoService.getAllToDo();
        var responseBody = BaseResponse.<List<ToDo>>builder().data(ToDoList)
                .status(HttpStatus.OK.name())
                .message("You are seeing all to-do lists!")
                .build();
        return ResponseEntity.ok(responseBody);
    }
    @PostMapping(value = "/list")
    public ResponseEntity<BaseResponse<ToDo>> createToDo(@RequestParam String name) {

        try {
            ToDo result = toDoService.toDoService(name);
            var responseBody = BaseResponse.<ToDo>builder().data(result)
                    .status(HttpStatus.OK.name())
                    .message("Successful insert")
                    .build();
            return ResponseEntity.ok(responseBody);

        } catch (Exception e) {

            var badResponseBody = BaseResponse.<ToDo>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.toString())
                    .build();
            return ResponseEntity.badRequest().body(badResponseBody);
        }
    }
    @DeleteMapping(value = "/list")
    public ResponseEntity<BaseResponse<Boolean>> deleteToDo(@RequestParam String id){

        Boolean toDel = toDoService.deleteToDo(id);
        if(toDel){
//            ToDo result = toDoService.searchToDo(id);
            var responseBody = BaseResponse.<Boolean>builder().data(toDel)
                    .status(HttpStatus.OK.name())
                    .message("Deleting this data")
                    .build();
            return ResponseEntity.ok(responseBody);
        }else{
                var badResponseBody = BaseResponse.<Boolean>builder()
                    .status(HttpStatus.BAD_REQUEST.toString())
                    .message("This data doesn't exist or already deleted")
                        .data(toDel)
                    .build();
            return ResponseEntity.badRequest().body(badResponseBody);
        }
    }
}
