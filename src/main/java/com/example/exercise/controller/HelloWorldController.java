package com.example.exercise.controller;

import com.example.exercise.model.BaseResponse;
import com.example.exercise.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/example")
@RequiredArgsConstructor
public class HelloWorldController {

  private final HelloWorldService helloWorldService;

  @GetMapping(value="/hello-world")
  public ResponseEntity<BaseResponse<String>> helloWorld(@RequestParam String name) {

    try {

      var result = helloWorldService.helloWorld(name);
      // test
      // test once more
      /// adssaddsa
      var responseBody = BaseResponse.<String>builder().data(result).status(HttpStatus.OK.toString()).build();
      return ResponseEntity.ok(responseBody);

    } catch (Exception e) {

      var badResponseBody = BaseResponse.<String>builder()
          .message(e.getMessage())
          .status(HttpStatus.BAD_REQUEST.toString())
          .build();
      return ResponseEntity.badRequest().body(badResponseBody);

    }

  }
}
