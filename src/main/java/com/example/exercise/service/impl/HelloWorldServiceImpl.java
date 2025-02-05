package com.example.exercise.service.impl;

import com.example.exercise.service.HelloWorldService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
  @Override
  public String helloWorld(String name) throws Exception {

    if (Strings.isEmpty(name)) {
      throw new Exception("name can't be empty");
    }

    return String.format("Greetings %s!", name);
  }
}
