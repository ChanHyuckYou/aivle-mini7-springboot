package com.example.aivlemini7springboot;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

  @CrossOrigin(origins = "http://example.com") // 이 오리진에서의 요청을 허용
  @GetMapping("/example")
  public String example() {
    return "Example response";
  }
}
